/*
 */
package fi.jamk.productlister;

import fi.jamk.productlister.service.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for Products.
 * @author Antti Minkkinen
 */
@RestController
@RequestMapping("/data")
public class ProductController {
	//@Autowired
	private ProductService productService = new ProductService();
	@RequestMapping("/products")
	public List<Product> getProducts(@RequestParam(value = "keyword",required = false,
	                                                    defaultValue = "") String keyword) {
		List<Product> list = productService.getProducts(keyword);
		return list;
	}
	
	@RequestMapping("/addproduct")
	public void addProduct(@RequestBody Product p) {
		
		productService.addProduct(p);
	}
} 
