package pack;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Window extends JFrame {
	
	//����� ������
	 private JPanel panel0;
	 //������ �������
	 private ProjectPanel panel1;
	 //������ ����������
	 private JPanel bottompanel;  
	 //������ ���������
	 JButton bt1=null;
	 //������� ��� ������ ����������
	 JLabel lb1=null;
	 
	 Window()
	 {
		//�������� ����������� ����������� JFrame(�������� ��� ����)
		super("������ ������� �����������");
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		//������� ������
		panel0=new JPanel();
		panel0.setLayout(null);
		
		//����� �������
		panel1=new ProjectPanel("���� 1",3);
		panel1.setBounds(0,0,1024,396);
		
		//������ ������ (��� ������ '���������' � ������� lbl1)
		bottompanel=new JPanel();
		bottompanel.setBounds(0,400,1024,116);
		bottompanel.setBackground(new Color(235,235,240));
		bottompanel.setLayout(null);
		
		//��������� ������ �� �������
	 	panel0.add(panel1);
	 	panel0.add(bottompanel);
	 	
	 	//������ ���������� ������
	 	Font font = new Font("Verdana", Font.PLAIN, 15);
	 	
	 	//������ ���������
	 	bt1=new  JButton("���������");
	 	bt1.setBounds(900, 15, 100, 50);
	 	
	 	//������� ���������� ����������
	 	bt1.setFocusPainted(false);
	 	//������ ���������� ��� ������
	 	bt1.setBackground(new Color(255,255,250));
	 	bt1.setForeground(new Color(10,10,10));
	 	bt1.setBorder(new LineBorder(new Color(112, 128, 144)));
	 	bt1.setFont(font);
	 	//�������, ���������� ��������� ������� �����������
	 	lb1=new JLabel("���������: ");
	 	lb1.setBounds(15, 15, 800, 50);
	 	lb1.setFont(font);
	 	
	 	//������ ��������� ��� ������ bt1
	 	bt1.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			//��������� ��������� � ������� �� �����
	 			lb1.setText(String.valueOf(panel1.calck()));
	 		}
	 	});
	 	
	 	//��������� �������� ���������� � ������ ������
	 	bottompanel.add(bt1);
	 	bottompanel.add(lb1);
	 	
	 	
	 	setContentPane(panel0);
	 	setSize(1024,512);
	 	//������ ���� �� ��������
	 	setResizable(false);
	 	setVisible(true);
	 }

	 public static void main(String[] args)
	 {
		 //������� ����
		 new Window();
	 }
}

