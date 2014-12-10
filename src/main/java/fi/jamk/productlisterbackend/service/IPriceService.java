/*
 */
package fi.jamk.productlisterbackend.service;

import fi.jamk.productlisterbackend.model.Price;
import java.util.List;

/**
 *
 * @author Antti Minkkinen
 */
public interface IPriceService {
	public void addPrice(Price p) throws Exception;
	public List<Price> getPrices(int productId, int shopId) throws Exception;
}
