/**
 * 这是客户端连接服务器的后台
 */

package com.qq.client.model;

import java.util.*;
import java.net.*;
import java.io.*;

import com.qq.client.tools.ClientConServerThread;
import com.qq.client.tools.ManageClientConServerThread;
import com.qq.common.Message;
import com.qq.common.User;

public class QqClientConServer {
	
	public Socket s;
	
	//发送第一次请求
	public boolean sendLoginInfoToServlet(Object o){
		
		boolean b = false;
		
		try {
			
			s = new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			Message ms = (Message) ois.readObject();
			//这里就是验证用户登录的地方
			if(ms.getMesType().equals("1")){
				//就创建一个该qq号和服务器保持通讯连接的线程
				ClientConServerThread ccst = new ClientConServerThread(s);
				//启动该通讯线程
				ccst.start();
				ManageClientConServerThread.addClientConServerThread(((User)o).getUserId(), ccst);
				b = true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		return b;
	}
	
	public void SendInfoToServer(Object o){
		try {
			
			Socket s = new Socket("127.0.0.1", 9999);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}
	
}
