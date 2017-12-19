import static org.junit.Assert.*;

import org.junit.Test;

import pack.ProjectPanel;
import pack.Section;


public class TestWindow {

	@Test
	public void test1() {
		//fail("Not yet implemented");
		//������� ������, ��� "test", ���������� ������� 1
		ProjectPanel ProjectTest=new ProjectPanel("test",1);
		//������������� �������� ����
		ProjectTest.leftpanel.comboBox1.setSelectedIndex(0);
		ProjectTest.leftpanel.comboBox2.setSelectedIndex(1);
		ProjectTest.leftpanel.comboBox3.setSelectedIndex(2);
		ProjectTest.leftpanel.comboBox4.setSelectedIndex(2);
		ProjectTest.leftpanel.comboBox5.setSelectedIndex(1);
		ProjectTest.leftpanel.comboBox6.setSelectedIndex(2);
		//������������� ���� ��� ������ �������
		ProjectTest.rightpanel.panelw1.settype(Section.none);
		ProjectTest.rightpanel.panelw2.settype(Section.right);
		ProjectTest.rightpanel.panelw3.settype(Section.left);
		ProjectTest.rightpanel.panelw4.settype(Section.none);
		//������ ��� ������ � ������� �������
		ProjectTest.rightpanel.panelw2.nexttype();
		ProjectTest.rightpanel.panelw3.nexttype();
		//������������� ���������� ������� 3
		ProjectTest.rightpanel.setcount(3);
		//������ ������ ����
		ProjectTest.rightpanel.textbox1.setText("1500");
		//��������� � ���������� ���������� ����������
		assertEquals(ProjectTest.calck(), "���������: 22503,65 ���.");
	}
	@Test
	public void test2(){
		//������� ������, ��� "test", ���������� ������� 3
		ProjectPanel ProjectTest=new ProjectPanel("test",3);
		//��������� � ���������� ���������� ����������
		assertEquals(ProjectTest.calck(), "���������: 15792,20 ���.");
		
	}
	@Test
	public void test3(){
		//������� ������, ��� "test", ���������� ������� 4
		ProjectPanel ProjectTest=new ProjectPanel("test",4);
		//������ ������ ����
		ProjectTest.rightpanel.textbox1.setText("1900");
		//��������� � ���������� ���������� ����������
		assertEquals(ProjectTest.calck(), "������ ���� ������ ���� �� ����� 2000");
	}
	@Test
	public void test4(){
		//������� ������, ��� "test", ���������� ������� 4
		ProjectPanel ProjectTest=new ProjectPanel("test",4);
		//� ��������� ���� ������ ���� ������ ������ ��������� �������
		ProjectTest.rightpanel.textbox1.setText("aaaa");
		//��������� � ���������� ���������� ����������
		assertEquals(ProjectTest.calck(), "�������� ������ ������");
	}
}
