package org.sp.app0720.unicasting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

//다수의 접속 클라이언트들이, 각각 독립된 대화를 유지하기 위한 쓰레드 정의 
//쓰레드란? 하나의 프로세스 내에서 독립적으로 수행될 수 있는 또 하나의 세부 실행단위
public class ServerMessageThread extends Thread {
	Socket socket ;
	BufferedReader buffr;
	BufferedWriter buffw;
	
	JTextArea area;
	
	public ServerMessageThread(Socket socket, JTextArea area) {
		this.area=area;
		//얻어진 소켓으로부터 , 스트림을 얻어놓자 
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream())); 
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			
			String msg = null;
	
			try {
				// 클라이언의 말을 듣고
				msg = buffr.readLine();
				area.append(msg + "\n"); // 로그 남기기

				// 말하기
				buffw.write(msg + "\n");
				buffw.flush();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
