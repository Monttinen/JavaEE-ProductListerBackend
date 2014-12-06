/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.model.Category;
import java.util.List;

/**
 *
 * @author Antti Minkkinen
 */
public interface ICategoryService {
	public List<Category> getCategories();
	public List<Category> getCategories(int categoryId);
}
