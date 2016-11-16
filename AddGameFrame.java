import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AddGameFrame extends JFrame implements ActionListener {
	Container cPane = getContentPane();
	JLabel lblTitle, lblDesc, lblGenre;
	JTextField tfTitle, tfDesc, tfGenre;
	GameDetails GD = new GameDetails();
	
	ArrayList gameList = new ArrayList();
	
	public AddGameFrame() {
		super("Add Game");
		setSize(500,500);
		setLocation(450,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		lblTitle = new JLabel("Title: ");
		cPane.add(lblTitle);
		
		/*tfTitle = new JTextField();
		tfTitle.setPreferredSize(new Dimension(50,20));
		cPane.add(tfTitle);
		
		GD.setTitle(tfTitle.getText());*/
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}