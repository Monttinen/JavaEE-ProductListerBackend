/*
 */
package fi.jamk.productlisterbackend.service;

import fi.jamk.productlisterbackend.model.Product;
import java.util.List;

/**
 *
 * @author Antti Minkkinen
 */
public interface IProductService {
	public List<Product> getProducts(String keyword, int categoryId);
	public void addProduct(Product p) throws Exception;
}
