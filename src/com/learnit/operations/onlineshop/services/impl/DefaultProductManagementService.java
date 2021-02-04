package com.learnit.operations.onlineshop.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.learnit.operations.onlineshop.enteties.ProductCategory;
import com.learnit.operations.onlineshop.enteties.Manufacture;
import com.learnit.operations.onlineshop.enteties.Product;
import com.learnit.operations.onlineshop.enteties.impl.DefaultProductCategory;
import com.learnit.operations.onlineshop.enteties.impl.DefaultProduct;
import com.learnit.operations.onlineshop.services.ProductManagementService;

public class DefaultProductManagementService implements ProductManagementService {

	private static DefaultProductManagementService instance;

	private static List<Product> products;

	static {
		initProducts();
	}

	private static void initProducts() {

		products = new ArrayList<Product>();
		products.add(new DefaultProduct(1, "Hardwood Oak Suffolk Internal Door",
				new DefaultProductCategory("Doors", new ArrayList<Manufacture>()), 109.99));
		products.add(new DefaultProduct(2, "Oregon Cottage Interior Oak Door",
				new DefaultProductCategory("Doors", new ArrayList<Manufacture>()), 179.99));
		products.add(new DefaultProduct(3, "Oregon Cottage Horizontal Interior White Oak Door",
				new DefaultProductCategory("Doors", new ArrayList<Manufacture>()), 189.99));
		products.add(new DefaultProduct(4, "4 Panel Oak Deco Interior Door",
				new DefaultProductCategory("Doors", new ArrayList<Manufacture>()), 209.09));
		products.add(new DefaultProduct(5, "Worcester 2000 30kW Ng Combi Boiler Includes Free Comfort+ II controller",
				new DefaultProductCategory("Boilers", new ArrayList<Manufacture>()), 989.99));
		products.add(new DefaultProduct(6, "Glow-worm Betacom 4 30kW Combi Gas Boiler ERP",
				new DefaultProductCategory("Boilers", new ArrayList<Manufacture>()), 787.99));
		products.add(new DefaultProduct(7, "Worcester 2000 25kW Ng Combi Boiler with Free Comfort+ II controller",
				new DefaultProductCategory("Boilers", new ArrayList<Manufacture>()), 859.99));
		products.add(new DefaultProduct(8,
				"Wienerberger Terca Class B Engineering Brick Red 215mm x 102.5mm x 65mm (Pack of 504)",
				new DefaultProductCategory("Bricks", new ArrayList<Manufacture>()), 402.99));
		products.add(
				new DefaultProduct(9, "Wienerberger Terca Engineering Brick Blue Perforated Class B 65mm (Pack of 400)",
						new DefaultProductCategory("Bricks", new ArrayList<Manufacture>()), 659.99));
		products.add(new DefaultProduct(10, "Wienerberger Engineering Brick Red Smooth Class B 73mm - Pack of 368",
				new DefaultProductCategory("Bricks", new ArrayList<Manufacture>()), 523.99));
	}

	private DefaultProductManagementService() {
	}

	public static ProductManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultProductManagementService();
		}
		return instance;
	}

	@Override
	public List<Product> getProducts() {
		return this.products;
	}

	@Override
	public Product getProductById(int productIdToAddToCart) {
		for (Product product : products) {
			if (product != null && product.getId() == productIdToAddToCart) {
				return product;
			}
		}
		return null;
	}

	public void addProductToDB(Product product) {
	}
}