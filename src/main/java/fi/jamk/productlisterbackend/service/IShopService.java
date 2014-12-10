/*
 */
package fi.jamk.productlisterbackend.service;

import fi.jamk.productlisterbackend.model.Shop;
import java.util.List;

/**
 *
 * @author Antti Minkkinen
 */
public interface IShopService {
	public Shop getShopId(int shopId) throws Exception;
	public List<Shop> getShops();
	public void addShop(Shop s) throws Exception ;
	public List<Shop> searchShops(String keyword) throws Exception;
}
