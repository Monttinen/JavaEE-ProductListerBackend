/*
 */
package fi.jamk.productlister.service.impl;

import fi.jamk.productlister.EMHelper;
import fi.jamk.productlister.model.Price;
import fi.jamk.productlister.service.IPriceService;
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
	public PriceService(){
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
	 * @param p
	 * @throws Exception if prices are not correct.
	 */
	@Override
	public void addPrice(Price p) throws Exception {
		
		if(p.isValid()){
			EntityManager em = EMHelper.getEM();
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			em.close();
		}
	}
	
	/**
	 * Gets a list of prices based on parameters. At least one of these needs to be > 0.
	 * @param productId
	 * @param shopId
	 * @return 
	 */
	@Override
	public List<Price> getPrices(int productId, int shopId) throws Exception {
		EntityManager em = EMHelper.getEM();
		String query = "";
		if(productId > 0 && shopId > 0){
			query = " WHERE p.productId = "+productId+" AND p.shopId = "+shopId;
		} else if(productId > 0 && shopId < 1){
			query = " WHERE p.productId = "+productId;
		} else if(productId < 1 && shopId > 0){
			query = " WHERE p.shopId = "+shopId;
		} else if(productId < 1 && shopId < 1){
			// dont allow searches where neither parameter is defined properly
			throw new Exception("productId or shopId needs to be > 0");
		}
		em.getTransaction().begin();

		List<Price> result = em.createQuery("from Price p"+query, Price.class).getResultList();
		em.getTransaction().commit();
		
		em.close();
		return result;
	}
	
}
