package com.mobiquity.packager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.NoSuchFileException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.mobiquity.packager.exception.APIException;
import com.mobiquity.packager.service.Packer;

public class PackerTest {
	@Autowired
	Packer packer;

	@Test
	public void testPackerPack() throws APIException, Exception {
		String filePath = "C:\\\\Users\\\\S782548\\\\Desktop\\\\MyDocs\\\\Mobiquity\\\\packager\\\\src\\\\main\\\\resources\\\\InputFile1.txt";
		String sampleResult = "4-2,78,9";
		String actualResult = this.packer.pack(filePath);
		actualResult = actualResult.replace("\n", "").replace("\r", "");

		assertEquals(sampleResult, actualResult);

	}
	

	@Test
	public void testEmptyFile() throws APIException, Exception {
		String filePath = "C:\\\\Users\\\\S782548\\\\Desktop\\\\MyDocs\\\\Mobiquity\\\\packager\\\\src\\\\main\\\\resources\\\\EmptyFile.txt";
		String sampleResult = "";
		String actualResult = this.packer.pack(filePath);
		System.out.println("Empty Result : "+actualResult);
		actualResult = actualResult.replace("\n", "").replace("\r", "");

		assertEquals(sampleResult, actualResult);

	}
	
	@Test
	public void testPackFileNotFound() throws APIException, NoSuchFileException{
		String filePath = "C:\\\\Users\\\\S782548\\\\Desktop\\\\MyDocs\\\\Mobiquity\\\\packager\\\\src\\\\main\\\\resources\\\\InputFile123.txt";
		try {
			this.packer.pack(filePath);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "C:\\Users\\S782548\\Desktop\\MyDocs\\Mobiquity\\packager\\src\\main\\resources\\InputFile123.txt");
		}
	}
	
}
