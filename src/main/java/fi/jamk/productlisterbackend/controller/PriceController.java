/*
 */
package fi.jamk.productlisterbackend.controller;

import fi.jamk.productlisterbackend.model.Price;
import fi.jamk.productlisterbackend.service.impl.PriceService;
import java.util.HashMap;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Antti Minkkinen
 */
@RestController
@RequestMapping("/data")
public class PriceController {

	private PriceService priceService = new PriceService();

	/**
	 * Get a list of prices based on parameters. At least one parameter must be
	 * > 0.
	 *
	 * @param productIdString
	 * @param shopIdString
	 * @return list of prices
	 */
	@RequestMapping("/prices")
	public HashMap<String, Object> getPrices(@RequestParam(value = "productId", required = false, defaultValue = "0") String productIdString,
			@RequestParam(value = "shopId", required = false, defaultValue = "0") String shopIdString) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		System.out.println("Got a request to list prices, productId=" + productIdString + ", shopId=" + shopIdString);
		try {
			int productId = Integer.parseInt(productIdString);
			int shopId = Integer.parseInt(shopIdString);

			List<Price> priceList = priceService.getPrices(productId, shopId);

			result.put("success", "1");
			result.put("prices", priceList);
		} catch (Exception e) {
			result.put("success", "0");
			result.put("message", e.getMessage());
		}
		return result;
	}

	/**
	 * Accepts a price as JSON and attempts to save it to database.
	 *
	 * @param p Price
	 * @return JSON saved priceId
	 */
	@RequestMapping("/addprice")
	public HashMap<String, Object> addPrice(@RequestBody Price p) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("Got a request to add price: " + p);
		try {
			p.isValid();
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
		}
		try {
			priceService.addPrice(p);
			result.put("success", "1");
			result.put("priceId", p.getIdPrice());
		} catch (Exception e) {
			result.put("success", "0");
			result.put("message", e.getMessage());
		}
		return result;
	}
}
