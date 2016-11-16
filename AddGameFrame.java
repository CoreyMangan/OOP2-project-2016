import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddGameFrame extends JFrame implements ActionListener {
	Container cPane = getContentPane();
	
	public AddGameFrame() {
		super("Add Game");
		setSize(500,500);
		setLocation(450,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cPane.setLayout(new FlowLayout());
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}