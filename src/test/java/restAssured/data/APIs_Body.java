package restAssured.data;

public class APIs_Body {
	
	public static String requestBody;


	public static String returnCreateProductBody_200() {

		requestBody = "{\n" + 
				"	\"name\": \"New Product\",\n" + 
				"	\"type\": \"Hard Good\",\n" + 
				"	\"upc\": \"12345676\",\n" + 
				"	\"price\": 99.99,\n" + 
				"	\"description\": \"This is a placeholder request for creating a new product.\",\n" + 
				"	\"model\": \"NP12345\"\n" + 
				"}";

		return requestBody;
	}

	public static String returnCreateProductBody_missingName_400() {

		requestBody = "{\n" + 
				"	\"type\": \"Hard Good\",\n" + 
				"	\"upc\": \"12345676\",\n" + 
				"	\"price\": 99.99,\n" + 
				"	\"description\": \"This is a placeholder request for creating a new product.\",\n" + 
				"	\"model\": \"NP12345\"\n" + 
				"}";

		return requestBody;
	}

	public static String returnCreateProductBody_missingOptionalPrice_200() {

		requestBody = "{\n" + 
				"	\"name\": \"New Product\",\n" + 
				"	\"type\": \"Hard Good\",\n" + 
				"	\"upc\": \"12345676\",\n" + 
				"	\"description\": \"This is a placeholder request for creating a new product.\",\n" + 
				"	\"model\": \"NP12345\"\n" + 
				"}";

		return requestBody;
	}
	
	public static String returnCreateProductBody_emptyName_400() {

		requestBody = "{\n" + 
				"	\"name\": \"\",\n" + 
				"	\"type\": \"Hard Good\",\n" + 
				"	\"upc\": \"12345676\",\n" + 
				"	\"price\": 99.99,\n" + 
				"	\"description\": \"This is a placeholder request for creating a new product.\",\n" + 
				"	\"model\": \"NP12345\"\n" + 
				"}";

		return requestBody;
	}

}
