package fi.jamk.productlisterbackend.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Monttinen
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"ShopName"}))
public class Shop implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idShop;
	private String ShopName;
	private String ShopAddress;
	private String ShopLocation;

	public Shop() {
	}

	public int getShopId(){
		return idShop;
	}
	
	public String getShopName(){
		return ShopName;
	}
	
	public String getShopAddress(){
		return ShopAddress;
	}
	
	public String getShopLocation(){
		return ShopLocation;
	}

	public void setShopName(String ShopName) {
		this.ShopName = ShopName;
	}

	public void setShopAddress(String ShopAddress) {
		this.ShopAddress = ShopAddress;
	}

	public void setShopLocation(String ShopLocation) {
		this.ShopLocation = ShopLocation;
	}
	
	
	@Override
	public String toString(){
		return ShopName;
	}
}
