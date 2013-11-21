/**
 * ���ܣ�qq��½����
 */

package com.qq.client.view;

import javax.swing.*;

import com.qq.client.model.QqClientUser;
import com.qq.common.User;

import java.awt.*;
import java.awt.event.*;

public class QqClientLogin extends JFrame implements ActionListener {

	//���山����Ҫ�����
		JLabel jbl1;
		
		//�����в���Ҫ�����
		//�в�������JPanel����һ����ѡ����ڹ���
		JTabbedPane jtp;
		JPanel jp2, jp3, jp4;
		JLabel jp2_jbl1, jp2_jbl2, jp2_jbl3, jp2_jbl4;
		JButton jp2_jb1;
		JTextField jp2_jtf;
		JPasswordField jp2_jpf;
		JCheckBox jp2_jcb1, jp2_jcb2;
		
		//�����ϲ���Ҫ�����
		JPanel jp1;
		JButton jp1_jb1, jp1_jb2, jp1_jb3;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			QqClientLogin qqClientLogin = new QqClientLogin();
			
		}
		
		public QqClientLogin(){
			//������
			jbl1 = new JLabel(new ImageIcon("imgs/tou.gif"));
			
			//�����в�
			jp2 = new JPanel(new GridLayout(3, 3));
			jp2_jbl1 = new JLabel("QQ����", JLabel.CENTER);
			jp2_jbl2 = new JLabel("QQ����", JLabel.CENTER);
			jp2_jbl3 = new JLabel("��������", JLabel.CENTER);
			jp2_jbl3.setForeground(Color.red);
			jp2_jbl4 = new JLabel("�������뱣��", JLabel.CENTER);
			
			jp2_jb1 = new JButton(new ImageIcon("imgs/clear.gif"));
			jp2_jtf = new JTextField();
			jp2_jpf = new JPasswordField();
			
			jp2_jcb1 = new JCheckBox("�����½");
			jp2_jcb2 = new JCheckBox("��ס����");
			
			//�ѿؼ�����˳����뵽jp2
			jp2.add(jp2_jbl1);
			jp2.add(jp2_jtf);
			jp2.add(jp2_jb1);
			jp2.add(jp2_jbl2);
			jp2.add(jp2_jpf);
			jp2.add(jp2_jbl3);
			jp2.add(jp2_jcb1);
			jp2.add(jp2_jcb2);
			jp2.add(jp2_jbl4);
			//����ѡ�����
			jtp = new JTabbedPane();
			
			jtp.add("QQ����", jp2);
			jp3 = new JPanel();
			jtp.add("�ֻ�����", jp3);
			jp4 = new JPanel();
			jtp.add("�����ʼ�", jp4);
			
			//�����ϲ�
			jp1 = new JPanel();
			
			jp1_jb1 = new JButton(new ImageIcon("imgs/denglu.gif"));
			//��Ӧ�û������¼
			jp1_jb1.addActionListener(this);
			jp1_jb2 = new JButton(new ImageIcon("imgs/quxiao.gif"));
			jp1_jb3 = new JButton(new ImageIcon("imgs/xiangdao.gif"));
			
			//��������ť���뵽jp1
			jp1.add(jp1_jb1);
			jp1.add(jp1_jb2);
			jp1.add(jp1_jb3);
			
			this.add(jbl1, "North");
			this.add(jtp, "Center");
			this.add(jp1, "South");
			this.setSize(300, 350);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource() == jp1_jb1){
//				MyQqClientConServer
				QqClientUser qqClientUser = new QqClientUser();
				User u = new User();
				u.setUserId(jp2_jtf.getText().trim());
				u.setPasswd(new String(jp2_jpf.getPassword()));
				
				if(qqClientUser.checkUser(u)){
					new QqFriendList(u.getUserId());
					//�رյ�¼����
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(this, "�û����������");
				}
				
			}
		}

}
