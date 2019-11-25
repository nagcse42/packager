package com.mobiquity.packager.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.mobiquity.packager.exception.APIException;
import com.mobiquity.packager.model.PackConfiguration;
import com.mobiquity.packager.model.Result;

/**
 * This Packer is main start point of file reading and packing the package
 * 
 * @author: Nagarjuna Paritala
 * 
 */
public class Packer {

	private static final PackerSolver packerFactory = new PackerSolver();

	/**
	 * @param filePath
	 *            a valid absolute file path on the local filesystem
	 * @return a String containing the solutions (one line for each test case)
	 * @throws APIException
	 */
	public static String pack(String filePath) throws APIException, Exception {

		Path path = Paths.get(filePath);

		try {

			List<String> lines = Files.lines(path).collect(Collectors.toList());

			StringBuffer sb = new StringBuffer();

			for (String l : lines) {
				sb.append(Packer.process(l)).append("\n");
			}

			return sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * @param line
	 *            a single test case in the [capacity] : ([index],[weight],[€value])
	 * @return a comma-separated list of items indexes, or '-' if there's no
	 *         solution
	 * @throws APIException
	 */
	public static String process(String line) throws APIException {

		PackConfiguration configuration = FileItemsParser.parse(line);

		if (configuration == null) {
			throw new APIException("Invalid input file");
		}

		Result result = packerFactory.solve(configuration.getCapacity(), configuration.getItems());

		String solutionItemsList;

		if (result.getItems() != null && !result.getItems().isEmpty()) {
			solutionItemsList = result.getItems().stream().map(i -> i.getIndex().toString())
					.collect(Collectors.joining(","));
		} else {
			solutionItemsList = "-";
		}

		return solutionItemsList;
	}
}
