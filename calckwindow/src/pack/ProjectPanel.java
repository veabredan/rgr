package pack;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class ProjectPanel extends JPanel{
	//����������� ������ ������
	public static final int minSWidth=500;
	//������������ ������ ������
	public static final int maxSWidth=900;
	//����������� ������ ������
	public static final int minSHeight=800;
	//������������ ������ ������
	public static final int maxSHeight=1500;
	
	//��������� ������� ���./��
	public static final double[] ProfileCoint={0.2418,0.2828,0.3438,0.4818,0.5318,0.5998};
	//��������� ������������ ���./��.��
	public static final double[] GlassCoint={0.00062,0.000632,0.000653,0.000686};
	//��������� ��������� ���./��.
	public static final double[] FurnitureCoint={2500,2700,3000};
	//��������� ��� ������� ���� ����������� ���./��.
	public static final double WindowSillCoint[]={0,0.2560,0.3171,0.3992,0.4632,0.4821,0.5714,0.625};
	//��������� ��� ������� ���� ������ ���./��.
	public static final double SillRailCoint[]={0,0.1428,0.1785,0.2142,0.2321,0.3214};
	//��������� ��������� ���./��.
	public static final double[] CointFix={0,1000,1500,900};
	//��������� ��� ������� ���� ������� ���./��.
	public static final double[] SectionCoint={200,2000,2400,2000,2400};
	
	
	
	//��������� 
	//��� �������
	public String name="";
	//������ �������
	public PropertiesPanel leftpanel=null;
	//������ ����������
	public BuildPanel rightpanel=null;  
	//���� ����� ��������� ��������� ������� �����������
	public String calck(){
		//�������� ��������� �������� � ������ leftpanel
		//��� �������
		int param1=leftpanel.comboBox1.getSelectedIndex();
		//�����������
		int param2=leftpanel.comboBox2.getSelectedIndex();
		//��������
		int param3=leftpanel.comboBox3.getSelectedIndex();
		//������ �����������
		int param4=leftpanel.comboBox4.getSelectedIndex();
		//������ ������
		int param5=leftpanel.comboBox5.getSelectedIndex();
		//���������
		int param6=leftpanel.comboBox6.getSelectedIndex();
		//�������� ���������� �������
		int count=rightpanel.getcount();
		
		String subs;
		//�������� ������ ����
		subs=rightpanel.textbox1.getText();
		int w=0;
		int h=0;
		int w1=0;
		int w2=0;
		int w3=0;
		int w4=0;
		
		
		//��������� �� ������� ������
		//������ ������ �������� ������
		try{
			if(subs.equals("")){subs="0";}
			w=Integer.valueOf(subs);
			//�������� ������ ����
			subs=rightpanel.textbox2.getText();
			if(subs.equals("")){subs="0";}
			h=Integer.valueOf(subs);
			//�������� ������ ������ �������
			subs=rightpanel.textbox3.getText();
			if(subs.equals("")){subs="0";}
			w1=Integer.valueOf(subs);
			//�������� ������ ������� �������
			subs=rightpanel.textbox5.getText();
			if(subs.equals("")){subs="0";}
			w3=Integer.valueOf(subs);
			//�������� ������ ��������� �������
			subs=rightpanel.textbox6.getText();
			if(subs.equals("")){subs="0";}
			w4=Integer.valueOf(subs);

		}
		catch(NumberFormatException e){
			//� ������ ������ ������� ���������
			return "�������� ������ ������";
		}
		//��������� ������ ������ �������
		w2=w;
		switch(count){
			case 2:{w2=w2-w1;break;}
			case 3:{w2=w2-w1-w3;break;}
			case 4:{w2=w2-w1-w3-w4;break;}
		}
		
		//�������� �� �������� ��������
		if(w<minSWidth*count){return "������ ���� ������ ���� �� ����� "+minSWidth*count;}
		if(w>maxSWidth*count){return "������ ���� ������ ���� �� ����� "+maxSWidth*count;}
		if(h<minSHeight){return "������ ���� ������ ���� �� ����� "+minSHeight;}
		if(h>maxSHeight){return "������ ���� ������ ���� �� ����� "+maxSHeight;}
		if(w1<minSWidth){return "������ ������ ������� ������ ���� �� ����� "+minSWidth;}
		if(w1>maxSWidth){return "������ ������ ������� ������ ���� �� ����� "+maxSWidth;}
		if(w3<minSWidth&&count>=3){return "������ ������� ������� ������ ���� �� ����� "+minSWidth;}
		if(w3>maxSWidth&&count>=3){return "������ ������� ������� ������ ���� �� ����� "+maxSWidth;}
		if(w4<minSWidth&&count==4){return "������ ��������� ������� ������ ���� �� ����� "+minSWidth;}
		if(w4>maxSWidth&&count==4){return "������ ��������� ������� ������ ���� �� ����� "+maxSWidth;}
		
		if(w2<minSWidth&&count>=2){return "������ ������ ������� ������ ���� �� ����� "+minSWidth;}
		if(w2>maxSWidth&&count>=2){return "������ ������ ������� ������ ���� �� ����� "+maxSWidth;}
		
		//�������� ��� ������ �������
		int t1=rightpanel.panelw1.gettype();
		//�������� ��� ������ �������
		int t2=rightpanel.panelw2.gettype();
		//�������� ��� ������� �������
		int t3=rightpanel.panelw3.gettype();
		//�������� ��� ��������� �������
		int t4=rightpanel.panelw4.gettype();
		
		double rezult=0;
		//��������� ��������� ����
		//��������� ������� �� �������
		rezult=ProfileCoint[param1]*(w+h+w+h+h*count);
		//��������� ������� �� �����������
		rezult=rezult+GlassCoint[param2]*w*h;
		//��������� ������� �� ���������
		rezult=rezult+FurnitureCoint[param3]*count;
		//��������� ������� �� ����������
		rezult=rezult+WindowSillCoint[param4]*w;
		//��������� ������� �� �����
		rezult=rezult+SillRailCoint[param5]*w;
		//��������� ������� �� ��� ������� 1
		rezult=rezult+SectionCoint[t1];
		//������� �� ���������
		rezult=rezult+CointFix[param6]*count;
		//� ����������� �� ���������� ������� ��������� ������� �� ��� ������ ������� (2, 3, 4)
		if(count>1)
		rezult=rezult+SectionCoint[t2];
		if(count>2)
		rezult=rezult+SectionCoint[t3];
		if(count>3)
		rezult=rezult+SectionCoint[t4];
		//��������� ���������
		return "���������: "+String.format("%.2f",rezult)+" ���.";
	}
	//����������� �������
	public ProjectPanel(String name,int countsection){
		this.name=name;
		//������ ������������ ���������( �� �����)
		setLayout(new GridLayout());
		//������� ������ �������
		leftpanel=new PropertiesPanel(6);
		//������ ���������� ����������� ����
		rightpanel=new BuildPanel(countsection);
		//��������� ������
		add(leftpanel);
		add(rightpanel);
		
	}
	
}
