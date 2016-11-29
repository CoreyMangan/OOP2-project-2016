import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MainFrame extends JFrame implements ActionListener, Serializable{
	JMenu fileMenu, gameMenu;
	JMenuBar menuBar;
	Container cPane = getContentPane();
	JLabel text, text2;
	boolean isFile;
	File f = new File("GameDetails.txt");
	String s;
	SaleDetails SD = new SaleDetails();
	ArrayList gameList = new ArrayList();
	public static boolean editCheck;
	
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
		
		text = new JLabel();
		text2 = new JLabel();
		text2.setLocation(20,20);
		cPane.add(text);
		cPane.add(text2);
		checkFileExists();
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int r = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(r == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Exiting Program... GoodBye!");
				System.exit(0);
				}
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
			int n = Integer.parseInt(JOPSID("Enter list number of game you want to edit: "));
			gameList.set(n, JOPSID(gameList.toString()));
		}
		
		//Action when "Display" is pressed
		if(menuName.equals("Display")) {
			//readFile();
			AddGameFrame agf = new AddGameFrame();
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
	
	/*public void openFile() {
		
	}*/
	
		void addDetails() {		
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
		System.out.println(GD.toString());
		gameList.add(GD.toString());
		JOptionPane.showMessageDialog(null, "Details added to Game List");
		
		String boolAnswer = String.valueOf(SD.getUsedAvailable());
		System.out.println(boolAnswer);
		if(boolAnswer.toLowerCase() == "t" || boolAnswer == "true" || boolAnswer.toLowerCase() == "y" || boolAnswer == "yes")
			SD.setUsedAvailable(true);
			//GD.getSD().setUsedAvailable(true);
			
		GD.numOfGames++;
		GD.totUsedPrice += GD.getSD().getUsedPrice();
		GD.totNewPrice += GD.getSD().getNewPrice();
	}
	
	public String JOPSID(String msg) {
		String s;
		s = JOptionPane.showInputDialog(msg);
		return s;
	}
	
	public void saveFile(){
		try {
			/*FileOutputStream fos = new FileOutputStream("GameDetails.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(gameList);
			oos.close();*/
			PrintWriter pw = new PrintWriter(new FileOutputStream("GameDetails.txt"));
			pw.println(gameList);
			pw.close();	
		} catch(Exception ex3) {
			JOptionPane.showMessageDialog(null, "File Not Found");
		}
		
	}
	
	public void readFile() {
		try {
			FileInputStream fis = new FileInputStream("GameDetails.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			//ois.readObject(fis);
			ois.close();
		}  catch(Exception ex4) {
			JOptionPane.showMessageDialog(null, "File Not Found");
		}
	}
}