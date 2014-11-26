package fi.jamk.productlister;



import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table
public class Category implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("idCategory")
	private int idCategory;
	@JsonProperty("CategoryName")
	private String CategoryName;
	@JsonProperty("CategoryParentId")
	private int CategoryParentId;
	@JsonProperty("CategoryDescription")
	private String CategoryDescription;

	public Category() {
	}

	public Category(String name, int parentId, String description){
		this.CategoryName = name;
		this.CategoryParentId = parentId;
		this.CategoryDescription = description;
	}
	
	public String getCategoryName(){
		return CategoryName;
	}
	
	public String getCategoryDescription(){
		return CategoryDescription;
	}
	
	public int getCategoryParentId(){
		return CategoryParentId;
	}
	
	public int getCategoryId(){
		return idCategory;
	}
	
	@Override
	public String toString(){
		return CategoryName;
	}
}
