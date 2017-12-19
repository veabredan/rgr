package pack;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Section extends JPanel{
	//��� �������
	private int typep=0;
	//���������
	//������ �������
	public static final int none=0;
	//������� �����
	public static final int left=1;
	//������� �����/��������
	public static final int lefttop=2;
	//������� ������
	public static final int right=3;
	//������� ������/��������
	public static final int righttop=4;
	
	//����������� Section
	public Section(int typep){
		settype(typep);
		setLayout(null);
		//��������� ���������
		addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			//��� ������� �� ������ ����� �������� �� ���
	 			nexttype();
	 		}
	 	});
	}
	//��������� ��� �������
	public void nexttype(){
		this.typep++;
		 if(this.typep>4){this.typep=0;}
		 repaint();
	}
	public int gettype(){
		return this.typep;
	}
	public void settype(int typep){
		//�������� �� ������������ ������� ������
		if(typep<0||typep>4){
			this.typep=0;
		}else{
			this.typep=typep;
		}
	}
	//���������� ������� ����� � ���� ������
	@Override
    protected void paintComponent(Graphics g) {
		//�������� ����� �����������
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //������������� �����������
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        GradientPaint gp1 = new GradientPaint(
        		0, 0, new Color(220,220,220), 
        		0, getHeight(),new Color(255, 255, 255));
        g2d.setPaint(gp1);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        GradientPaint gp2 = new GradientPaint(
        		0, 0, new Color(200,250,255), 
        		0, getHeight(),new Color(135, 165, 195));
        g2d.setPaint(gp2);
        g2d.fillRect(8, 8, getWidth()-16, getHeight()-16); 
        
        GradientPaint gp3 = new GradientPaint(
        		0, 0, new Color(100,100,100), 
        		0, getHeight(),new Color(100,100,100));
        g2d.setPaint(gp3);
       
        g2d.setColor(new Color(100,100,100));
        g2d.drawLine(0, 0, getWidth(), 0);
        g2d.drawLine(0, 0, 0, getHeight());
        g2d.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
        g2d.drawLine(getWidth()-1,  0,getWidth()-1, getHeight());
        
        switch(typep){
        	case none:{ 
        		g2d.drawString("������", 10,getHeight()-16 );
        		
        		break;
        	}
        	case lefttop:{
        		g2d.drawString("�����/�����.", 10,getHeight()-16 );
        		g2d.setColor(new Color(100,100,120));
        		g2d.drawLine(10, getHeight()/2, getWidth()/2, getHeight()/2-10);
        		g2d.drawLine(getWidth()-10, getHeight()/2, getWidth()/2, getHeight()/2-10);
        		g2d.fillOval(1, getHeight()/2, 6, 14);
        		break;
        	}
        	case righttop:{
        		g2d.setColor(new Color(100,100,120));
        		g2d.drawLine(10, getHeight()/2, getWidth()/2, getHeight()/2-10);
        		g2d.drawLine(getWidth()-10, getHeight()/2, getWidth()/2, getHeight()/2-10);
        		g2d.drawString("������/�����.", 10,getHeight()-16 );
        		g2d.fillOval(getWidth()-8, getHeight()/2, 6, 14);
        		break;
        	}
        	case right:{
        		g2d.drawString("������", 10,getHeight()-16 );
        		g2d.fillOval(getWidth()-8, getHeight()/2, 6, 14);
        		break;
        	}
        	case left:{
        		
        		g2d.drawString("�����", 10,getHeight()-16 );
        		g2d.fillOval(1, getHeight()/2, 6, 14);
        		break;
        	}
        	default:{
        		break;
        	}
        	
        	
        	
        }
        
        
        
       
    }
	
}
