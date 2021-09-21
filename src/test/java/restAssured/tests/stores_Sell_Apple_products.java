package restAssured.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class stores_Sell_Apple_products {

	public static String baseURL = "http://localhost:3030" ;
	static String response;
	static int noOfStoresWithoutFilteration ;
	static int noOfAppleStores;

	@Test
	public static JsonPath stores_Sell_Apple_products_200() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				param("service.name", "Apple Shop").
				when().
				get("/stores").
				then().
				assertThat().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		JsonPath jsResponse = new JsonPath(response);
		noOfAppleStores = jsResponse.get("total");
		
		return jsResponse ;
	}
	
	@Test
	public static JsonPath stores_Sell_All_products_200() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				when().
				get("/stores").
				then().
				assertThat().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		JsonPath jsResponse = new JsonPath(response);
		noOfStoresWithoutFilteration = jsResponse.get("total");
		stores_Sell_Apple_products_200();
		System.out.println("noOfStoresWithoutFilteration" + noOfStoresWithoutFilteration);
		System.out.println("noOfAppleStores" + noOfAppleStores);
		assertNotEquals(noOfStoresWithoutFilteration, noOfAppleStores);
		return jsResponse ;
	}

	@Test
	public static JsonPath stores_Sell_Apple_products_404() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				param("service.name", "Apple Shop").
				when().
				get("/storesInvalidResource").
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
	public void test_stores_Sell_Apple_products() throws IOException, ParseException {

		System.out.println(stores_Sell_Apple_products_200());
		System.out.println(stores_Sell_Apple_products_404());
		System.out.println(stores_Sell_All_products_200());
	}
}
