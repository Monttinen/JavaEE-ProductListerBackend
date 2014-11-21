/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.EMHelper;
import fi.jamk.productlister.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Antti Minkkinen
 */
public class ProductService implements IProductService {

	@Override
	public List<Product> getProducts() {
		EntityManager em = EMHelper.getEM();
		
		em.getTransaction().begin();

		List<Product> result = em.createQuery("from Product", Product.class).getResultList();
		em.getTransaction().commit();
		
		em.close();
		return result;
	}

	@Override
	public void addProduct(Product p) throws Exception {
		EntityManager em = EMHelper.getEM();
		
		em.getTransaction().begin();
		List<Product> result = em.createQuery("from Product p WHERE p.ProductName='" + p.getProductName()+"'", Product.class).getResultList();
		em.getTransaction().commit();
		if (result.isEmpty()) {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			em.close();
		} else {
			em.close();
			throw new Exception("Product already exists in database.");
		}
	}

	@Override
	public List<Product> getProducts(String keyword) {
		EntityManager em = EMHelper.getEM();
		
		em.getTransaction().begin();

		TypedQuery<Product> query = em.createQuery("from Product where ProductName LIKE :keyword", Product.class);
		query.setParameter("keyword", "%" + keyword + "%");

		List<Product> result = query.getResultList();
		em.getTransaction().commit();
		
		em.close();
		return result;
	}

}
