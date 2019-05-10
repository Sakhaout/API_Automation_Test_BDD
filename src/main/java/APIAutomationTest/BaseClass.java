package APIAutomationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static Properties properties_obj;

	
	public BaseClass() {
		try {
			String properties_path = "C:\\Users\\Hossain Sakhaout\\Desktop\\MavenProject\\API_Automation_Test_BDD\\src\\main\\java\\APIAutomationTest\\config.properties";
			properties_obj = new Properties();
			FileInputStream file_input = new FileInputStream(properties_path);
			properties_obj.load(file_input);
		}
		catch(IOException ex) {
			ex.getStackTrace();
		}
	}
	
	public Response initialization() {
		String url = properties_obj.getProperty("url");
		String urn = properties_obj.getProperty("urn");
		String URI = url+urn;
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,urn);
		return response;
	}

}
