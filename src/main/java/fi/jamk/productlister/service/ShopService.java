/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.EMHelper;
import fi.jamk.productlister.Shop;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Antti Minkkinen
 */
public class ShopService implements IShopService {

	@Override
	public List<Shop> getShops() {
		EntityManager em = EMHelper.getEM();
		em.getTransaction().begin();
		
		List<Shop> result = em.createQuery("from Shop", Shop.class).getResultList();
		em.getTransaction().commit();
		
		em.close();
		return result;
	}

	@Override
	public void addShop(Shop s) throws Exception {
		EntityManager em = EMHelper.getEM();
		
		em.getTransaction().begin();
		List<Shop> result = em.createQuery("from Product p WHERE p.ProductName='" + s.getShopName()+"'", Shop.class).getResultList();
		em.getTransaction().commit();
		if (result.isEmpty()) {
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
		} else {
			em.close();
			throw new Exception("Shop already exists in database.");
		}
	}

	@Override
	public Shop getShopId(int shopId) throws Exception {
		EntityManager em = EMHelper.getEM();
		Shop s = em.find(Shop.class, shopId);
		if(s == null){
			throw new Exception("No shop with that id.");
		}
		return s;
	}
	
}