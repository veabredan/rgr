package pack;

import java.awt.Polygon;
//��� ��� ������� ������� ������ ��
//����� ������������ �������
//������� ��������� �� ������ ������� ����� ��������� ������������ ������
public class Arrow extends Polygon{
	//��������� ������� ���������� ����������� �������
	public static final int west=0;
	public static final int east=1;
	public static final int north=2;
	public static final int south=3;
	//���������� ������ �������
	private int x=0;
	private int y=0;
	//����� �������
	private int length=0;
	//������ �������
	private int width=2;
	//����������� �������
	private int type=west;
	
	//����������� �������
	public Arrow(int x,int y, int lenght,int width,int type){
	 this.x=x;
	 this.y=y;
	 this.length=lenght;
	 this.width=width;
	 this.type=type;
	 
	 switch (type){
		case west:{
			this.addPoint(x, y);
			this.addPoint(x-length, y);
			this.addPoint(x-length, y-width);
			this.addPoint(x-length-width*2, y+width/2);
			this.addPoint(x-length, y+width-1+width);
			this.addPoint(x-length, y+width-1);
			this.addPoint(x, y+width-1);
			break;
		}
		case east:{
			this.addPoint(x, y);
			this.addPoint(x+length, y);
			this.addPoint(x+length, y-width);
			this.addPoint(x+length+width*2, y+width/2);
			this.addPoint(x+length, y+width-1+width);
			this.addPoint(x+length, y+width-1);
			this.addPoint(x, y+width-1);
			break;
		}
		case north:{
			this.addPoint(x, y);
			this.addPoint(x, y-length);
			this.addPoint(x-width, y-length);
			this.addPoint(x+width/2, y-length-width*2);
			this.addPoint(x+width*2-1, y-length);
			this.addPoint(x+width-1, y-length);
			this.addPoint(x+width-1, y);
			
			break;
		}
		case south:{
			this.addPoint(x, y);
			this.addPoint(x, y+length);
			this.addPoint(x-width, y+length);
			this.addPoint(x+width/2, y+length+width*2);
			this.addPoint(x+width*2-1, y+length);
			this.addPoint(x+width-1, y+length);
			this.addPoint(x+width-1, y);
			break;
		}
		default:{
			
			break;
		}
	 }
	}
	
	
}
