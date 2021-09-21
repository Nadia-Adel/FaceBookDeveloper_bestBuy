package restAssured.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class highest_Priced_Products {

	public static String baseURL = "http://localhost:3030" ;
	static String response;
	
	@Test
	public static JsonPath highest_Priced_Products_200() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				param("$sort[price]", "-1").
				when().
				get("/products").
				then().
				assertThat().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		return new JsonPath(response);

	}

	@Test
	public static JsonPath highest_Priced_Products_404() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				param("$sort[price]", "-1").
				when().
				get("/productsInvalidResource").
				then().
				assertThat().statusCode(404).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		JsonPath jsResponse = new JsonPath(response);
		assertEquals(jsResponse.get("message"), "Page not found");
		int codeValue = 404 ;
		assertEquals(jsResponse.get("code"), codeValue);
		return jsResponse ;
	}

	@Test	
	public void test_highest_Priced_Products() throws IOException, ParseException {

		System.out.println(highest_Priced_Products_200());
		System.out.println(highest_Priced_Products_404());

	}
}
