package testBase;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class GetUserFromJson {

	public static String getUsername(String userType) throws IOException, ParseException {

		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("username").toString());
		return username.get("username").toString();

	}
	
	public static String getLastname(String userType) throws IOException, ParseException {

		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("lastname").toString());
		return username.get("lastname").toString();

	}

	public static String getpassword(String userType) throws IOException, ParseException {

		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("password").toString());
		return username.get("password").toString();

	}
	
	public static String getEmail(String userType) throws IOException, ParseException {

		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("phoneORemail").toString());
		return username.get("phoneORemail").toString();

	}

	public static String getDay(String userType) {

		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("day").toString());
		return username.get("day").toString();

	}
	
	public static String getMonth(String userType) {

		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("month").toString());
		return username.get("month").toString();

	}
	
	public static String getYear(String userType) {

		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("year").toString());
		return username.get("year").toString();

	}
	
	public static String getGender(String userType) {

		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("gender").toString());
		return username.get("gender").toString();

	}

}
