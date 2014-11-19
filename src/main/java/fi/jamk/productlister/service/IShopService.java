/*
 */
package fi.jamk.productlister.service;

import fi.jamk.productlister.Shop;
import java.util.List;

/**
 *
 * @author Antti Minkkinen
 */
public interface IShopService {
	public List<Shop> getShops();
	public void addShop(Shop s);
}
