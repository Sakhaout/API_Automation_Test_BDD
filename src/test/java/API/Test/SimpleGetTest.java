package API.Test;

import java.io.InputStream;

import org.testng.Assert;

import org.testng.annotations.Test;

import APIAutomationTest.BaseClass;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class SimpleGetTest extends BaseClass {
	

	
//	@Test
//	public void getDetails() {
//		Response response = initializatiom();
//		String responseBody = response.getBody().asString();
//		System.out.println("Response Body is =>  " + responseBody);
//	}
	
	@Test
	public void getValidateStatus() {
		Response response = initialization();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void getStatusLine() {
		Response response = initialization();
		String statusLine = response.getStatusLine();
		System.out.println("Status line is: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void getHeader() {
		Response response = initialization();
		String containType = response.header("Contain-Type");
		System.out.println("Contain-Type value: "+containType);
		
		String serverType =  response.header("Server");
		System.out.println("Server value: " + serverType);
	}
	
	@Test
	public void IteratingOverHeaders() {
		Response response = initialization();
		Headers allHeaders = response.headers();
		System.out.println("*********Printing Header***********");
		for(Header header : allHeaders) {
			 System.out.println("Key: " + header.getName() + " ,  Value: " + header.getValue());
		 }
		System.out.println("********************");


	}
	
	
	@Test
	public void getJSON_File() {
		String response = initialization().asString();
		System.out.println("*********Printing JSON Response***********");
		System.out.println("JSON response \n\n" +response);
		System.out.println("********************");
	}
	
	@Test
	public void getStreamSize() {
		InputStream stream = initialization().asInputStream();
		int streamSize = stream.toString().length();
		System.out.println("JSON stream " +streamSize);

	}

	
}
