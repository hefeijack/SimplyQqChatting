/**
 * ����qq�����������ڼ������ȴ�ĳ��qq�ͻ��ˣ�������
 */

package com.qq.server.model;

import java.net.*;
import java.io.*;
import java.util.*;

import com.qq.common.Message;
import com.qq.common.User;

public class MyQqServer {

	public MyQqServer(){
		try{
			//��9999����
			System.out.println("���Ƿ���������9999����");
			ServerSocket ss = new ServerSocket(9999);
			//�������ȴ�����
			while(true){
				Socket s = ss.accept();
				//���տͻ��˷�������Ϣ
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u = (User)ois.readObject();
				
				System.out.println("���������յ��û�id �� " + u.getUserId() + "  ���� �� " + u.getPasswd());
				
				Message ms = new Message();
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("123456")){
					//����һ���ɹ���¼����Ϣ��
					ms.setMesType("1");
					oos.writeObject(ms);
					//����͵���һ���̣߳��ø��߳���ÿͻ��˱���ͨѶ
					SerConClientThread scct = new SerConClientThread(s);
					ManageClientThread.addClientThread(u.getUserId(), scct);
					//������ÿͻ���ͨѶ���߳�
					scct.start();
					
				}else{
					ms.setMesType("2");
					oos.writeObject(ms);
					//�ر�����
					s.close();
				}
								
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	}
	
}
