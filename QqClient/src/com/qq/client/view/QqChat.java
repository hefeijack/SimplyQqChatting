/**
 * �������������Ľ���
 * ��Ϊ�ͻ���Ҫ���ڶ�ȡ��״̬��������ǰ�������һ���߳�
 */

package com.qq.client.view;

import javax.swing.*;

import com.qq.client.model.QqClientConServer;
import com.qq.client.tools.ManageClientConServerThread;
import com.qq.common.Message;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class QqChat extends JFrame implements ActionListener {

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	
	String ownerId;
	String friendId;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		QqChat qqChat = new QqChat("1");
	}
	
	public QqChat(String ownerId, String friend){
		
		this.ownerId = ownerId;
		this.friendId = friend;
		
		jta = new JTextArea();
		jtf = new JTextField(15);
		jb = new JButton("����");
		jb.addActionListener(this);
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta, "Center");
		this.add(jp, "South");
		this.setTitle(ownerId + " ���ں� " + friend + " ����");
		this.setIconImage(new ImageIcon("imgs/qq.gif").getImage());
		this.setSize(300, 200);
		this.setVisible(true);
		
	}

	//дһ��������������ʾ��Ϣ
	public void showMessage(Message m){
		//��ʾ
		String info = m.getSender() + " ��  " + m.getGetter() + " ˵  " + m.getCon() + "\r\n";
		this.jta.append(info);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == jb){
			//����û�����˷��Ͱ�ť
			Message m = new Message();
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setCon(jtf.getText());
			m.setSendTime(new java.util.Date().toString());
			
			//���͸�������
			try {
				ObjectOutputStream oos = new ObjectOutputStream(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
				oos.writeObject(m);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		while(true){
//			//��ȡ���������͵ȴ���
//			try {
//				ObjectInputStream ois = new ObjectInputStream(QqClientConServer.s.getInputStream());
//				
//				Message m = (Message) ois.readObject();
//				
//				//��ʾ
//				String info = m.getSender() + " ��  " + m.getGetter() + " ˵  " + m.getCon() + "\r\n";
//				this.jta.append(info);
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

}
