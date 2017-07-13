package snake;

import java.awt.Button;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class SnakeWin extends JFrame {
   
	public void init(){
		setSize(440,400);
		setTitle("1450340160Íõ½ðÔÂ");
		add(new SnakeJPanel());
		setLocationRelativeTo(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
	}
		
	public SnakeWin() throws HeadlessException {
		super();
		init();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeWin sw=new SnakeWin();
		sw.setVisible(true);
	}

}
