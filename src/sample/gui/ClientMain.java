package sample.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientMain extends JFrame{
	JPanel p_north;
	JComboBox box;
	JTextField t_port;
	JButton bt;
	
	JTextArea area;
	JScrollPane scroll;
	
	JTextField t_input;
	
	public ClientMain() {
		p_north = new JPanel();
		box = new JComboBox();
		t_port = new JTextField("7777", 6);
		bt = new JButton("접속");
		
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		t_input = new JTextField();
		
		//아이피 채워넣기
		box.addItem("192.168.1.220");
		
		//조립 
		p_north.add(box);
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		
		add(scroll);
		add(t_input, BorderLayout.SOUTH);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {//엔터치면..
					//서버에 메시지 전송
					send();
				}
			}
		});
	}
	
	//에코서버에 접속하기 
	public void connect() {

	}
	
	//서버에 메시지 보내기 
	public void send() {

	}
	
	public static void main(String[] args) {
		new ClientMain();
	}
}











