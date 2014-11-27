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
	
	/**
	 * Adds some hard coded shops for testing.
	 */
	public ShopService(){
		EntityManager em = EMHelper.getEM();
		em.getTransaction().begin();
		Shop s1 = new Shop();
		s1.setShopAddress("Syöttäjänkatu 2, 40520 Jyväskylä");
		s1.setShopLocation("62.2276882,25.7733703");
		s1.setShopName("S-Market Kuokkala");
		em.persist(s1);
		
		Shop s2 = new Shop();
		s2.setShopAddress("Syöttäjänkatu 2, 40520 Jyväskylä");
		s2.setShopLocation("62.2276882,25.7733703");
		s2.setShopName("K-Supermarket Kotikenttä");
		
		em.persist(s2);
		em.getTransaction().commit();
		em.close();
	}
	
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
