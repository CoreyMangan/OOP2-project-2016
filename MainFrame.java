import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainFrame extends JFrame implements ActionListener{
	JMenu fileMenu, gameMenu;
	JMenuBar menuBar;
	Container cPane = getContentPane();
	JLabel text;
	boolean isFile;
	
	//Setup JFrame
	public MainFrame() {
		super("eGames System");
		setSize(500,500);
		setLocation(250,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Calling methods
		createFileMenu();
		createGameMenu();
		
		cPane.setLayout(new FlowLayout());
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBackground(new Color(0xeeddcc));
		menuBar.add(fileMenu);
		menuBar.add(gameMenu);
	}
	
	public void actionPerformed(ActionEvent e) {
		String menuName= e.getActionCommand();
		
		//Action when "New" is pressed
		if(menuName.equals("New")) {
			createTextFile();
			
			text = new JLabel ("'Games > Add' to add a new game to the list");
			cPane.add(text);
			validate();
		}
		
		//Action when "Save" is pressed
		if(menuName.equals("Save")) {
			JOptionPane.showMessageDialog(null, "File Saved");
		}
		
		//Action when "Delete" is pressed
		if(menuName.equals("Delete")) {
			deleteTextFile();
		}
		
		//Action when "Exit" is pressed
		if(menuName.equals("Exit")) {
			JOptionPane.showMessageDialog(null, "Exiting Program... GoodBye!");
			System.exit(0);
		}
		
		//Action when "Add" is pressed
		if(menuName.equals("Add")) {
			if(isFile) {
					AddGameFrame agf = new AddGameFrame();
					agf.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "No File Found", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		//Action when "Display" is pressed
		if(menuName.equals("Display")) {
			
		}
	}
	
	//Creating File Menu
	public void createFileMenu() {
		JMenuItem item;
		fileMenu = new JMenu("File");
		
		//Creating "New" menu item
		item = new JMenuItem("New");
		item.addActionListener(this);
		item.setBackground(new Color(0xccccff));
		fileMenu.add(item);
		
		//Creating "Open" menu item
		item = new JMenuItem("Open");
		item.addActionListener(this);
		item.setBackground(new Color(0xccccff));
		fileMenu.add(item);
		
		//Creating "Save" menu item
		item = new JMenuItem("Save");
		item.addActionListener(this);
		item.setBackground(new Color(0xccccff));
		fileMenu.add(item);
		
		//Creating "Delete" menu item
		item = new JMenuItem("Delete");
		item.addActionListener(this);
		item.setBackground(new Color(0xccccff));
		fileMenu.add(item);
		
		fileMenu.addSeparator();
		
		//Creating "Exit" menu item
		item = new JMenuItem("Exit");
		item.addActionListener(this);
		item.setBackground(new Color(0xccccff));
		fileMenu.add(item);
	}
	
	//Creating Game Menu
	public void createGameMenu() {
		JMenuItem item;
		gameMenu = new JMenu("Game");
		
		//Creating "Add" menu item
		item = new JMenuItem("Add");
		item.addActionListener(this);
		item.setBackground(new Color(0xccccff));
		gameMenu.add(item);
		
		//Creating "Edit" menu item
		item = new JMenuItem("Edit");
		item.addActionListener(this);
		item.setBackground(new Color(0xccccff));
		gameMenu.add(item);
		
		gameMenu.addSeparator();
		
		//Creating "Display" menu item
		item = new JMenuItem("Display");
		item.addActionListener(this);
		item.setBackground(new Color(0xccccff));
		gameMenu.add(item);
	}
	
	//Creates a txt file to store game details
	public void createTextFile() {
		try {
				File f = new File("GameDetails.txt");
				isFile = true;
				
				if(f.createNewFile()) {
					JOptionPane.showMessageDialog(null, "New File Created");
				}
				else {
					JOptionPane.showMessageDialog(null, "File alread Exists");
				}
			} catch(IOException ex) {
				ex.printStackTrace();
			}
	}
	
	//Deleting the txt file that was created
	public void deleteTextFile() {
		try {
			File f = new File("GameDetails.txt");
			isFile = false;
			
			if(f.delete()) {
				JOptionPane.showMessageDialog(null, f.getName() + " File is Deleted");
			}
			else {
				JOptionPane.showMessageDialog(null, "File doesn't Exists");
			}
		}catch(Exception ex2) {
				ex2.printStackTrace();
			}
	}
}