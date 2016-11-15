import java.awt.*;

/* Title, Desc, Genre, Age Rating, Platform, | Release Date, usedPrice, newPrice, stock, usedAvailable? */

public class SaleDetails {
	private String releaseDate;
	private float usedPrice;
	private float newPrice;
	private int stock;
	private boolean usedAvailable;
	
	//Constructors
	public SaleDetails() {
		this("Unkown", 0.0f, 0.0f, 0, false);
	}
	
	public SaleDetails(String releaseDate, float usedPrice, float newPrice, int stock, boolean usedAvailable) {
		setReleaseDate(releaseDate);
		setUsedPrice(usedPrice);
		setNewPrice(newPrice);
		setStock(stock);
		setUsedAvailable(usedAvailable);
	}
	
	//Accessors
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setUsedPrice(float usedPrice) {
		this.usedPrice = usedPrice;
	}
	
	public void setNewPrice(float newPrice) {
		this.newPrice = newPrice;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void setUsedAvailable(boolean usedAvailable) {
		this.usedAvailable = usedAvailable;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public float getUsedPrice() {
		return usedPrice;
	}
	
	public float getNewPrice() {
		return newPrice;
	}
	
	public boolean getUsedAvailable() {
		return usedAvailable;
	}
	
	public String toString() {
		return String.format("Release Date: %s\n UsedPrice: %.2f\n NewPrice %.2f\n UsedAvailable %s\n",
							getReleaseDate(), getUsedPrice(), getNewPrice(), getUsedAvailable());
	}
}