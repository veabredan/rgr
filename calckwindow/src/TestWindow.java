import static org.junit.Assert.*;

import org.junit.Test;

import pack.ProjectPanel;
import pack.Section;


public class TestWindow {

	@Test
	public void test1() {
		//fail("Not yet implemented");
		//Создаем проект, имя "test", количество створок 1
		ProjectPanel ProjectTest=new ProjectPanel("test",1);
		//устанавливаем свойства окна
		ProjectTest.leftpanel.comboBox1.setSelectedIndex(0);
		ProjectTest.leftpanel.comboBox2.setSelectedIndex(1);
		ProjectTest.leftpanel.comboBox3.setSelectedIndex(2);
		ProjectTest.leftpanel.comboBox4.setSelectedIndex(2);
		ProjectTest.leftpanel.comboBox5.setSelectedIndex(1);
		ProjectTest.leftpanel.comboBox6.setSelectedIndex(2);
		//устанавливаем типы для каждой створки
		ProjectTest.rightpanel.panelw1.settype(Section.none);
		ProjectTest.rightpanel.panelw2.settype(Section.right);
		ProjectTest.rightpanel.panelw3.settype(Section.left);
		ProjectTest.rightpanel.panelw4.settype(Section.none);
		//меняем тип второй и третьей створки
		ProjectTest.rightpanel.panelw2.nexttype();
		ProjectTest.rightpanel.panelw3.nexttype();
		//устанавливаем количество створок 3
		ProjectTest.rightpanel.setcount(3);
		//задаем ширину окна
		ProjectTest.rightpanel.textbox1.setText("1500");
		//вычисляем и сравниваем полученные результаты
		assertEquals(ProjectTest.calck(), "Стоимость: 22503,65 руб.");
	}
	@Test
	public void test2(){
		//создаем проект, имя "test", количество створок 3
		ProjectPanel ProjectTest=new ProjectPanel("test",3);
		//вычисляем и сравниваем полученные результаты
		assertEquals(ProjectTest.calck(), "Стоимость: 15792,20 руб.");
		
	}
	@Test
	public void test3(){
		//создаем проект, имя "test", количество створок 4
		ProjectPanel ProjectTest=new ProjectPanel("test",4);
		//задаем ширину окна
		ProjectTest.rightpanel.textbox1.setText("1900");
		//вычисляем и сравниваем полученные результаты
		assertEquals(ProjectTest.calck(), "Ширина окна должна быть не менее 2000");
	}
	@Test
	public void test4(){
		//создаем проект, имя "test", количество створок 4
		ProjectPanel ProjectTest=new ProjectPanel("test",4);
		//в текстовом поле ширины окна вводим данные неверного формата
		ProjectTest.rightpanel.textbox1.setText("aaaa");
		//вычисляем и сравниваем полученные результаты
		assertEquals(ProjectTest.calck(), "Неверный формат данных");
	}
}
