package jobsApi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_PUT_Request {
	
@Test	
public void putrequest() {
	 RestAssured.baseURI="https://jobs123.herokuapp.com/";
		
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//attaching the params
		JSONObject requestparams=new JSONObject();
		
		requestparams.put("Job Id", "1041");
		requestparams.put("Job Title", "SDET36");
		
httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestparams.toJSONString());
		//response object
		Response response=httpRequest.request(Method.PUT,"/Jobs");
		
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("respons Body is"+responseBody);
		
		//status code verification
		int statusCode=response.getStatusCode();
		System.out.println("status code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
	
}
@Test
public void existentputrequest() {
	RestAssured.baseURI="https://jobs123.herokuapp.com/";
	
	//request object
	RequestSpecification httpRequest=RestAssured.given();
	
	//attaching the params
	JSONObject requestparams=new JSONObject();
	
	requestparams.put("Job Id", "1043");
	requestparams.put("Job Title", "SDET36");
	
httpRequest.header("Content-Type","application/json");
	
	httpRequest.body(requestparams.toJSONString());
	//response object
	Response response=httpRequest.request(Method.PUT,"/Jobs");
	
	//print response in console window
	String responseBody=response.getBody().asString();
	System.out.println("respons Body is"+responseBody);
	
	//status code verification
	int statusCode=response.getStatusCode();
	System.out.println("status code is:"+statusCode);
	Assert.assertEquals(statusCode, 200);
	
}
}
