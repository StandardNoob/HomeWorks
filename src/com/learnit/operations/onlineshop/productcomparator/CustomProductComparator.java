package com.learnit.operations.onlineshop.productcomparator;

import java.util.Comparator;

import com.learnit.operations.onlineshop.enteties.Product;

public class CustomProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		int compareInt = 0;
		compareInt = o1.getCategory().getCategoryName().compareTo(o2.getCategory().getCategoryName());
		if (compareInt == 0) {
			double priceDif = o1.getPrice() - o2.getPrice();
			if (priceDif < 0) {
				compareInt = -1;
				if (priceDif == 0) {
					compareInt = 0;
				}
				if (priceDif > 0) {
					compareInt = 1;
				}
			}
		}
		if (compareInt == 0) {
			compareInt = o1.getProductName().compareTo(o2.getProductName());
		}
		return compareInt;
	}
}
