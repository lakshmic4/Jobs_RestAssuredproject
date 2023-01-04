package jobsApi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_DELETE_Request {
@Test	
public void deleterequest() {	
RestAssured.baseURI="https://jobs123.herokuapp.com/";
	
	//request object
	RequestSpecification httpRequest=RestAssured.given();
	
	//attaching the params
	JSONObject requestparams=new JSONObject();
	
	requestparams.put("Job Id", "2010");
	requestparams.put("Job Title", "SDET31");
	
httpRequest.header("Content-Type","application/json");
	
	httpRequest.body(requestparams.toJSONString());
	//response object
	Response response=httpRequest.request(Method.DELETE,"/Jobs");
	
	//print response in console window
	String responseBody=response.getBody().asString();
	System.out.println("respons Body is"+responseBody);
	
	//status code verification
	int statusCode=response.getStatusCode();
	System.out.println("status code is:"+statusCode);
	Assert.assertEquals(statusCode, 200);

}
@Test
public void existentdeleterequest() {	
RestAssured.baseURI="https://jobs123.herokuapp.com/";
	
	//request object
	RequestSpecification httpRequest=RestAssured.given();
	
	//attaching the params
	JSONObject requestparams=new JSONObject();
	
	requestparams.put("Job Id", "2011");
	requestparams.put("Job Title", "SDET31");
	
httpRequest.header("Content-Type","application/json");
	
	httpRequest.body(requestparams.toJSONString());
	//response object
	Response response=httpRequest.request(Method.DELETE,"/Jobs");
	
	//print response in console window
	String responseBody=response.getBody().asString();
	System.out.println("respons Body is"+responseBody);
	
	//status code verification
	int statusCode=response.getStatusCode();
	System.out.println("status code is:"+statusCode);
	Assert.assertEquals(statusCode, 200);
}
}