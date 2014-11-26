package fi.jamk.productlister;



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
	
	public Shop(String name, String address, String location){
		this.ShopName = name;
		this.ShopAddress = address;
		this.ShopLocation = location;
	}
	
	public int getShopId(){
		return idShop;
	}
	
	public String getShopName(){
		return ShopName;
	}
	
	public String getShopAdddress(){
		return ShopAddress;
	}
	
	public String getShopLocation(){
		return ShopLocation;
	}
	
	@Override
	public String toString(){
		return ShopName;
	}
}
