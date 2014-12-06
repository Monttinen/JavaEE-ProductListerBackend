/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.model.Product;
import java.util.List;

/**
 *
 * @author Antti Minkkinen
 */
public interface IProductService {
	public List<Product> getProducts(String keyword, int categoryId);
	public void addProduct(Product p) throws Exception;
}
