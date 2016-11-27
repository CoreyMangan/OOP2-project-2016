import javax.swing.*;
import java.awt.List;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class AddGameFrame extends JFrame implements ActionListener {
	Container cPane = getContentPane();
	JLabel lblTitle, lblDesc, lblGenre;
	JTextField tfTitle, tfDesc, tfGenre;
	GameDetails GD = new GameDetails();
	FlowLayout layout = new FlowLayout();
	JTextField s;
	
	ArrayList gameList = new ArrayList();
	
	public AddGameFrame() {
		super("Add Game");
		setSize(500,500);
		setLocation(450,350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		gameList.add(GD.toString());		
		displayList();
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void displayList() {
		JPanel pnl = new JPanel(new GridLayout(12, 2));
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		getContentPane().add(jsp);
		jta.setEditable(false);
		
		try (BufferedReader br = new BufferedReader(new FileReader("GameDetails.txt"))) {
			String line;
			while((line = br.readLine()) != null) {
				jta.append(line + "\n");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}	
		cPane.add(jsp);
	}
}