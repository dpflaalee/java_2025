package com.company.java016;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Network002_Client {
	public static void main(String[] args) {
		
		//2.고객이 통신사에 연락 - 7703 / 192.168.40.95
		Socket socket = null;
		try {
			socket = new Socket("192.168.40.95",7703);
			System.out.println("A/S센터 고객문의");
			
			//4. 데이터 주고받기
			Thread sender = new Sender(socket); sender.start();
			Thread receiver = new Receiver(socket); receiver.start();
			
			
		} catch (UnknownHostException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
		
		

		
	}//EM
}//EC
