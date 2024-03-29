package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ServerInputFrame  extends JFrame implements ActionListener{
	private JTextField ip_input;
	private JTextField port_input;
	private JTextField name_input;
	private JLabel title_text;
	private JLabel ip_text;
	private JLabel port_text;
	private JLabel name_text;
	private JLabel back_img;
	private JLabel home_img;
	private JButton start_btn;
	String hostAddress;

	ServerSocket serverSocket;

	Socket socket;

	DataInputStream dis;

	DataOutputStream dos;

	private Font font1, font2, font3;
	public ServerInputFrame() {	
		setBounds(430, 0, 414, 736);
		setLayout(null);	
		setTitle("SERVER ������ �Է��ϼ���");
		
		JPanel panel = new JPanel();
        setContentPane(panel);
		panel.setBackground(new Color(255,235,51));
		panel.setLayout(null);
		
		//input
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("���� ��ǲ" + hostAddress);
		

		font1 = new Font("����", Font.PLAIN, 25);
		font2 = new Font("����", Font.PLAIN, 40);
		font3 = new Font("����", Font.PLAIN, 50);
		
		ip_input = new JTextField(hostAddress);
		port_input = new JTextField();
		name_input = new JTextField();
		
		ip_input.setBounds(93, 262, 291, 58);
		port_input.setBounds(93, 319, 291, 58);
		name_input.setBounds(93, 401, 290, 53);
		
		ip_input.setColumns(20);
		port_input.setColumns(10);
		name_input.setColumns(20);
		
		ip_input.setFont(font1);
		port_input.setFont(font1);
		name_input.setFont(font1);
		
		panel.add(ip_input);		
		panel.add(port_input);
		panel.add(name_input);
		
		//text
		title_text = new JLabel("kakao talk");
		ip_text = new JLabel("IP");
		port_text = new JLabel("PORT");
		name_text = new JLabel("�̸�");
		
		title_text.setBounds(74, 165, 265, 68);
		ip_text.setBounds(21, 267 ,53, 48);
		port_text.setBounds(2, 324 ,91, 48);
		name_text.setBounds(21, 413,52,30);
			
		panel.add(title_text);
		panel.add(ip_text);
		panel.add(port_text);	
		panel.add(name_text);
		
		title_text.setFont(font3);
		ip_text.setFont(font1);
		port_text.setFont(font1);
		name_text.setFont(font1);
		
		//btn
		start_btn = new JButton("�� �����");
		start_btn.setFont(font2);
		start_btn.setBounds(76, 542, 262, 67);
		start_btn.setBackground(new Color(246, 246, 246));
		panel.add(start_btn);
		
		//img
		back_img = new JLabel();
		home_img = new JLabel("");
		
		back_img.setBounds(12,26,40,40);
		home_img.setBounds(243, 26, 40,40);
	
		panel.add(back_img);
		add(home_img);
		
		start_btn.addActionListener(this);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(start_btn)) {
			String name = name_input.getText().toString();
			String ip = ip_input.getText().toString();
			String port = port_input.getText().toString();
			
			ServerFrame b = new ServerFrame(name,ip,port);
		}
	}
}

