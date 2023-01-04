package jobsApi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_POST_Request {
	
	
@SuppressWarnings("unchecked")
@Test
	public void postRequest() {
    RestAssured.baseURI="https://jobs123.herokuapp.com/";
		
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//attaching the params
		JSONObject requestparams=new JSONObject();
		
		requestparams.put("Job Id", "2012");
		requestparams.put("Job Title", "SDET43");
		requestparams.put("Job Location", "South Fayatee,PA");
		requestparams.put("Job Company Name", "Shakthi2");
		requestparams.put("Job Type", "Permanant");
		requestparams.put("Job Posted time", "15minutes");
		requestparams.put("Job Description", "API Automation");
		
		//Add a header stating the request is a body json
		httpRequest.header("Content-Type","application/json");
		
		//Add the json to the body of the request
		httpRequest.body(requestparams.toJSONString());
		
		//response object
		Response response=httpRequest.request(Method.POST,"/Jobs");
		
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("respons Body is"+responseBody);
		
		//status code verification
		int statusCode=response.getStatusCode();
		System.out.println("status code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
@Test	
public void existingpostrequest() {
	RestAssured.baseURI="https://jobs123.herokuapp.com/";
	
	//request object
	RequestSpecification httpRequest=RestAssured.given();
	
	//attaching the params
	JSONObject requestparams=new JSONObject();
	
	requestparams.put("Job Id", "2012");
	requestparams.put("Job Title", "SDET43");
	requestparams.put("Job Location", "South Fayatee,PA");
	requestparams.put("Job Company Name", "Shakthi2");
	requestparams.put("Job Type", "Permanant");
	requestparams.put("Job Posted time", "15minutes");
	requestparams.put("Job Description", "API Automation");
	
	httpRequest.header("Content-Type","application/json");
	
	httpRequest.body(requestparams.toJSONString());
	//response object
	Response response=httpRequest.request(Method.POST,"/Jobs");
	
	//print response in console window
	String responseBody=response.getBody().asString();
	System.out.println("respons Body is"+responseBody);
	
	//status code verification
	int statusCode=response.getStatusCode();
	System.out.println("status code is:"+statusCode);
	Assert.assertEquals(statusCode, 200);
}
	
	
}

