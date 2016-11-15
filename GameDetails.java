import java.awt.*;

public class GameDetails extends SaleDetails{
	private String title;
	private String desc;
	private String genre;
	private int ageRating;
	private String platform;
	SaleDetails SD = new SaleDetails();
	
	public GameDetails() {
		this("Unkown", "Unkown", "Unkown", 0, "Unkown", new SaleDetails());
	}
	
	public GameDetails(String title, String desc, String genre, int ageRating, String platform, SaleDetails SD) {
		setTitle(title);
		setDesc(desc);
		setGenre(genre);
		setAgeRating(ageRating);
		setPlatform(platform);
		setSD(SD);
	}
	
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
	
	public SaleDetails getSD() {
		return SD;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public String toString() {
		return String.format("Title: %s\n Description: %s\n Genre: %s\n AgeRating: %s\n Platform: %s\n",
							getTitle(), getDesc(), getGenre(), getAgeRating(), getPlatform());
	}
}