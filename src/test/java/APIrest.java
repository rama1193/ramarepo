import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
//import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class APIrest
{
	
	long id;
	@BeforeClass
	public void setupBase() {
		RestAssured.baseURI = "https://reqres.in/";
	}
	
	@Test
	public void getListUsers() 
	{
	Response allUsers = given().when().get("https://reqres.in/api/users?page=2");	
	System.out.println(allUsers.asPrettyString());
	}

	@Test
	
	public void GetUser()
	{
		Response OneUser = given().when().get("https://reqres.in/api/users/2");	
		System.out.println(OneUser.asPrettyString());	
	}
	@Test
	public void CreateUser()
	{
		String jsonData = " { "
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}" ; 
	        
	Response response = given().body(jsonData).header("accept", "application/json")
	.header("Content-Type", "application/json").when().post("api/users");
		
	Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println(response.asPrettyString());	
	}
	
	@Test
	
	public void UpdateUSer()
	{
	String jsonData1 =  "{"
			+ "    \"name\": \"morpheus\","
			+ "    \"job\": \"zion resident\""
			+ "}";	
	Response response = given().body(jsonData1).header("accept", "application/json")
	.header("Content-Type", "application/json").when().put("api/users/2");
	Assert.assertEquals(response.getStatusCode(), 200);
	System.out.println(response.asPrettyString());
	
	}
	
	@Test
	
	public void DeleteUSer()
	{
		Response response = given().header("accept", "application/json").delete("api/users/2"+this.id );
		
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 204);
	}

	@Test
	
	public void RegisterSuccess()
	{
		String jsonData2 = " {"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"pistol\"\r\n"
				+ "}" ;
				Response response1 = given().body(jsonData2).header("accept", "application/json")
		.header("Content-Type", "application/json").when().post("api/register");
				System.out.println(response1.asPrettyString());
				Assert.assertEquals(response1.getStatusCode(), 200);
		
	}
	
	
	@Test
	
	public void RegisterUnsuccess()
	{
		String jsonData3 = "{\r\n"
				+ "    \"email\": \"sydney@fife\"\r\n"
				+ "}";
		Response response1 = given().body(jsonData3).header("accept", "application/json")
				.header("Content-Type", "application/json").when().post("api/register");
						
		System.out.println(response1.asPrettyString());
		Assert.assertEquals(response1.getStatusCode(), 400);
	}
	
	@Test
	public void LoginUnsuccess()
	{
		String jsonData4 = "{\r\n"
				+ "    \"email\": \"peter@klaven\"\r\n"
				+ "}";
		Response response1 = given().body(jsonData4).header("accept", "application/json")
				.header("Content-Type", "application/json").when().post("api/login");
						System.out.println(response1.asPrettyString());
						Assert.assertEquals(response1.getStatusCode(), 400);
	}
	
	@Test
	 public void DelayedResponse()
	 {
		Response response2 = given().when().get("api/users?delay=3");
		System.out.println(response2.asPrettyString());
		Assert.assertEquals(response2.getStatusCode(), 200);
	 }
}


































