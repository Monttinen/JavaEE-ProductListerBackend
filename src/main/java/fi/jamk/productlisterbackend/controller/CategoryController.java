/*
 */
package fi.jamk.productlisterbackend.controller;

import fi.jamk.productlisterbackend.model.Category;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.jamk.productlisterbackend.service.impl.CategoryService;
import java.util.HashMap;
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
	public HashMap<String,Object> getCategorys(@RequestParam(value = "categoryId", required = false,
			defaultValue = "") String categoryIdString) {

		System.out.println("Got a request to list categories, categoryId=" + categoryIdString);
		List<Category> list;
		if (categoryIdString.length() > 0) {
			int categoryId = Integer.parseInt(categoryIdString);
			list = categoryService.getCategories(categoryId);
		} else {
			list = categoryService.getCategories();
		}
		HashMap<String,Object> result = new HashMap<String, Object>();
		result.put("success", "1");
		result.put("categories", list);
		return result;
	}
}
