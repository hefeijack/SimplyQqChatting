/**
 * 这是客户端与服务器保持通讯的线程
 */

package com.qq.client.tools;

import java.net.*;
import java.io.*;

import com.qq.client.view.QqChat;
import com.qq.common.Message;

public class ClientConServerThread extends Thread {

	private Socket s;
	
	//构造函数
	public ClientConServerThread(Socket s){
		this.s = s;
	}
	
	public void run(){
		while(true){
			//不停的读取从服务器端发来的消息
			try{
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m = (Message)ois.readObject();
				System.out.println("读取到从服务器发来的消息！" + m.getSender() + " 给  " + m.getGetter() + "  内容    " + m.getCon());
			
				//把从服务器获得消息，显示到聊天界面
				QqChat qqChat = ManageQqChat.getQqChat(m.getGetter() + " " + m.getSender());
			
				//显示
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
