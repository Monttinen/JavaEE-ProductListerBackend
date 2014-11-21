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
	@Override
	public List<Category> getCategories() {
		EntityManager em = EMHelper.getEM();
		
		em.getTransaction().begin();
		
		List<Category> result = em.createQuery("from Category where CategoryParentId=-1", Category.class).getResultList();
		em.getTransaction().commit();
		
		em.close();
		return result;
	}

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
