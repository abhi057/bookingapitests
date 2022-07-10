package files;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
	public static Properties prop;

	public static void init() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Dell\\Desktop\\EclipseWorkspace\\DemoProject\\src\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JsonPath rawToJson(String response) {
		JsonPath js1 = new JsonPath(response);
		return js1;
	}

	// Generate Token
	public static String generateToken() {
		System.out.println("---------------------Generate Token--------------------");
		String postTokenResponse = given().log().all().header("Content-Type", "application/json")
				.body(payload.generateToken()).when().post().then().assertThat().statusCode(200)
				.header("server", "Cowboy").extract().response().asString();

		System.out.println("Token Resonse: " + postTokenResponse);
		JsonPath js_token = new JsonPath(postTokenResponse); // for parsing Json
		String token = js_token.getString("token");
		return token;
	}

}
