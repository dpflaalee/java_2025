package com.company.java012;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// 클래스는 부품객체.			  멤버변수 / 멤버함수 
//클래스는 조립(OOP)해서 사용한다

class MyView implements ActionListener{
	//멤버변수(frame/button) 부품 - ctrl shift o
	JFrame frame; JButton button; // static 붙었는지 확인하고 안붙었으면 new로 사용...
	//멤버함수
	public MyView() {
		frame = new JFrame("BOX");
		button = new JButton("BUTTON");	}
	public void create() {
		//2-1 frame.add(컴포턴트)
		frame.add(button);
		//2-2 frame.size(가로, 세로)
		frame.setSize(300,300);
		//2-3 frame.setVisible
		frame.setVisible(true);	
	
		button.addActionListener(this);//이벤트 대상.이벤트(핸들러);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 발생 시 처리
		JOptionPane.showMessageDialog(null, "click!");
	}
	
}
public class NoNameClass002 {
	public static void main(String[] args) {
		new MyView().create();
	}
}
