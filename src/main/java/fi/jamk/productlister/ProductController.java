/*
 */
package fi.jamk.productlister;

import fi.jamk.productlister.service.ProductService;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for Products.
 *
 * @author Antti Minkkinen
 */
@RestController
@RequestMapping("/data")
public class ProductController {

	//@Autowired
	private ProductService productService = new ProductService();

	@RequestMapping("/products")
	public HashMap<String, Object> getProducts(@RequestParam(value = "keyword", required = false,
			defaultValue = "") String keyword) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		System.out.println("Got a request to list products, keyword=" + keyword);
		List<Product> list = productService.getProducts(keyword);
		
		result.put("Success", "1");
		result.put("Products", list);
		return result;
	}

	@RequestMapping("/addproduct")
	public HashMap<String, Object> addProduct(@RequestBody Product p) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("Got a request to add product: " + p);
		try {
			productService.addProduct(p);
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
			return result;
		}
		result.put("success", "1");
		return result;
	}
}
