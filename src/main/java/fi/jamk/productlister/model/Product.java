package fi.jamk.productlister.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Monttinen
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"ProductName"}))
public class Product implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;
	private int ProductCategoryId;
	private String ProductName;
	private String ProductBarcode;

	public Product() {
	}

	public int getProductId(){
		return idProduct;
	}
	
	public int getProductCategoryId(){
		return ProductCategoryId;
	}
	
	public String getProductName(){
		return ProductName;
	}
	
	public String getProductBarcode(){
		return ProductBarcode;
	}

	public void setProductCategoryId(int ProductCategoryId) {
		this.ProductCategoryId = ProductCategoryId;
	}

	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}

	public void setProductBarcode(String ProductBarcode) {
		this.ProductBarcode = ProductBarcode;
	}

	
	@Override
	public String toString(){
		return "id: "+idProduct+", name: "+ProductName+", categoryId: "+ProductCategoryId+", barcode: "+ProductBarcode;
	}
}
