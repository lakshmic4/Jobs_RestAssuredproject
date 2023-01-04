package jobsApi;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_Get_Request {

	@Test
	public void getTest() {
	
		//specify base URI
		RestAssured.baseURI="https://jobs123.herokuapp.com";
		
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//response object
		Response response=httpRequest.request(Method.GET,"/Jobs");
		
		
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("respons Body is"+responseBody);
		
		//status code verification
		int statusCode=response.getStatusCode();
		System.out.println("status code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		
		
		
		
		
		
		
		

	}
}
