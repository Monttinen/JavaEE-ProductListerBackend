/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.Product;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Antti Minkkinen
 */
public class ProductService implements IProductService {

	EntityManager em;

	public ProductService() {
		em = Persistence.createEntityManagerFactory("fi.jamk.productlister.pu").createEntityManager();
	}

	@Override
	public List<Product> getProducts() {
		em.getTransaction().begin();

		List<Product> result = em.createQuery("from Product", Product.class).getResultList();
		em.getTransaction().commit();

		return result;
	}

	@Override
	public void addProduct(Product p) throws Exception {
		em.getTransaction().begin();
		List<Product> result = em.createQuery("from Product p WHERE p.ProductName='" + p.getProductName()+"'", Product.class).getResultList();
		em.getTransaction().commit();
		if (result.isEmpty()) {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		} else {
			throw new Exception("Product already exists in database.");
		}
	}

	@Override
	public List<Product> getProducts(String keyword) {
		em.getTransaction().begin();

		TypedQuery<Product> query = em.createQuery("from Product where ProductName LIKE :keyword", Product.class);
		query.setParameter("keyword", "%" + keyword + "%");

		List<Product> result = query.getResultList();
		em.getTransaction().commit();

		return result;
	}

}
