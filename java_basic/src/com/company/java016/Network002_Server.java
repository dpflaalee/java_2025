package com.company.java016;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Network002_Server {
	public static void main(String[] args) {
		//1. 서버소켓 [ , , , , ]
		ServerSocket ascenter = null;
		Socket socket;
		
		try {	
			ascenter = new ServerSocket(7703); // localhost 192.168.40.95 / port
			System.out.println("[SERVER] 1.서버준비완료 A/S 센터 OPEN...2.응답대기중");
			}catch(IOException e) {e.printStackTrace();}
		
		//3. 클라이언트 요청(accept) > 상담사(Socket) 연결
		try {
			socket=ascenter.accept(); // socket은 고객의 정보를 갖고 있음
			System.out.println("3. 응답받아 상담사와 연결");
			
			//4. 데이터 주고받기
			Thread sender = new Sender(socket); sender.start();
			Thread receiver = new Receiver(socket); receiver.start();
			
			}catch(IOException e) {e.printStackTrace();}

				
	}//EM
}//EC


//말하기기능 InputStream
class Sender extends Thread{
	Socket socket; DataOutputStream out; String who; SimpleDateFormat sdf;

	public Sender() { super(); }//디폴트 생성자는 Thread만
	public Sender(Socket socket) { 
		this.socket = socket; 
		try { 
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Hello.....START >>>");				
			this.who = "["+(socket.getPort()==7703? "Cilent" : "Server" );
			this.sdf = new SimpleDateFormat("hh:mm:ss]");
			
		}catch (IOException e) { e.printStackTrace(); }
	}
	
	@Override public void run() { 
//		Scanner sc = new Scanner(System.in);//표준입출력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(out != null) {
				String data = in.readLine();
				String time = sdf.format(System.currentTimeMillis());
				
				//out.writeUTF(in.readLine());
				out.writeUTF(who+time+data);
				
				}
		} catch (Exception e) { 
			//e.printStackTrace();		
			}finally {
				//한쪽이 연결을 종료했을 때 생기는 오류 해결 코드... Reciver쪽만 해도 오류는 없긴 한데 안정적으로 하려면 Sender도 처리해야
				try {
					if(out != null) {out.close();}
					if(in != null) {in.close();}
					if(!socket.isClosed()) {socket.close();}
					}catch (Exception e) { e.printStackTrace(); }
			}
	}

	
}//E.Sender

class Receiver extends Thread{
	Socket socket; DataInputStream in;

	public Receiver() { super(); }
	public Receiver(Socket socket) { 
		this.socket = socket;
		
		try { in = new DataInputStream(socket.getInputStream()); } 
		catch (IOException e) { e.printStackTrace(); }
	}
	
	@Override public void run() { 
		try {
			while ( in != null ) { // 들어온 값이 null이 아니면 계속 들을게
				//1 in :: 상대방이 말하는 걸 들음(프로그램상 들어오는 정보)
				System.out.println(in.readUTF());					}			
		}catch (Exception e) {System.out.println("통신을 종료합니다."+socket);
		}finally {	
			try {
				if(in != null) {in.close();}
				if(!socket.isClosed()) {socket.close();}}
			catch (Exception e) { e.printStackTrace();	}
			}
		}//E.R

} // E.Receiver