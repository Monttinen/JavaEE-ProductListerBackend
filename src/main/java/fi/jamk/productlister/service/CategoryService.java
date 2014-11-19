/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Antti Minkkinen
 */
public class CategoryService implements ICategoryService{
	EntityManager em;
	
	public CategoryService(){
		em = Persistence.createEntityManagerFactory("fi.jamk.productlister.pu").createEntityManager();
	}
	
	@Override
	public List<Category> getCategories() {
		em.getTransaction().begin();
		
		List<Category> result = em.createQuery("from Category where CategoryParentId=-1", Category.class).getResultList();
		em.getTransaction().commit();
		
		return result;
	}

	@Override
	public List<Category> getCategories(int categoryId) {
		em.getTransaction().begin();
		
		List<Category> result = em.createQuery("from Category where CategoryParentId="+categoryId, Category.class).getResultList();
		em.getTransaction().commit();
		
		return result;
	}
}
