/*
 */
package fi.jamk.productlisterbackend.service.impl;

import fi.jamk.productlisterbackend.EMHelper;
import fi.jamk.productlisterbackend.model.Price;
import fi.jamk.productlisterbackend.model.Product;
import fi.jamk.productlisterbackend.model.Shop;
import fi.jamk.productlisterbackend.service.IPriceService;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Antti Minkkinen
 */
public class PriceService implements IPriceService {

	/**
	 * Add a default price for testing.
	 */
	public PriceService() {
		EntityManager em = EMHelper.getEM();
		em.getTransaction().begin();

		Price p1 = new Price();
		p1.setProductId(1);
		p1.setShopId(1);
		p1.setQuantityPrice(0.98);

		em.persist(p1);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Adds a price to database.
	 *
	 * @param p
	 * @throws Exception if prices are not correct.
	 */
	@Override
	public void addPrice(Price p) throws Exception {

		if (!p.isValid()) {
			throw new Exception("Price is invalid.");
		}

		EntityManager em = EMHelper.getEM();
		em.getTransaction().begin();

		// Check if the Shop and Product exist.
		if (em.find(Product.class, p.getProductId()) == null) {
			em.getTransaction().rollback();
			em.close();
			throw new Exception("Product of the price does not exist.");
		} else {

		}
		if (em.find(Shop.class, p.getShopId()) == null) {
			em.getTransaction().rollback();
			em.close();
			throw new Exception("Shop of the price does not exist.");
		}
		try {
			em.persist(p);
		} catch(Exception e){
			throw new Exception("That price for that product in that shop already exists.");
		}
		em.getTransaction().commit();
		em.close();

	}

	/**
	 * Gets a list of prices based on parameters. At least one of these needs to
	 * be > 0.
	 *
	 * @param productId
	 * @param shopId
	 * @return
	 */
	@Override
	public List<Price> getPrices(int productId, int shopId) throws Exception {
		EntityManager em = EMHelper.getEM();
		String query = "";
		if (productId > 0 && shopId > 0) {
			query = " WHERE p.productId = " + productId + " AND p.shopId = " + shopId;
		} else if (productId > 0 && shopId < 1) {
			query = " WHERE p.productId = " + productId;
		} else if (productId < 1 && shopId > 0) {
			query = " WHERE p.shopId = " + shopId;
		} else if (productId < 1 && shopId < 1) {
			// dont allow searches where neither parameter is defined properly
			throw new Exception("productId or shopId needs to be > 0");
		}
		em.getTransaction().begin();

		List<Price> result = em.createQuery("from Price p" + query, Price.class).getResultList();
		em.getTransaction().commit();

		em.close();
		return result;
	}

}
