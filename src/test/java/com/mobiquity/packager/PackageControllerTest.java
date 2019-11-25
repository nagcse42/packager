package com.mobiquity.packager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobiquity.packager.controller.PackageController;
import com.mobiquity.packager.exception.APIException;
import com.mobiquity.packager.model.Response;

public class PackageControllerTest {
  @Autowired
  PackageController packController;

  @Test
  public void helloWorldTest() {
	  assertEquals("Hello World......", this.packController.getMessage());
  }
  
  @Test
  public void processPackageTest() throws APIException, Exception{
	  String sampleResult = "4-2,78,9";
	  Response actualResult = this.packController.preparePackage();
	  actualResult.setData(actualResult.getData().replace("\n", "").replace("\r", ""));
	  
	  assertEquals(sampleResult, actualResult.getData());
  }

}
