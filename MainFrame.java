import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener{
	JMenu fileMenu;
	JMenuBar menuBar;
	Container cPane = getContentPane();
	
	public MainFrame() {
		super("eGames System");
		setSize(500,500);
		setLocation(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cPane.setLayout(new FlowLayout());
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}