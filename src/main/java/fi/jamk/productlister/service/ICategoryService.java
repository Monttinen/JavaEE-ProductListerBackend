/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.Category;
import java.util.List;

/**
 *
 * @author Antti Minkkinen
 */
public interface ICategoryService {
	public List<Category> getCategories();
	public List<Category> getSubCategory(Category c);
}
