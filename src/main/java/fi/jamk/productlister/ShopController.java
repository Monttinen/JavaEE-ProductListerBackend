/*
 */
package fi.jamk.productlister;

import fi.jamk.productlister.service.ShopService;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for Shops.
 *
 * @author Antti Minkkinen
 */
@RestController
@RequestMapping("/data")
public class ShopController {

	private final ShopService shopService = new ShopService();

	/**
	 * Gets a list of shops.
	 *
	 * @return JSON list of shops.
	 */
	@RequestMapping("/shops")
	public HashMap<String, Object> getShops() {
		HashMap<String, Object> result = new HashMap<String, Object>();

		System.out.println("Got a request to list shops");
		List<Shop> list;
		list = shopService.getShops();

		result.put("success", "1");
		result.put("shops", list);
		return result;
	}

	/**
	 * Search for a list of shops.
	 *
	 * @param keyword
	 * @return JSON list of shops.
	 */
	@RequestMapping("/searchshops")
	public HashMap<String, Object> searchShops(@RequestParam(value = "keyword", required = true) String keyword) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		System.out.println("Got a request to search shops, keyword=" + keyword);
		List<Shop> list;
		try {
			list = shopService.searchShops(keyword);

			result.put("success", "1");
			result.put("shops", list);
		} catch (Exception ex) {

			result.put("success", "s");
			result.put("message", ex.getMessage());
		}

		return result;
	}

	/**
	 * Get a shop with specified shopId as JSON.
	 *
	 * @param shopIdString
	 * @return JSON shop
	 */
	@RequestMapping("/shop")
	public HashMap<String, Object> getShop(@RequestParam(value = "shopId", required = true) String shopIdString) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		int shopId;
		try {
			shopId = Integer.parseInt(shopIdString);

			Shop s = shopService.getShopId(shopId);

			result.put("success", "1");
			result.put("shop", s);
		} catch (Exception e) {
			result.put("success", "0");
			result.put("message", e.getMessage());
		}

		return result;
	}

	/**
	 * Accepts a shop as JSON and attempts to save it to database.
	 *
	 * @param s
	 * @return JSON saved shopId
	 */
	@RequestMapping("/addshop")
	public HashMap<String, Object> addShop(@RequestBody Shop s) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("Got a request to add shop: " + s);
		try {
			shopService.addShop(s);
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
			return result;
		}
		result.put("success", "1");
		result.put("shopid", s.getShopId());
		return result;
	}
}
