package restAssured.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Categories_With_TV_In_Name {

	public static String baseURL = "http://localhost:3030" ;
	static String response;

	@Test
	public static JsonPath categories_With_TV_In_Name_200() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				param("name[$like]", "*TV*").
				when().
				get("/categories").
				then().
				assertThat().statusCode(200).log().all().contentType(ContentType.JSON).extract().response();

		String response = res.asString();
		JsonPath jsResponse = new JsonPath(response);
		
		// assertion that the returned list is only that contain name = TV
		int noOfNames = jsResponse.getList("data").size();
		for (int i = 0; i < noOfNames; i++) {
			String name = jsResponse.get("data["+i+"].name");
			System.out.println(name);
			assertTrue(name.contains("TV"));
		}
		return jsResponse ;
	}

	@Test
	public static JsonPath categories_With_TV_In_Name_404() {

		RestAssured.baseURI = baseURL ;

		Response res = given().
				param("name[$like]", "*TV*").
				when().
				get("/categoriesInvalidResource").
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
	public void test_Categories_With_TV_In_Name() throws IOException, ParseException {

		System.out.println(categories_With_TV_In_Name_200());
		System.out.println(categories_With_TV_In_Name_404());

	}
}
