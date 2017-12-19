package pack;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Window extends JFrame {
	
	//общая панель
	 private JPanel panel0;
	 //панель проекта
	 private ProjectPanel panel1;
	 //панель управления
	 private JPanel bottompanel;  
	 //кнопка расчитать
	 JButton bt1=null;
	 //надпись для вывода результата
	 JLabel lb1=null;
	 
	 Window()
	 {
		//вызываем конструктор суперкласса JFrame(передаем имя окна)
		super("Расчет оконной конструкции");
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		//главная панель
		panel0=new JPanel();
		panel0.setLayout(null);
		
		//паель проекта
		panel1=new ProjectPanel("Окно 1",3);
		panel1.setBounds(0,0,1024,396);
		
		//нижняя панель (где кнопка 'Вычислить' и надпись lbl1)
		bottompanel=new JPanel();
		bottompanel.setBounds(0,400,1024,116);
		bottompanel.setBackground(new Color(235,235,240));
		bottompanel.setLayout(null);
		
		//добавляем панели на главную
	 	panel0.add(panel1);
	 	panel0.add(bottompanel);
	 	
	 	//создем оформление текста
	 	Font font = new Font("Verdana", Font.PLAIN, 15);
	 	
	 	//кнопка вычислить
	 	bt1=new  JButton("вычислить");
	 	bt1.setBounds(900, 15, 100, 50);
	 	
	 	//убираем некрасивое оформление
	 	bt1.setFocusPainted(false);
	 	//задаем оформление для кнопки
	 	bt1.setBackground(new Color(255,255,250));
	 	bt1.setForeground(new Color(10,10,10));
	 	bt1.setBorder(new LineBorder(new Color(112, 128, 144)));
	 	bt1.setFont(font);
	 	//надпись, отображает стоимость оконной конструкции
	 	lb1=new JLabel("Стоимость: ");
	 	lb1.setBounds(15, 15, 800, 50);
	 	lb1.setFont(font);
	 	
	 	//задаем слушатель для кнопки bt1
	 	bt1.addMouseListener( new MouseAdapter()
	 	{
	 		public void mousePressed(MouseEvent event) {
	 			//вычисляем стоимость и выводим на экран
	 			lb1.setText(String.valueOf(panel1.calck()));
	 		}
	 	});
	 	
	 	//добавляем элементы управления к нижней панели
	 	bottompanel.add(bt1);
	 	bottompanel.add(lb1);
	 	
	 	
	 	setContentPane(panel0);
	 	setSize(1024,512);
	 	//размер окна не меняется
	 	setResizable(false);
	 	setVisible(true);
	 }

	 public static void main(String[] args)
	 {
		 //создаем окно
		 new Window();
	 }
}

