package fi.jamk.productlisterbackend.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Class for product image. Image is Base64 encoded.
 * @author Antti Minkkinen
 */
@Entity
public class ProductImage implements Serializable {
	@Id
	private int productId;
	private String productImage;
	
	public ProductImage(){
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	
}
