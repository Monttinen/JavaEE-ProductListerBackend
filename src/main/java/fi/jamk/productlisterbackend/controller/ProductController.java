/*
 */
package fi.jamk.productlisterbackend.controller;

import fi.jamk.productlisterbackend.model.Product;
import fi.jamk.productlisterbackend.model.ProductImage;
import fi.jamk.productlisterbackend.service.impl.ProductService;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * RestController for Products.
 *
 * @author Antti Minkkinen
 */
@Controller
@RestController
@RequestMapping("/data")
public class ProductController {

	// Change this to correspond your web servers folder.
	//private final String imgPath = "D:\\xampp\\htdocs\\img\\";
	private final String imgPath = "/var/www/html/img/";
	private final ProductService productService = new ProductService();

	/**
	 * Gets a list of products based on keyword.
	 *
	 * @param keyword
	 * @param categoryIdString
	 * @return JSON list of products.
	 */
	@RequestMapping("/products")
	public HashMap<String, Object> getProducts(@RequestParam(value = "keyword", required = false,
			defaultValue = "") String keyword, @RequestParam(value = "categoryId", required = false, defaultValue = "0") String categoryIdString) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		System.out.println("Got a request to list products, keyword=" + keyword + ", categoryId=" + categoryIdString);

		int categoryId;
		try {
			categoryId = Integer.parseInt(categoryIdString);

			List<Product> list;
			list = productService.getProducts(keyword, categoryId);

			result.put("success", "1");
			result.put("products", list);
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
		}

		return result;
	}

	/**
	 * Accepts a product as JSON and attempts to save it to database. After
	 * success returns the product id for uploading image.
	 *
	 * @param p
	 * @return JSON saved productId
	 */
	@RequestMapping("/addproduct")
	public HashMap<String, Object> addProduct(@RequestBody Product p) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("Got a request to add product: " + p);
		try {
			productService.addProduct(p);

			result.put("success", "1");
			result.put("productid", p.getProductId());
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
			return result;
		}
		return result;
	}

	/**
	 * A method for testing the file uploading.
	 *
	 * @return HTML page as string for uploading
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public @ResponseBody
	String provideUploadInfo() {
		return "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<body>\n"
				+ "	<form method=\"POST\" enctype=\"multipart/form-data\"\n"
				+ "		action=\"/data/upload\">\n"
				+ "		File to upload: <input type=\"file\" name=\"file\"><br /> Name: <input\n"
				+ "			type=\"text\" name=\"name\"><br /> <br /> <input type=\"submit\"\n"
				+ "			value=\"Upload\"> Press here to upload the file!\n"
				+ "	</form>\n"
				+ "</body>\n"
				+ "</html>";
	}

	/**
	 * Processes image uploads to the server.
	 *
	 * @param name
	 * @param file
	 * @return JSON
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	HashMap<String, Object> handleFileUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		HashMap<String, Object> result = new HashMap<String, Object>();
		if (!file.isEmpty()) {
			// TODO more checks, if file exists, if file is too big etc...

			// TODO check if the id exists in database
			try {
				int productId = 1;
				try {
					productId = Integer.parseInt(name);
				} catch (Exception e) {
					throw new Exception("Malformed product id.");
				}
				if (!file.getContentType().equals("image/jpeg")) {
					throw new Exception("Wrong content type.");
				}
				File f = new File(imgPath + productId + ".jpg");
				if (f.exists()) {
					throw new Exception("The file already exists.");
				}

				// make sure that someone added a product with that id already
				if (!productService.checkProduct(productId)) {
					throw new Exception("The product does not exists.");
				}

				file.transferTo(f);
				result.put("success", "1");
			} catch (Exception e) {
				result.put("success", "0");
				result.put("message", "You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			result.put("success", "0");
			result.put("message", "You failed to upload " + name + " because the file was empty.");
		}

		return result;
	}
	
	/**
	 * Accepts a product image as JSON
	 * @param p
	 * @return 
	 */
	@RequestMapping(value = "/addproductimage")
	public HashMap<String, Object> addProductImage(@RequestBody ProductImage p) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			// make sure that someone added a product with that id already
			if (!productService.checkProduct(p.getProductId())) {
				throw new Exception("The product does not exists.");
			}
			File f = new File(imgPath + p.getProductId() + ".jpg");
			if (f.exists()) {
				throw new Exception("The file already exists.");
			}

			try {
				//This will decode the String which is encoded by using Base64 class
				byte[] imageByte = Base64.decodeBase64(p.getProductImage());

				String directory = imgPath + p.getProductId() + ".jpg";

				System.out.println("Writing image file: " + directory);
				FileOutputStream fos = new FileOutputStream(directory);
				fos.write(imageByte);
				fos.close();
				
				result.put("success", "1");
				result.put("productid", p.getProductId());
			} catch (Exception e) {
				System.out.println("Writing image file failed");
				result.put("success", "0");
				result.put("message", "You failed to upload image => " + e.getMessage());
			}
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
			return result;
		}

		return result;

	}
}
