package jobsApi;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_POST_DDT {
	@SuppressWarnings("unchecked")
	@Test(dataProvider="jobDetails")
	void postDDT(String jobId, String jobTitle, String jobLocation, String jobCompanyName, String jobType, String jobPostTime, String jobDescription) {
		RestAssured.baseURI="https://jobs123.herokuapp.com/";
		//request object
				RequestSpecification httpRequest=RestAssured.given();
				
				//attaching the params
				JSONObject requestparams=new JSONObject();
				requestparams.put("Job Id", jobId);
				requestparams.put("Job Title", jobTitle);
				requestparams.put("Job Location", jobLocation);
				requestparams.put("Job Company Name", jobCompanyName);
				requestparams.put("Job Type", jobType);
				requestparams.put("Job Posted time", jobPostTime);
				requestparams.put("Job Description", jobDescription);
				
				//Add a header stating the request  is a body json
				httpRequest.header("Content-Type","application/json");
				
				//Add the json to the body of the request
				httpRequest.body(requestparams.toJSONString());
				
				//response object
				Response response=httpRequest.request(Method.POST,"/Jobs");
				
				//print response in console window
				String responseBody=response.getBody().asString();
				System.out.println("respons Body is"+responseBody);
				
				Assert.assertEquals(responseBody.contains(jobId),true);
				Assert.assertEquals(responseBody.contains(jobTitle),true);
				Assert.assertEquals(responseBody.contains(jobLocation),true);
				Assert.assertEquals(responseBody.contains(jobCompanyName),true);
				Assert.assertEquals(responseBody.contains(jobType),true);
				Assert.assertEquals(responseBody.contains(jobPostTime),true);
				Assert.assertEquals(responseBody.contains(jobDescription), true);
				
				//status code verification
				int statusCode=response.getStatusCode();
				System.out.println("status code is:"+statusCode);
				Assert.assertEquals(statusCode, 200);
				
	}
	@DataProvider(name="jobDetails")
	String[][]getjobDetails() throws IOException{
		//read data from excel
		String  path=System.getProperty("user.dir")+"/src/test/java/jobsApi/jobsDetailData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String jobDetails[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
		
			for(int j=0;j<colcount;j++) {
			
				jobDetails[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	 
	//String jobDetails[][]={{jobId},{ "xyz123","40000","30"},{"mno123","20000","20"}};
	 return(jobDetails);
	}
}
