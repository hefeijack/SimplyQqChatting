/**
 * ���ǿͻ������ӷ������ĺ�̨
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
	
	//���͵�һ������
	public boolean sendLoginInfoToServlet(Object o){
		
		boolean b = false;
		
		try {
			
			s = new Socket("127.0.0.1", 9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			Message ms = (Message) ois.readObject();
			//���������֤�û���¼�ĵط�
			if(ms.getMesType().equals("1")){
				//�ʹ���һ����qq�źͷ���������ͨѶ���ӵ��߳�
				ClientConServerThread ccst = new ClientConServerThread(s);
				//������ͨѶ�߳�
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
