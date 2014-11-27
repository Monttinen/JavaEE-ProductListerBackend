package fi.jamk.productlister;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table
public class Category implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategory;
	private String CategoryName;
	private int CategoryParentId;
	private String CategoryDescription;

	public Category() {
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

	public void setCategoryName(String CategoryName) {
		this.CategoryName = CategoryName;
	}

	public void setCategoryParentId(int CategoryParentId) {
		this.CategoryParentId = CategoryParentId;
	}

	public void setCategoryDescription(String CategoryDescription) {
		this.CategoryDescription = CategoryDescription;
	}
	
	
	@Override
	public String toString(){
		return CategoryName;
	}
}
