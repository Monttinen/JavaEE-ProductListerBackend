/*
 */
package fi.jamk.productlisterbackend;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antti Minkkinen
 */
public class EMHelper {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("fi.jamk.productlisterbackend.pu");
	public static EntityManager getEM(){
		return emf.createEntityManager();
	}
}
