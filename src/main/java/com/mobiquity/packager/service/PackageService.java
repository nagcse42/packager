package com.mobiquity.packager.service;

import java.nio.file.NoSuchFileException;

import org.springframework.stereotype.Service;

import com.mobiquity.packager.exception.APIException;

/**
 * @author Nagarjuna Paritala
 * 
 * This service is to handle the package preparation
 */

@Service
public class PackageService {

	/**
	 * This method will take file path as parameter and read the packages from that
	 * file
	 * 
	 * @param packageFilePath
	 * @return the prepared package details
	 * @throws APIException
	 * @throws NoSuchFileException 
	 */
	public String processPackage(String packageFilePath) throws APIException,Exception {
		return Packer.pack(packageFilePath);
	}

}