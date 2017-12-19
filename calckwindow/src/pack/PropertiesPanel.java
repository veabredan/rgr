package pack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.Line2D;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PropertiesPanel extends JPanel{
	//подписи к параметрам конструкции
		 private JLabel label1=null;
		 private JLabel label2=null;
		 private JLabel label3=null;
		 private JLabel label4=null;
		 private JLabel label5=null;
		 private JLabel label6=null;
		 //списки с выбором необходимых параметров
		 public JComboBox<String> comboBox1 =null;
		 public JComboBox<String> comboBox2 =null;
		 public JComboBox<String> comboBox3 =null;
		 public JComboBox<String> comboBox4 =null;
		 public JComboBox<String> comboBox5 =null;
		 public JComboBox<String> comboBox6 =null;
	
	public PropertiesPanel(int count){
		setLayout(new GridLayout(count,2));
		Font fontl = new Font("Verdana", Font.BOLD, 13);
	 	label1=new JLabel("   Тип профиля");
	 	label1.setFont(fontl);
	 	label2=new JLabel("   Стеклопакет");
	 	label2.setFont(fontl);
	 	label3=new JLabel("   Фурнитура");
	 	label3.setFont(fontl);
	 	label4=new JLabel("   Ширина подоконника");
	 	label4.setFont(fontl);
	 	label5=new JLabel("   Ширина отлива");
	 	label5.setFont(fontl);
	 	label6=new JLabel("   Установка");
	 	label6.setFont(fontl);
	 	
	 	String[] items1 = {
	 		    "Rehau Blitz",
	 		    "Rehau Sib",
	 		    "Rehau Delight",
	 		    "Rehau Brilliant",
	 		    "Rehau Intelio",
	 		    "Rehau Geneo",
	 		};
	 	String[] items2 = {
	 		    "Стандартный",
	 		    "Теплосберегающий",
	 		    "Солнцезащитный",
	 		    "Шумозащитный"
	 		};
	 	String[] items3 = {
	 		    "ROTO",
	 		    "MACO",
	 		    "Winkhaus"
	 		};
	 	String[] items4 = {
	 		    "нет",
	 		    "150мм",
	 		    "200мм",
	 		    "250мм",
	 		    "300мм",
	 		    "350мм",
	 		    "400мм",
	 		    "450мм",
	 		    "500мм"
	 		};
	 	String[] items5 = {
	 			"нет",
	 		    "менее 100мм",
	 		    "100-150мм",
	 		    "150-200мм",
	 		    "200-250мм",
	 		    "250-400мм"
	 		};
	 	String[] items6 = {
	 		    "Нет",
	 		    "Деревянный дом",
	 		    "Кирпичный дом",
	 		    "Панельный дом"
	 		};
	 	comboBox1=new JComboBox<String>(items1);
	 	comboBox2=new JComboBox<String>(items2);
	 	comboBox3=new JComboBox<String>(items3);
	 	comboBox4=new JComboBox<String>(items4);
	 	comboBox5=new JComboBox<String>(items5);
	 	comboBox6=new JComboBox<String>(items6);
	 	add(label1);
	 	add(comboBox1);
	 	add(label2);
	 	add(comboBox2);
	 	add(label3);
	 	add(comboBox3);
	 	add(label4);
	 	add(comboBox4);
	 	add(label5);
	 	add(comboBox5);
	 	add(label6);
	 	add(comboBox6);
	 	
	 	setBounds(0,0,400,400);
	 	setBackground(new Color(235,235,240));
	}
	protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(new Color(100,100,120));
	        Shape line = new Line2D.Double(0, getHeight()-1, getWidth(), getHeight()-1);
	        g2d.draw(line);
	}
}
