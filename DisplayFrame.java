import javax.swing.*;
import java.awt.List;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class DisplayFrame extends JFrame implements ActionListener {
	Container cPane = getContentPane();
	GameDetails GD = new GameDetails();
	FlowLayout layout = new FlowLayout();
	JTextField s;
	JMenu menu;
	JMenuBar searchMenu;
	
	//ArrayList gameList = new ArrayList();
	
	public DisplayFrame() {
		super("Add Game");
		setSize(500,500);
		setLocation(450,350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//gameList.add(GD.toString());		
		displayList();
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	//Displaying the list that is in the save file
	public void displayList() {
		JPanel pnl = new JPanel(new GridLayout(12, 2));
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jta.setBackground(new Color (0x99CCFF));
		
		getContentPane().add(jsp);
		
		//Trying to get edit to work
		if(MainFrame.editCheck == true) {
			jta.setEditable(true);		
		}
		else {
			//edit doesn't really work so this will usually happen
			jta.setEditable(false);	
			JOptionPane.showMessageDialog(null, "Total Number of Games: " + GameDetails.numOfGames);
			JOptionPane.showMessageDialog(null, "Total price for used games: " + GameDetails.totUsedPrice);
			JOptionPane.showMessageDialog(null, "Total price for new games: " + GameDetails.totNewPrice);
		}
		
		//Reading the String that is in the save file and adding it to the JTextArea
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