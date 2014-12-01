/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.Price;
import java.util.List;

/**
 *
 * @author Antti Minkkinen
 */
public interface IPriceService {
	public void addPrice(Price p) throws Exception;
	public List<Price> getPrices(int productId, int shopId) throws Exception;
}
