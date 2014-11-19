/*
 */
package fi.jamk.productlister;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.jamk.productlister.service.CategoryService;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for Categories.
 *
 * @author Antti Minkkinen
 */
@RestController
@RequestMapping("/data")
public class CategoryController {

	private CategoryService categoryService = new CategoryService();

	@RequestMapping("/category")
	public List<Category> getCategorys(@RequestParam(value = "categoryId", required = false,
			defaultValue = "") String categoryIdString) {

		System.out.println("Got a request to list categories, categoryId=" + categoryIdString);
		List<Category> list;
		if (categoryIdString.length() > 0) {
			int categoryId = Integer.parseInt(categoryIdString);
			list = categoryService.getCategories(categoryId);
		} else {
			list = categoryService.getCategories();
		}
		return list;
	}
}
