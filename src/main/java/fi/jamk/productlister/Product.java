package fi.jamk.productlister;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table
public class Product implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;
	private int ProductCategoryId;
	private String ProductName;
	private String ProductBarcode;

	public Product() {
	}
	
	public Product(int cateogryId, String name, String barcode){
		this.ProductBarcode = barcode;
		this.ProductName = name;
		this.ProductCategoryId = cateogryId;
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
	
	@Override
	public String toString(){
		return ProductName;
	}
}
