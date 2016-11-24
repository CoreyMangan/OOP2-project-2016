import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MainFrame extends JFrame implements ActionListener, Serializable{
	JMenu fileMenu, gameMenu;
	JMenuBar menuBar;
	Container cPane = getContentPane();
	JLabel text;
	boolean isFile;
	File f = new File("GameDetails.txt");
	String s;
	//GameDetails GD = new GameDetails();
	//SaleDetails SD = new SaleDetails();
	ArrayList gameList = new ArrayList();
	
	/*int totNewPrice;
	int totOldPrice;
	int numOfGames;*/
	
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
		cPane.add(text);
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
	
	public void actionPerformed(ActionEvent e) {
		String menuName= e.getActionCommand();
		
		//Action when "New" is pressed
		if(menuName.equals("New")) {
			createTextFile();
			checkFileExists();
		}
		
		//Action when "Save" is pressed
		if(menuName.equals("Save")) {
			//try {
				saveFile();
			/*} catch(Exception ex3) {
				JOptionPane.showMessageDialog(null, "File Not Found");
			}*/
			JOptionPane.showMessageDialog(null, "File Saved");
		}
		
		//Action when "Delete" is pressed
		if(menuName.equals("Delete")) {
			deleteTextFile();
			checkFileExists();
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
			}
			else {
				JOptionPane.showMessageDialog(null, "No File Found", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		//Action when "Display" is pressed
		if(menuName.equals("Display")) {
			//readFile();
			AddGameFrame agf = new AddGameFrame();
			agf.setVisible(true);
			
			/*System.out.println(GameDetails.numOfGames);
			System.out.println(GameDetails.totUsedPrice);
			System.out.println(GameDetails.totNewPrice);*/

			//JOptionPane.showMessageDialog(null, gameList);
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
				JOPSID("Release Date: "),
				Float.parseFloat(JOPSID("Used Price: ")),
				Float.parseFloat(JOPSID("New Price: ")),
				Integer.parseInt(JOPSID("Stock: ")),
				Boolean.parseBoolean(JOPSID("Used Available?: "))
				)
			);
		System.out.println(GD.toString());
		gameList.add(GD.toString());
		JOptionPane.showMessageDialog(null, "Details added to Game List");
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