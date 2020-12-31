package APITestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.FileManager;

public class CreatePostTest {

	RequestSpecification httpRequest;
	Response response;
	String requestBody = (System.getProperty("user.dir") + "\\resources\\JsonBody.txt");

	String CreatePostURL = utilities.LoadProperties.userData.getProperty("createPostUrl");

	@Test
	public void createPost() throws IOException {

		System.out.println("URL of API is : " + CreatePostURL);
		String reqBody = FileManager.readFile(requestBody);
		RestAssured.baseURI = CreatePostURL;

		httpRequest = RestAssured.given(); // start to intialize the rest assure request
		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(reqBody);

		// Post the request and check the response
		Response response = httpRequest.post("/posts");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		String responseBody = response.body().asString();
		System.out.println("Response body: " + responseBody);
		System.out.println("request body : " + reqBody);

		Assert.assertTrue(response.body().asString().contains("id"));// Verify that post was created and response
																		// returns id
		
		System.out.println("post has been created successfully and the response body is : "+ response.body().asString());

	}
}
