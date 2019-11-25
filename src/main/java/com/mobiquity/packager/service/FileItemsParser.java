package com.mobiquity.packager.service;

import java.util.ArrayList;
import java.util.List;

import com.mobiquity.packager.model.PackConfiguration;
import com.mobiquity.packager.model.PackageItem;

/**
 * FileItemsParser class to parse raw input data into a PackConfiguration object
 * 
 * @author Nagarjuna Paritala
 *
 */
public class FileItemsParser {

	/**
	 * @param line
	 *            in the input sample data format
	 * @return a Configuration object, holding input data
	 */
	public static PackConfiguration parse(String line) {

		PackConfiguration configuration = null;

		String[] configurationParts = line.split(" : ");

		try {

			if (configurationParts.length == 2) {

				Integer capacity = Integer.parseInt(configurationParts[0]);

				String[] itemsParts = configurationParts[1].split("\\s+");

				if (itemsParts.length > 0) {

					List<PackageItem> itemsList = new ArrayList<>();

					for (String itemString : itemsParts) {

						String[] itemParts = itemString.replace("(", "").replace(")", "").split(",");
						if (itemParts.length == 3) {

							itemsList.add(new PackageItem(Integer.parseInt(itemParts[0]),
									Double.parseDouble(itemParts[1]), Integer.parseInt(itemParts[2].replace("€", ""))));

						} else {
							itemsList.clear();
							break;
						}
					}

					if (!itemsList.isEmpty()) {
						configuration = new PackConfiguration(capacity, itemsList);
					}

				}

			}
		} catch (NumberFormatException e) {
			configuration = null;
		}

		return configuration;
	}
}