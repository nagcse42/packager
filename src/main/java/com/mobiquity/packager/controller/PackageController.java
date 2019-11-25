package com.mobiquity.packager.controller;


import java.nio.file.NoSuchFileException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobiquity.packager.exception.APIException;
import com.mobiquity.packager.model.Response;
import com.mobiquity.packager.service.PackageService;

/**
 * @author Nagarjuna Paritala
 * @Date 23-NOV-2019
 */
@Controller
public class PackageController {
	
	@Autowired
	private PackageService packageService;

	/**
	 * Method for test
	 * @return String = Hello World...
	 */
	@RequestMapping(value = "/")
	@ResponseBody
	public String getMessage() {
		return "Hello World......";
	}
	
	/**
	 * Method for preparing the package from list of packages in the file
	 * @param packageFilePath
	 * @return
	 * @throws APIException 
	 * @throws Exception 
	 */
	@RequestMapping(value = "/preparePackage", method=RequestMethod.POST)
	@ResponseBody
	public Response preparePackage() throws APIException, Exception {
		String packageFilePath = "C:\\Users\\S782548\\Desktop\\MyDocs\\Mobiquity\\packager\\src\\main\\resources\\InputFile1.txt";
		
		String data = this.packageService == null ? "package" : this.packageService.processPackage(packageFilePath);
		
		Response response = new Response();
		response.setStatus("200");
		response.setData(data);
		return response;
	}
	
	@RequestMapping(value = "/postTest", method=RequestMethod.POST)
	@ResponseBody
	public String postTest(@RequestBody String test)  {
		return test;
	}
	
}
