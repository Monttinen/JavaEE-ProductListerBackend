/*
 */
package fi.jamk.productlisterbackend.service;

import fi.jamk.productlisterbackend.model.Category;
import java.util.List;

/**
 *
 * @author Antti Minkkinen
 */
public interface ICategoryService {
	public List<Category> getCategories();
	public List<Category> getCategories(int categoryId);
}
