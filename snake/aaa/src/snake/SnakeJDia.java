package snake;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class SnakeJDia extends JDialog{
	SnakeJPanel sjp;
	JButton b=new JButton("�õ�");
	JLabel text=new JLabel();
	public SnakeJDia(SnakeJPanel sjp) {
		super();
		this.sjp = sjp;
		setLayout(new FlowLayout());
		this.setSize(200,100);
		setLocation(250,250);
		add(b);
		text.setText("��ĵ÷֣�"+sjp.fenshu);
		add(text);
	}
	
}
