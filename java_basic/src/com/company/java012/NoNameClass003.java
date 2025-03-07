package com.company.java012;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// 클래스는 부품객체.			  멤버변수 / 멤버함수 
//클래스는 조립(OOP)해서 사용한다

class MyView2 {
	//멤버변수(frame/button) 부품 - ctrl shift o
	JFrame frame; JButton button; // static 붙었는지 확인하고 안붙었으면 new로 사용...
	//멤버함수
	public MyView2() {
		frame = new JFrame("BOX");
		button = new JButton("BUTTON");	}
	public void create() {
		//2-1 frame.add(컴포턴트)
		frame.add(button);
		//2-2 frame.size(가로, 세로)
		frame.setSize(300,300);
		//2-3 frame.setVisible
		frame.setVisible(true);	
	
		button.addActionListener(new ActionListener() { //interface는 new 불가능하지만
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "click!");
			}//2) 한번 쓰고 버릴 목적으로
		});//3) new 인터페이스명(){	implement 구현메서드	}	
	}
	
}
public class NoNameClass003 {
	public static void main(String[] args) {
		new MyView2().create();
	}
}
