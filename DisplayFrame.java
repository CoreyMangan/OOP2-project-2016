/**
 *	This class adds a new jframe that displays the list of games in the save file.
 *	@author Corey Mangan
 */
import javax.swing.*;
import java.awt.List;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class DisplayFrame extends JFrame implements KeyListener {
	private Container cPane = getContentPane();
	private FlowLayout layout = new FlowLayout();
	private JTextField s;
	private JTextField search;
	private JMenuBar menuBar;
	public GameDetails GD = new GameDetails();
	
	private JPanel pnl = new JPanel(new GridLayout(12, 2));
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	
	
	private JTextArea jta2 = new JTextArea();

	
	//ArrayList gameList = new ArrayList();
	
	public DisplayFrame() {
		super("Add Game");
		setSize(500,500);
		setLocation(450,350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		search = new JTextField();
		search.setToolTipText("Enter Title of game to search");
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
					//jta2.append(line + "\n");
					if(line.contains("Title: " + search.getText())) {
						jta2.append(line + "\n" + br.readLine() + "\n" + br.readLine() + br.readLine() + "\n" + br.readLine() + 
						"\n" + br.readLine() + "\n" + br.readLine() + "\n" + br.readLine() + "\n" + br.readLine() + "\n" + br.readLine() + "\n");
						JOptionPane.showMessageDialog(null, jta2);
					}
				}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "File not found");
				}	
			
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
}