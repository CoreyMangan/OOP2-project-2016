import java.awt.*;

/** The GameDetails class extends SaleDetails
 *	This class enters the details for the Games that will be displayed
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
	 *	@param	Title		The title of the game(string)
	 *	@param	Desc		The description or quick summary about the game(string)
	 *	@param	Genre		The genre of the game e.g. Action, RPG, FPS, Platformer, etc..(string)
	 *	@param	AgeRating	The age you have to be to purchase the game(int)
	 *	@param	Platform	The platform this game is on e.g. xbox, ps4, pc, etc..(string)
	 *	@param	SD			Gets the rest of the details from the SaleDetails class(releaseDate, usedPrice, newPrice, stock, usedAvailable) */
	public GameDetails(String title, String desc, String genre, int ageRating, String platform, SaleDetails SD) {
		setTitle(title);
		setDesc(desc);
		setGenre(genre);
		setAgeRating(ageRating);
		setPlatform(platform);
		setSD(SD);
	}
	
	//Mutators
	/** @param setTitle	Sets the title of game , returns void, enters string */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/** @param setDesc	Sets the description of game, returns void, enters string */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/** @param setGenre	Sets the genre of game, returns void, enters string */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/** @param setAgeRating	Sets the age rating of game, returns void, enters int */
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}
	
	/** @param setPlatform	Sets the platorm of game, returns void, enters string */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	/** @param setSD	Sets the @link SaleDetails of game, returns void, enters SaleDetails */
	public void setSD(SaleDetails SD) {
		this.SD = SD;
	}
	
	//Accessors
	/** @param getTitle	Gets the title of game, returns string */
	public String getTitle() {
		return title;
	}
	
	/** @param getDesc	Gets the description of game, returns string */
	public String getDesc() {
		return desc;
	}
	
	/** @param getGenre	Gets the genre of game, returns string */
	public String getGenre() {
		return genre;
	}
	
	/** @param getAgeRating	Gets the age rating of game, returns int */
	public int getAgeRating() {
		return ageRating;
	}
	
	/** @param getPlatform	Gets the platform of game, returns string */
	public String getPlatform() {
		return platform;
	}
	
	/** @param getSD	Gets the @link SaleDetails of game, returns SaleDetails */
	public SaleDetails getSD() {
		return SD;
	}
	
	//formating	
	/** @param toString	formats data, returns string */
	public String toString() {
		return String.format("Title: %s\n Description: %s\n Genre: %s\n AgeRating: %d\n Platform: %s\n %s\n",
							getTitle(), getDesc(), getGenre(), getAgeRating(), getPlatform(), getSD());
	}
}