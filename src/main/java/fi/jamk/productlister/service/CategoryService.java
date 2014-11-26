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
		em.persist(new Category("Juoma", 0, "Juomat"));
		em.persist(new Category("Olut", 1, "Oluet")); // NOTE: parentId might not work like this.
		em.persist(new Category("Ruoka", 0, "Ruoka tuotteet"));
		
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
