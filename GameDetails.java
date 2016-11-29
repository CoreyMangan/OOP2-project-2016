import java.awt.*;

/** The GameDetails class extends SaleDetails
 *	This class enters the values for the Games that will be displayer 
 *	@author	Corey mangan
 *	@Date 	29/11/2016	*/

public class GameDetails extends SaleDetails{
	private String title;
	private String desc;
	private String genre;
	private int ageRating;
	private String platform;
	private SaleDetails SD;
	
	public static float totUsedPrice;
	public static float totNewPrice;
	public static int numOfGames;
	
	//Constructors
	/** GameDetails Constructor with no arguments */
	public GameDetails() {
		this("Unkown", "Unkown", "Unkown", 0, "Unkown", new SaleDetails());
	}
	
	/** GameDetails Constructor with arguments, enter in values 
	 *	@param	Title	The title of the game
	 *	@param	Desc	The description or quick summary about the game
	 *	@param Genre	The genre of the game e.g. Action, RPG, FPS, Platformer, etc..	*/	
	public GameDetails(String title, String desc, String genre, int ageRating, String platform, SaleDetails SD) {
		setTitle(title);
		setDesc(desc);
		setGenre(genre);
		setAgeRating(ageRating);
		setPlatform(platform);
		setSD(SD);
	}
	
	//Mutators
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public void setSD(SaleDetails SD) {
		this.SD = SD;
	}
	
	//Accessors
	public String getTitle() {
		return title;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getAgeRating() {
		return ageRating;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public SaleDetails getSD() {
		return SD;
	}
	
	//formating	
	public String toString() {
		return String.format("Title: %s\n Description: %s\n Genre: %s\n AgeRating: %d\n Platform: %s\n %s\n",
							getTitle(), getDesc(), getGenre(), getAgeRating(), getPlatform(), getSD());
	}
}