/**
 *	This is the main class that does most of the work.
 *	@author Corey Mangan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MainFrame extends JFrame implements ActionListener, Serializable{
	private JMenu fileMenu, gameMenu;
	private JMenuBar menuBar;
	private Container cPane = getContentPane();
	private JLabel text;
	private boolean isFile;
	public File f = new File("GameDetails.txt");
	public SaleDetails SD = new SaleDetails();
	public ArrayList gameList = new ArrayList();
	//public static boolean editCheck;
	
	//Setup JFrame
	public MainFrame() {
		super("eGames System");
		setSize(500,500);
		setLocation(250,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Calling methods
		createFileMenu();
		createGameMenu();
		
		//Setting up menu and menuBar
		cPane.setLayout(new FlowLayout());
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBackground(new Color(0xeeddcc));
		menuBar.add(fileMenu);
		menuBar.add(gameMenu);
		
		//Adding text
		text = new JLabel();
		cPane.add(text);
		checkFileExists();
		
		//What happens when you click the X button
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int r = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(r == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Exiting Program... GoodBye!");
				System.exit(0);
				}
				else
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			}
		});
	}
	
	//Setting up what happens when you press each menu button
	public void actionPerformed(ActionEvent e) {
		String menuName= e.getActionCommand();
		
		//Action when "New" is pressed
		if(menuName.equals("New")) {
			createTextFile();
			checkFileExists();
		}
		
		//Action when "Save" is pressed
		if(menuName.equals("Save")) {
			try {
				saveFile();
				text.setText("Game > Display to display the details in File.");
			} catch(Exception ex3) {
				JOptionPane.showMessageDialog(null, "File Not Found");
			}
			JOptionPane.showMessageDialog(null, "File Saved");
		}
		
		//Action when "Delete" is pressed
		if(menuName.equals("Delete")) {
			deleteTextFile();
			checkFileExists();
			text.setText("File > New to create a new file.");
		}
		
		//Action when "Exit" is pressed
		if(menuName.equals("Exit")) {
			int r = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
			if(r == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Exiting Program... GoodBye!");
				System.exit(0);
			}
		}
		
		//Action when "Add" is pressed
		if(menuName.equals("Add")) {
			if(isFile) {
				addDetails();
				text.setText("File > Save to save details to File.");
			}
			else {
				JOptionPane.showMessageDialog(null, "No File Found", "Error", JOptionPane.WARNING_MESSAGE);
			}				
		}
		
		//Action when "Edit" is pressed
		if(menuName.equals("Edit")) {
			/*editCheck = true;
			AddGameFrame agf = new AddGameFrame();
			agf.setVisible(true);*/
			//int n = Integer.parseInt(JOPSID("Enter list number of game you want to edit: "));
			//gameList.set(n, JOPSID(gameList.toString()));
			
			try (BufferedReader br = new BufferedReader(new FileReader("GameDetails.txt"))) {
				String line;
				int lines = 0;
				String search = JOPSID("Enter value you want to edit");
				String edit = JOPSID("Enter value you want to change it to");
				while((line = br.readLine()) != null) {
					lines++;
					if(line.contains(search)) {
						System.out.println(search);
						System.out.println(lines);
						System.out.println(edit);
						//gameList.set(lines, edit);
						//gameList.add(line.replace(search, edit));
						JOptionPane.showMessageDialog(null, "replaced " + search + " to " + edit);
						gameList.set(lines - 1, line.replace(search, edit));
					}
				}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "File not found");
				}
			
		}
		
		//Action when "Display" is pressed
		if(menuName.equals("Display")) {
			DisplayFrame agf = new DisplayFrame();
			agf.setVisible(true);
			text.setText("Game > Add to add a new game to the list.");
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
	
	//Checking if GameDetails file exists
	public void checkFileExists() {
		if(f.exists()) {
			isFile = true;
			text.setText("'Games > Add' to add a new game to the list");
		} else if(!f.exists()) {
			isFile = false;
			text.setText("");
			text.setText("File > New to create a new file.");
		}
		validate();
	}
	
	//Entering in details for list
	public void addDetails() {		
		GameDetails GD = new GameDetails(
			JOPSID("Title: "),
			JOPSID("Description: "),
			JOPSID("Genre: "),
			Integer.parseInt(JOPSID("Age Rating: ")),
			JOPSID("Platform: "),
			new SaleDetails(
				JOPSID("Release Date (DD-MM_YYYY): "),
				Float.parseFloat(JOPSID("Used Price: ")),
				Float.parseFloat(JOPSID("New Price: ")),
				Integer.parseInt(JOPSID("Stock: ")),
				Boolean.parseBoolean(JOPSID("Used Available?: "))
				)
			);
			
		//Adding the details entered to the arraylist
		gameList.add(GD.toString());
		JOptionPane.showMessageDialog(null, "Details added to Game List");
		
		//trying to get boolean to accept something other than "true" as true
		String boolAnswer = String.valueOf(SD.getUsedAvailable());
		System.out.println(boolAnswer);
		if(boolAnswer.toLowerCase() == "t" || boolAnswer == "true" || boolAnswer.toLowerCase() == "y" || boolAnswer == "yes")
			SD.setUsedAvailable(true);
			//GD.getSD().setUsedAvailable(true);
			
		//Calculating info
		GD.numOfGames++;
		GD.totUsedPrice += GD.getSD().getUsedPrice();
		GD.totNewPrice += GD.getSD().getNewPrice();
	}
	
	//shortcut method
	public String JOPSID(String msg) {
		String s;
		s = JOptionPane.showInputDialog(msg);
		return s;
	}
	
	//Saving details in arraylist to the save file
	public void saveFile(){
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("GameDetails.txt"));
			pw.println(gameList);
			pw.close();	
		} catch(Exception ex3) {
			JOptionPane.showMessageDialog(null, "File Not Found");
		}
		
	}
}