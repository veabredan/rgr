package pack;


import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextBoxNum extends JTextField{
	private int maxlen=4;
	JTextBoxNum(){
		//super();
		
		//��������� ���������
		addKeyListener(new java.awt.event.KeyAdapter() {
	 	     
	 	      public void keyTyped(KeyEvent e) {
	 	        //��������� ������� ������ ���������� ������
	 	    	 char ch=e.getKeyChar();
	 	    	 //����� ����� ������������� ������� �� ���������� �������
	 	    	 if(ch=='0'||ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9'){
	 	    		//� ����� ����������� �����
	 	    		 if(getText().length()==maxlen){
		 	    		 
	 	    			e.consume();
		 	    	}
	 	    	 }else{
	 	    		e.consume();
	 	    	 }
	 	      }

	 	    });
	}
	

}
