package pack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BuildPanel extends JPanel {
	//минимальная ширина секции
	public static final int minSWidth=500;
	//количество секций
	private JButton bt1 = null;
	private JButton bt2 = null;
	private JButton bt3 = null;
	private JButton bt4 = null;
	//ширина
	public JTextBoxNum textbox1=null;
	private JLabel label1=null;
	//высота
	public JTextBoxNum textbox2=null;
	private JLabel label2=null;
	//секции
	public Section panelw1=null;
	public Section panelw2=null;
	public Section panelw3=null;
	public Section panelw4=null;
	//ширина для каждой секции
	public JTextBoxNum textbox3=null;
	public JTextBoxNum textbox4=null;
	public JTextBoxNum textbox5=null;
	public JTextBoxNum textbox6=null;
	//начальные значения(размеров створок и окна)
	private String s1="500";
	private String s2="1200";
	private String s3="500";
	private String s4="";
	private String s5="500";
	private String s6="500";
	//количество секций
	private int count=1;
	//цвет выбранной кнопки
	private static final Color selectc=new Color(135, 165, 195);
	//цвет других кнопок
	private static final Color otherc=new Color(255, 255, 250);
	//задает количество створок
	public void setcount(int count){
		switch(count){

			case 1:{
				this.count=count;
				//выделение цветом выбранную кнопку(количество створок)
				bt1.setBackground(selectc);
	 			bt2.setBackground(otherc);
	 			bt3.setBackground(otherc);
	 			bt4.setBackground(otherc);
	 			//делаем видимой только 1 створку
	 			panelw1.setVisible(true);
	 			panelw2.setVisible(false);
	 			panelw3.setVisible(false);
	 			panelw4.setVisible(false);
	 			//задаем видимость для полей и их координаты
	 			textbox3.setVisible(false);
	 			textbox4.setVisible(false);
	 			textbox5.setVisible(false);
	 			textbox6.setVisible(false);
	 			textbox1.setBounds(25+15, 120, 50, 25);
	 			textbox1.setText( String.valueOf(minSWidth*count));
	 			label1.setBounds(25, 100, 100, 25);
	 			textbox2.setBounds(130, 220, 50, 25);
	 			label2.setBounds(130, 200, 100, 25);
				break;
			}
			case 2:{
				this.count=count;
				//выделение цветом выбранную кнопку(количество створок)
				bt1.setBackground(otherc);
	 			bt2.setBackground(selectc);
	 			bt3.setBackground(otherc);
	 			bt4.setBackground(otherc);
	 			//делаем видимой только 2 створки
	 			panelw1.setVisible(true);
	 			panelw2.setVisible(true);
	 			panelw3.setVisible(false);
	 			panelw4.setVisible(false);
	 			//задаем видимость для полей и их координаты
	 			textbox3.setVisible(true);
	 			textbox4.setVisible(true);
	 			textbox5.setVisible(false);
	 			textbox6.setVisible(false);
	 			textbox1.setBounds(75+15, 120, 50, 25);
	 			textbox1.setText( String.valueOf(minSWidth*count));
	 			label1.setBounds(75, 100, 100, 25);
	 			textbox2.setBounds(230, 220, 50, 25);
	 			label2.setBounds(230, 200, 100, 25);
				break;
			}
			case 3:{
				this.count=count;
				//выделение цветом выбранную кнопку(количество створок)
				bt1.setBackground(otherc);
	 			bt2.setBackground(otherc);
	 			bt3.setBackground(selectc);
	 			bt4.setBackground(otherc);
	 			//делаем видимой 3 створки
	 			panelw1.setVisible(true);
	 			panelw2.setVisible(true);
	 			panelw3.setVisible(true);
	 			panelw4.setVisible(false);
	 			//задаем видимость для полей и их координаты
	 			textbox3.setVisible(true);
	 			textbox4.setVisible(true);
	 			textbox5.setVisible(true);
	 			textbox6.setVisible(false);
	 			textbox1.setBounds(125+15, 120, 50, 25);
	 			textbox1.setText( String.valueOf(minSWidth*3));
	 			label1.setBounds(125, 100, 100, 25);
	 			textbox2.setBounds(330, 220, 50, 25);
	 			label2.setBounds(330, 200, 100, 25);
				break;
			}
			case 4:{
				this.count=count;
				//выделение цветом выбранную кнопку(количество створок)
				bt1.setBackground(otherc);
	 			bt2.setBackground(otherc);
	 			bt3.setBackground(otherc);
	 			bt4.setBackground(selectc);
	 			//делаем видимой все створки
	 			panelw1.setVisible(true);
	 			panelw2.setVisible(true);
	 			panelw3.setVisible(true);
	 			panelw4.setVisible(true);
	 			//задаем видимость для полей и их координаты
	 			textbox3.setVisible(true);
	 			textbox4.setVisible(true);
	 			textbox5.setVisible(true);
	 			textbox6.setVisible(true);
	 			textbox1.setBounds(175+15, 120, 50, 25);
	 			textbox1.setText( String.valueOf(minSWidth*4));
	 			label1.setBounds(175, 100, 100, 25);
	 			textbox2.setBounds(430, 220, 50, 25);
	 			label2.setBounds(430, 200, 100, 25);
				break;
			}
			default:{
				
			}
		
		
		}
	}
	public int getcount(){
		return count;
	}
	public BuildPanel(int countsection){
		setLayout(null);
		Font font = new Font("Verdana", Font.BOLD, 15);
	 	
	 	bt1=new  JButton("1");
	 	bt1.setBounds(20, 0, 50, 50);
	 	
	 	
	 	bt1.setFocusPainted(false);
	 	bt1.setForeground(new Color(10,10,10));
	 	bt1.setBorder(new LineBorder(new Color(112, 128, 144)));
	 	bt1.setFont(font);
	 
	 	bt2=new  JButton("2");
	 	bt2.setBounds(70, 0, 50, 50);
	 	
	 	bt2.setFocusPainted(false);
	 	bt2.setForeground(new Color(10,10,10));
	 	bt2.setBorder(new LineBorder(new Color(112, 128, 144)));
	 	bt2.setFont(font);
	 	
	 	bt3=new  JButton("3");
	 	bt3.setBounds(120, 0, 50, 50);
	 	
	 	bt3.setFocusPainted(false);
	 	bt3.setForeground(new Color(10,10,10));
	 	bt3.setBorder(new LineBorder(new Color(112, 128, 144)));
	 	bt3.setFont(font);
	 	
	 	bt4=new  JButton("4");
	 	bt4.setBounds(170, 0, 50, 50);
	 	
	 	bt4.setFocusPainted(false);
	 	bt4.setForeground(new Color(10,10,10));
	 	bt4.setBorder(new LineBorder(new Color(112, 128, 144)));
	 	bt4.setFont(font);
	 	
	 	Font fontsmoll = new Font("Verdana", Font.ITALIC, 10);
	 	textbox1= new JTextBoxNum();
	 	textbox1.setBounds(25+15, 120, 50, 25);
	 	textbox1.setText(s1);
	 	
	 	label1=new JLabel("Общая ширина");
	 	label1.setBounds(25, 100, 100, 25);
	 	label1.setFont(fontsmoll);
	 	
	 	textbox2=new JTextBoxNum();
	 	textbox2.setBounds(130, 220, 50, 25);
	 	textbox2.setText(s2);
	 	
	 	label2=new JLabel("Высота");
	 	label2.setBounds(130, 200, 100, 25);
	 	label2.setFont(fontsmoll);
	 	
	 	panelw1=new Section(Section.none);
	 	panelw1.setBounds(20, 150, 100, 170);
	 	
	 	panelw2=new Section(Section.righttop);
	 	panelw2.setBounds(120, 150, 100, 170);
	 	
	 	
	 	panelw3=new Section(Section.lefttop);
	 	panelw3.setBounds(220, 150, 100, 170);
	 	
	 	
	 	panelw4=new Section(Section.none);
	 	panelw4.setBounds(320, 150, 100, 170);
	 	
	 	
	 	textbox3=new JTextBoxNum();
	 	textbox3.setBounds(45, 325, 50, 25);
	 	textbox3.setText(s3);
	 	
	 	textbox4=new JTextBoxNum();
	 	textbox4.setBounds(145, 325, 50, 25);
	 	textbox4.setText(s4);
	 	
	 	textbox5=new JTextBoxNum();
	 	textbox5.setBounds(245, 325, 50, 25);
	 	textbox5.setText(s5);
	 	
	 	textbox6=new JTextBoxNum();
	 	textbox6.setBounds(345, 325, 50, 25);
	 	textbox6.setText(s6);
	 	
	 	textbox4.setEditable(false);
	 	
	 	//проверяем на корректность countsection
	 	if(countsection<5&&countsection>0){
	 		setcount(countsection);
	 	}else{
	 		setcount(1);
	 	}
	 	//добавляет слушатель
	 	bt1.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			//переключаем количество створок на 1
	 			setcount(1);
	 			repaint();
	 		}
	 	});
	 	bt2.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			//переключаем количество створок на 2
	 			setcount(2);
	 			repaint();
	 		}
	 	});
	 	bt3.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			//переключаем количество створок на 3
	 			setcount(3);
	 			repaint();
	 		}
	 	});
	 	bt4.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			//переключаем количество створок на 4
	 			setcount(4);
	 			repaint();
	 		}
	 	});
	
	 	
	 	
	 	
	 	
	 	//добавляем элементы на панель
	 	add(bt1);
	 	add(bt2);
	 	add(bt3);
	 	add(bt4);
	 	add(panelw1);
	 	add(panelw2);
	 	add(panelw3);
	 	add(panelw4);
	 	add(textbox1);
	 	add(label1);
	 	add(textbox2);
	 	add(label1);
	 	add(textbox3);
	 	add(textbox4);
	 	add(textbox5);
	 	add(textbox6);
	 	//устанавливаем цвет фон
	 	setBackground(new Color(235,235,240));
	}
	@Override
	protected void paintComponent(Graphics g) {
        
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //устанавливаем сглаживание
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //цвет пера
        g2d.setColor(new Color(100,100,100));
       
        //рисуем линию снизу
        Shape line = new Line2D.Double(0, getHeight()-1, getWidth(), getHeight()-1);
        //в зависимости от количества створок рисуем необходимые стрелки
        switch(count){
        	case 1:{
        		//стрелки высота
        		 Arrow arrt=new Arrow(150,205,50,3,Arrow.north);
        	     g2d.fillPolygon(arrt);
        	     Arrow arrd=new Arrow(150,250,65,3,Arrow.south);
        	     g2d.fillPolygon(arrd);
        	   //стрелки общая ширина
        	     Arrow arrtl=new Arrow(95,130,20,3,Arrow.east);
        	     g2d.fillPolygon(arrtl);
        	     Arrow arrtr=new Arrow(35,130,10,3,Arrow.west);
        	     g2d.fillPolygon(arrtr);
        		break;
        	}
        	case 2:{ 
        		//стрелки высота
        		Arrow arrt=new Arrow(250,205,50,3,Arrow.north);
        		//закрашиваем стрелку и отображаем ее на экране
        		g2d.fillPolygon(arrt);
        		Arrow arrd=new Arrow(250,250,65,3,Arrow.south);
        		g2d.fillPolygon(arrd);
        		//стрелки общая ширина
        	     Arrow arrtl=new Arrow(145,130,70,3,Arrow.east);
        	     g2d.fillPolygon(arrtl);
        	     Arrow arrtr=new Arrow(85,130,60,3,Arrow.west);
        	     g2d.fillPolygon(arrtr);
        	     //стрелки для 1 2 секции
        	     	for(int i=0;i<2;i++){
        	     		Arrow arrdl1=new Arrow(100+i*100,335,15,3,Arrow.east);
        	     		g2d.fillPolygon(arrdl1);
        	     		Arrow arrdr1=new Arrow(40+i*100,335,15,3,Arrow.west);
        	     		g2d.fillPolygon(arrdr1);
        	     	}
        		break;
        	}
        	case 3:{
        		//стрелки высота
        		Arrow arrt=new Arrow(350,205,50,3,Arrow.north);
        		g2d.fillPolygon(arrt);
        		Arrow arrd=new Arrow(350,250,65,3,Arrow.south);
        		g2d.fillPolygon(arrd);
        		//стрелки общая ширина
        		Arrow arrtl=new Arrow(195,130,120,3,Arrow.east);
       	     	g2d.fillPolygon(arrtl);
       	     	Arrow arrtr=new Arrow(135,130,110,3,Arrow.west);
       	     	g2d.fillPolygon(arrtr);
       	     	//стрелки для 1 2 3 секции
       	     	for(int i=0;i<3;i++){
       	     		Arrow arrdl1=new Arrow(100+i*100,335,15,3,Arrow.east);
       	     		g2d.fillPolygon(arrdl1);
       	     		Arrow arrdr1=new Arrow(40+i*100,335,15,3,Arrow.west);
       	     		g2d.fillPolygon(arrdr1);
       	     	}
        		break;
        	}
        	case 4:{
        		//стрелки высота
        		Arrow arrt=new Arrow(450,205,50,3,Arrow.north);
        		g2d.fillPolygon(arrt);
        		Arrow arrd=new Arrow(450,250,65,3,Arrow.south);
        		g2d.fillPolygon(arrd);
        		//стрелки общая ширина
        		Arrow arrtl=new Arrow(245,130,170,3,Arrow.east);
       	     	g2d.fillPolygon(arrtl);
       	     	Arrow arrtr=new Arrow(185,130,160,3,Arrow.west);
       	     	g2d.fillPolygon(arrtr);
       	     	//стрелки для 1 2 3 4 секции
       	     	for(int i=0;i<4;i++){
       	     		Arrow arrdl1=new Arrow(100+i*100,335,15,3,Arrow.east);
       	     		g2d.fillPolygon(arrdl1);
       	     		Arrow arrdr1=new Arrow(40+i*100,335,15,3,Arrow.west);
       	     		g2d.fillPolygon(arrdr1);
       	     	}
       	     	
        		break;
        	}
        	default:{
        		break;
        	}
        }
       
        g2d.draw(line);
        
	}

}
