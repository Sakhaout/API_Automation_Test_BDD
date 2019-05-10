package API.Test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimplePOSTTest {
@Test
	public void RegistrationSuccessful(){ 
	RestAssured.baseURI ="http://reqres.in/api/users";
	RequestSpecification request = RestAssured.given();
 
	JSONObject requestParams = new JSONObject();
	requestParams.put("FirstName", "Sakhaout"); // Cast
	requestParams.put("LastName", "Hossain");
	requestParams.put("id", 5);
	requestParams.put("avatar","https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");


 
	requestParams.put("Email",  "sample2ee26d9@gmail.com");
	request.body(requestParams.toJSONString());
	Response response = request.post("http://reqres.in/api/users");
 
	int statusCode = response.getStatusCode();
	
	System.out.println("The status code recieved: " + statusCode);
	 
	 System.out.println("Response body: " + response.body().asString());
	
//	Assert.assertEquals(statusCode, "201");
//	String successCode = response.jsonPath().get("SuccessCode");
//	Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
}

}
