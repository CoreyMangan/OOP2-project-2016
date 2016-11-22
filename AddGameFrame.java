import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

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
		
		cPane.setLayout(layout);
		//createLabels();
		//createTextFields();
		//createLayout();
		
		addDetails();
		gameList.add(GD.toString());
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void createLabels() {
		lblTitle = new JLabel("Title: ");
		//lblTitle.setLocation(10,10);
		cPane.add(lblTitle);
		
		/*lblDesc = new JLabel("Description: ");
		//lblDesc.setLocation(20,10);
		cPane.add(lblDesc);*/
		
		/*lblGenre = new JLabel("Genre: ");
		//lblGenre.setLocation(30,10);
		cPane.add(lblGenre);*/
	}
	
	public void createTextFields() {
		/*for(int i = 0; i <= 2; i++) {
			switch (i) {
				case 0: s = tfTitle;
					break;
				case 1: s = tfDesc;
					break;
				case 2: s = tfGenre;
					break;
			}
			s = new JTextField(15);
			cPane.add(s);
			GD.setTitle(s.getText());
		}*/
		createTextField(tfTitle);
		GD.setTitle(tfTitle.getText());
		
		/*createTextField(tfDesc);
		GD.setDesc(tfDesc.getText());*/
	}
	
	public void createTextField(JTextField field){
		
		field = new JTextField(15);
		cPane.add(field);
	}
	
	/*public void createLayout() {
		
		
		layout.putConstraint(SpringLayout.WEST, tfTitle, 5, SpringLayout.EAST, lblTitle);
		layout.putConstraint(SpringLayout.NORTH, tfTitle, 5, SpringLayout.NORTH, lblTitle);
		
		layout.putConstraint(SpringLayout.WEST, tfTitle, 5, SpringLayout.EAST, lblTitle);
		layout.putConstraint(SpringLayout.NORTH, tfTitle, 5, SpringLayout.NORTH, cPane);
	}*/
	
	void addDetails() {
		GD.setTitle(JOPSID("Title: "));
		GD.setDesc(JOPSID("Description: "));
		GD.setGenre(JOPSID("Genre: "));
		GD.setAgeRating(Integer.parseInt(JOPSID("Age Rating: ")));
		GD.setPlatform(JOPSID("Platform: "));
		GD.setReleaseDate(JOPSID("Release Date: "));
		GD.setUsedPrice(Float.parseFloat(JOPSID("Used Price: ")));
		GD.setNewPrice(Float.parseFloat(JOPSID("New Price: ")));
		GD.setStock(Integer.parseInt(JOPSID("Stock: ")));
		GD.setUsedAvailable(Boolean.parseBoolean(JOPSID("Used Available?: ")));
	}
	
	public String JOPSID(String msg) {
		String s;
		s = JOptionPane.showInputDialog(msg);
		return s;
	}
}