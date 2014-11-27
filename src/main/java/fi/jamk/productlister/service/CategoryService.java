/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.Category;
import fi.jamk.productlister.EMHelper;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Antti Minkkinen
 */
public class CategoryService implements ICategoryService{
	/**
	 * Inserts some hard coded categories.
	 */
	public CategoryService(){
		EntityManager em = EMHelper.getEM();
		em.getTransaction().begin();
		
		Category c1 = new Category();
		c1.setCategoryDescription("Juomat");
		c1.setCategoryName("Juoma");
		c1.setCategoryParentId(0);
		em.persist(c1);
		
		Category c2 = new Category();
		c2.setCategoryDescription("Oluet");
		c2.setCategoryName("Olut");
		c2.setCategoryParentId(1);
		em.persist(c2); // NOTE: parentId might not work like this.
		
		Category c3 = new Category();
		c3.setCategoryDescription("Ruoka tuotteet");
		c3.setCategoryName("Ruoka");
		c3.setCategoryParentId(0);
		em.persist(c3);
		
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Gets a list of categories.
	 * @return List<Category>
	 */
	@Override
	public List<Category> getCategories() {
		EntityManager em = EMHelper.getEM();
		
		em.getTransaction().begin();
		
		List<Category> result = em.createQuery("from Category where CategoryParentId=0", Category.class).getResultList();
		em.getTransaction().commit();
		
		em.close();
		return result;
	}
	
	/**
	 * Gets a list of categories based on CategoryParentId.
	 * @return List<Category>
	 */
	@Override
	public List<Category> getCategories(int categoryId) {
		EntityManager em = EMHelper.getEM();
		
		em.getTransaction().begin();
		
		List<Category> result = em.createQuery("from Category where CategoryParentId="+categoryId, Category.class).getResultList();
		em.getTransaction().commit();
		
		em.close();
		return result;
	}
}
