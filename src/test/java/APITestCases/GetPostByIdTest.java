package APITestCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetPostByIdTest {
	RequestSpecification httpRequest;
	Response response ;
	String postId = "5";
	String getPostByIdURL = utilities.LoadProperties.userData.getProperty("GetPostByIdURL")+postId;
	
	@Test
	public void getPostById() {
		
		System.out.println("URL of API is : "+getPostByIdURL);
		RestAssured.baseURI = getPostByIdURL; 
		
		
				
		httpRequest = RestAssured.given(); 
		httpRequest.header("Content-Type", "application/json");
		response = httpRequest.get(); 
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		String responseBody = httpRequest.get().getBody().asString();

		System.out.println("Body = "+responseBody);	
		
		Assert.assertTrue(responseBody.contains(postId));
		System.out.println("post has been retrieved successfully for the entered ID "+postId + " and the responde body is: "+ responseBody);

		
	}

}
