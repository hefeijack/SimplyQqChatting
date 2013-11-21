/**
 * ���ǿͻ��������������ͨѶ���߳�
 */

package com.qq.client.tools;

import java.net.*;
import java.io.*;

import com.qq.client.view.QqChat;
import com.qq.common.Message;

public class ClientConServerThread extends Thread {

	private Socket s;
	
	//���캯��
	public ClientConServerThread(Socket s){
		this.s = s;
	}
	
	public void run(){
		while(true){
			//��ͣ�Ķ�ȡ�ӷ������˷�������Ϣ
			try{
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message)ois.readObject();
				System.out.println("��ȡ���ӷ�������������Ϣ��" + m.getSender() + " ��  " + m.getGetter() + "  ����    " + m.getCon());
			
				//�Ѵӷ����������Ϣ����ʾ���������
				QqChat qqChat = ManageQqChat.getQqChat(m.getGetter() + " " + m.getSender());
			
				//��ʾ
				qqChat.showMessage(m);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}
	
}
