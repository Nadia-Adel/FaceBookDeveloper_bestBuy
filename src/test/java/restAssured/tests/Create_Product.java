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
import restAssured.data.APIs_Body;

public class Create_Product {

	public static String baseURL = "http://localhost:3030" ;
	static String response;
	APIs_Body body = new APIs_Body();

	@Test
	public static JsonPath Create_Product_201() {

		RestAssured.baseURI = baseURL ;


		Response res = given().
				headers("Content-Type", "application/json").
				body(APIs_Body.returnCreateProductBody_200()).
				when().
				post("/products").
				then().
				assertThat().statusCode(201).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		JsonPath jsResponse = new JsonPath(response);

		return jsResponse ;
	}

	@Test
	public static JsonPath Create_Product_404() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				headers("Content-Type", "application/json").
				body(APIs_Body.returnCreateProductBody_200()).
				when().
				post("/productsInvalidResource").
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
	public static JsonPath Create_Product_missingHeader_400() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				body(APIs_Body.returnCreateProductBody_200()).
				when().
				post("/products").
				then().
				assertThat().statusCode(400).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		JsonPath jsResponse = new JsonPath(response);
		assertEquals(jsResponse.get("message"), "Invalid Parameters");
		int codeValue = 400 ;
		assertEquals(jsResponse.get("code"), codeValue);
		return jsResponse ;
	}
	
	@Test
	public static JsonPath Create_Product_missingNameBody_400() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				headers("Content-Type", "application/json").
				body(APIs_Body.returnCreateProductBody_missingName_400()).
				when().
				post("/products").
				then().
				assertThat().statusCode(400).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		JsonPath jsResponse = new JsonPath(response);
		assertEquals(jsResponse.get("message"), "Invalid Parameters");
		int codeValue = 400 ;
		assertEquals(jsResponse.get("code"), codeValue);
		return jsResponse ;
	}
	
	@Test
	public static JsonPath Create_Product_emptyNameBody_400() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				headers("Content-Type", "application/json").
				body(APIs_Body.returnCreateProductBody_emptyName_400()).
				when().
				post("/products").
				then().
				assertThat().statusCode(400).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		JsonPath jsResponse = new JsonPath(response);
		assertEquals(jsResponse.get("message"), "Invalid Parameters");
		assertEquals(jsResponse.get("errors[0]"), "'name' should NOT be shorter than 1 characters");
		int codeValue = 400 ;
		assertEquals(jsResponse.get("code"), codeValue);
		return jsResponse ;
	}
	
	@Test
	public static JsonPath Create_Product__missingOptionalPrice_200() {

		RestAssured.baseURI = baseURL ;


		Response res = given().
				headers("Content-Type", "application/json").
				body(APIs_Body.returnCreateProductBody_missingOptionalPrice_200()).
				when().
				post("/products").
				then().
				assertThat().statusCode(201).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		JsonPath jsResponse = new JsonPath(response);

		return jsResponse ;
	}

	@Test	
	public void test_Create_Product() throws IOException, ParseException {

		System.out.println(Create_Product_201());
		System.out.println(Create_Product_404());
		System.out.println(Create_Product_missingHeader_400());
		System.out.println(Create_Product_missingNameBody_400());
		System.out.println(Create_Product_emptyNameBody_400());
		System.out.println(Create_Product__missingOptionalPrice_200());
	}
}
