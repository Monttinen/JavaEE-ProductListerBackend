package fi.jamk.productlister;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Antti Minkkinen
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"shopId","productId"}))
public class Price  implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrice;
	private int shopId;
	private int productId;
	
	// Negative value if not available, but atleast one needs to be defined.
	private double unitPrice;
	private double quantityPrice;

	public Price(){
	}

	public int getPriceId() {
		return idPrice;
	}

	public int getShopId() {
		return shopId;
	}

	public int getIdProduct() {
		return productId;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public double getQuantityPrice() {
		return quantityPrice;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setQuantityPrice(double quantityPrice) {
		this.quantityPrice = quantityPrice;
	}
	
	@Override
	public String toString(){
		return "Price of productId "+productId+" at shopId "+shopId+": "+"q:"+quantityPrice+" u:"+unitPrice;
	}
	
	@JsonIgnore
	public boolean isValid() throws Exception {
		if(this.unitPrice >= 0.0 || this.quantityPrice >= 0.0){
			return true;
		} else {
			throw new Exception("Product has to have unit price or quantity price.");
		}
	}
}
