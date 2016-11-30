import javax.swing.*;
import java.awt.List;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class DisplayFrame extends JFrame implements KeyListener {
	Container cPane = getContentPane();
	GameDetails GD = new GameDetails();
	FlowLayout layout = new FlowLayout();
	JTextField s;
	JTextField search;
	JMenuBar menuBar;
	
	JPanel pnl = new JPanel(new GridLayout(12, 2));
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);
	
	
	JTextArea jta2 = new JTextArea();

	
	//ArrayList gameList = new ArrayList();
	
	public DisplayFrame() {
		super("Add Game");
		setSize(500,500);
		setLocation(450,350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		search = new JTextField();
		search.addKeyListener(this);
		
		menuBar = new JMenuBar();

		setJMenuBar(menuBar);
		menuBar.add(search);
		
		
		//gameList.add(GD.toString());		
		displayList();
		
	}
	
	//Displaying the list that is in the save file
	public void displayList() {
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
	
	public void keyPressed(KeyEvent e) {
		if(e.getSource() == search) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				
			try (BufferedReader br = new BufferedReader(new FileReader("GameDetails.txt"))) {
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(search.getText())) {
					jta2.append(line + "\n");
					JOptionPane.showMessageDialog(null, jta2);
				}
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "File not found");
		}	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				/*//Scanner scanner = new Scanner("GameDetails.txt");
				BufferedReader br = new BufferedReader(new FileReader("GameDetails.txt"));
				while(br.readLine() != null) {
					//String lineFromLine = scanner.nextLine();
					if(br.readLine().contains("test")) {
						System.out.println("Found it");
					}
					else{
						System.out.println("search not found");
					}
				}*/
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
}