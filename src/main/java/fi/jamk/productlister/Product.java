package fi.jamk.productlister;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"ProductName"}))
public class Product implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty
	private int idProduct;
	@JsonProperty
	private int ProductCategoryId;
	@JsonProperty
	private String ProductName;
	@JsonProperty
	private String ProductBarcode;
	
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
		return "id: "+idProduct+", name: "+ProductName+", categoryId: "+ProductCategoryId+", barcode: "+ProductBarcode;
	}
}
