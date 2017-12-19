package pack;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class ProjectPanel extends JPanel{
	//минимальная ширина секции
	public static final int minSWidth=500;
	//максимальная ширина секции
	public static final int maxSWidth=900;
	//минимальная высота секции
	public static final int minSHeight=800;
	//максимальная высота секции
	public static final int maxSHeight=1500;
	
	//стоимость профиля руб./мм
	public static final double[] ProfileCoint={0.2418,0.2828,0.3438,0.4818,0.5318,0.5998};
	//стоимость стеклопакета руб./кв.мм
	public static final double[] GlassCoint={0.00062,0.000632,0.000653,0.000686};
	//стоимость фурнитуры руб./шт.
	public static final double[] FurnitureCoint={2500,2700,3000};
	//стоимость для каждого типа подоконника руб./мм.
	public static final double WindowSillCoint[]={0,0.2560,0.3171,0.3992,0.4632,0.4821,0.5714,0.625};
	//стоимость для каждого типа отлива руб./мм.
	public static final double SillRailCoint[]={0,0.1428,0.1785,0.2142,0.2321,0.3214};
	//стоимость установки руб./шт.
	public static final double[] CointFix={0,1000,1500,900};
	//стоимость для каждого типа створки руб./шт.
	public static final double[] SectionCoint={200,2000,2400,2000,2400};
	
	
	
	//стоимость 
	//имя проекта
	public String name="";
	//панель свойств
	public PropertiesPanel leftpanel=null;
	//панель построения
	public BuildPanel rightpanel=null;  
	//этот метод вычисляет стоимость оконной конструкции
	public String calck(){
		//получаем выбранные свойства в панели leftpanel
		//тип профиля
		int param1=leftpanel.comboBox1.getSelectedIndex();
		//стеклопакет
		int param2=leftpanel.comboBox2.getSelectedIndex();
		//фурнтура
		int param3=leftpanel.comboBox3.getSelectedIndex();
		//ширина подоконника
		int param4=leftpanel.comboBox4.getSelectedIndex();
		//ширина отлива
		int param5=leftpanel.comboBox5.getSelectedIndex();
		//установка
		int param6=leftpanel.comboBox6.getSelectedIndex();
		//получаем количество створок
		int count=rightpanel.getcount();
		
		String subs;
		//получаем ширину окна
		subs=rightpanel.textbox1.getText();
		int w=0;
		int h=0;
		int w1=0;
		int w2=0;
		int w3=0;
		int w4=0;
		
		
		//проверяем на наличие ошибок
		//вводим только числовые данные
		try{
			if(subs.equals("")){subs="0";}
			w=Integer.valueOf(subs);
			//получаем высоту окна
			subs=rightpanel.textbox2.getText();
			if(subs.equals("")){subs="0";}
			h=Integer.valueOf(subs);
			//получаем ширину первой створки
			subs=rightpanel.textbox3.getText();
			if(subs.equals("")){subs="0";}
			w1=Integer.valueOf(subs);
			//получаем ширину третьей створки
			subs=rightpanel.textbox5.getText();
			if(subs.equals("")){subs="0";}
			w3=Integer.valueOf(subs);
			//получаем ширину четвертой створки
			subs=rightpanel.textbox6.getText();
			if(subs.equals("")){subs="0";}
			w4=Integer.valueOf(subs);

		}
		catch(NumberFormatException e){
			//в случае ошибки выводим сообщение
			return "Неверный формат данных";
		}
		//вычисляем ширину второй створки
		w2=w;
		switch(count){
			case 2:{w2=w2-w1;break;}
			case 3:{w2=w2-w1-w3;break;}
			case 4:{w2=w2-w1-w3-w4;break;}
		}
		
		//проверка на диапазон значений
		if(w<minSWidth*count){return "Ширина окна должна быть не менее "+minSWidth*count;}
		if(w>maxSWidth*count){return "Ширина окна должна быть не более "+maxSWidth*count;}
		if(h<minSHeight){return "Высота окна должна быть не менее "+minSHeight;}
		if(h>maxSHeight){return "Высота окна должна быть не более "+maxSHeight;}
		if(w1<minSWidth){return "Ширина первой створки должна быть не менее "+minSWidth;}
		if(w1>maxSWidth){return "Ширина первой створки должна быть не более "+maxSWidth;}
		if(w3<minSWidth&&count>=3){return "Ширина третьей створки должна быть не менее "+minSWidth;}
		if(w3>maxSWidth&&count>=3){return "Ширина третьей створки должна быть не более "+maxSWidth;}
		if(w4<minSWidth&&count==4){return "Ширина четвертой створки должна быть не менее "+minSWidth;}
		if(w4>maxSWidth&&count==4){return "Ширина четвертой створки должна быть не более "+maxSWidth;}
		
		if(w2<minSWidth&&count>=2){return "Ширина второй створки должна быть не менее "+minSWidth;}
		if(w2>maxSWidth&&count>=2){return "Ширина второй створки должна быть не более "+maxSWidth;}
		
		//получаем тип первой створки
		int t1=rightpanel.panelw1.gettype();
		//получаем тип второй створки
		int t2=rightpanel.panelw2.gettype();
		//получаем тип третьей створки
		int t3=rightpanel.panelw3.gettype();
		//получаем тип четвертой створки
		int t4=rightpanel.panelw4.gettype();
		
		double rezult=0;
		//вычисляем стоимость окна
		//добавляем наценку за профиль
		rezult=ProfileCoint[param1]*(w+h+w+h+h*count);
		//добавляем наценку за стеклопакет
		rezult=rezult+GlassCoint[param2]*w*h;
		//добавляем наценку за фурнитуру
		rezult=rezult+FurnitureCoint[param3]*count;
		//добавляем наценку за подоконник
		rezult=rezult+WindowSillCoint[param4]*w;
		//добавляем наценку за отлив
		rezult=rezult+SillRailCoint[param5]*w;
		//добавляем наценку за тип створки 1
		rezult=rezult+SectionCoint[t1];
		//наценка за установку
		rezult=rezult+CointFix[param6]*count;
		//в зависимости от количества створок добавляем наценку за тип каждой створки (2, 3, 4)
		if(count>1)
		rezult=rezult+SectionCoint[t2];
		if(count>2)
		rezult=rezult+SectionCoint[t3];
		if(count>3)
		rezult=rezult+SectionCoint[t4];
		//возращаем рузультат
		return "Стоимость: "+String.format("%.2f",rezult)+" руб.";
	}
	//конструктор проекта
	public ProjectPanel(String name,int countsection){
		this.name=name;
		//способ расположения элементов( по сетке)
		setLayout(new GridLayout());
		//создаем панель свойств
		leftpanel=new PropertiesPanel(6);
		//панель построения конструкции окна
		rightpanel=new BuildPanel(countsection);
		//добавляем панели
		add(leftpanel);
		add(rightpanel);
		
	}
	
}
