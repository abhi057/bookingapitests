import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;

public class paycoiniq_test {

	public static void main(String[] args) {

//		RestAssured.baseURI = "https://restful-booker.herokuapp.com/auth";
//		
//		//Generate Token
//		
//		System.out.println("---------------------Generate Token--------------------");
//		String postTokenResponse = given().log().all().header("Content-Type", "application/json")
//				.body(payload.generateToken()).when().post().then()
//				.assertThat().statusCode(200).header("server", "Cowboy").extract().response().asString();
//
//		System.out.println(postTokenResponse);
//		JsonPath js_token = new JsonPath(postTokenResponse); // for parsing Json
//		String token = js_token.getString("token");
////		String tokenid = "token=" + token;
////		System.out.println("Token to be passed: " + token);
//		
//
//		// Create a booking
//		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
//
//		System.out.println("---------------------Create booking--------------------");
//		String postBookingResponse = given().log().all().header("Content-Type", "application/json")
//				.header("Cookie", "token="+token).body(payload.createBooking("Vir", "Koh")).when().post().then()
//				.assertThat().statusCode(200).header("server", "Cowboy").extract().response().asString();
//
//		System.out.println(postBookingResponse);
//		JsonPath js_booking = ReUsableMethods.rawToJson(postBookingResponse);
////		JsonPath js_booking = new JsonPath(postBookingResponse); // for parsing Json
//		String bookingid = js_booking.getString("bookingid");
//		System.out.println("Booking Id is:" + bookingid);
//
//		// partial update
//		
//		System.out.println("---------------------Partial update booking--------------------");
//
//		given().log().all().header("Content-Type", "application/json").header("Cookie", "token="+token)
//				.body("{\r\n" + "    \"firstname\": \"Ami\",\r\n" + "    \"lastname\": \"Mis\"\r\n" + "}").when()
//				.patch(bookingid).then().assertThat().log().all().statusCode(200).body("firstname", equalTo("Ami"));
//
//		// Retrieve booking
//		
//		System.out.println("---------------------Retrieve booking--------------------");
//		String getBookingResponse = given().log().all().when().get(bookingid).then().assertThat().statusCode(200)
//				.header("server", "Cowboy").extract().response().asString();
//
//		System.out.println(getBookingResponse);
//		JsonPath js_get_booking = new JsonPath(getBookingResponse); // for parsing Json
//		System.out.println(js_get_booking.getString("firstname"));
//		System.out.println(js_get_booking.getString("lastname"));
//
//		Assert.assertEquals(js_get_booking.getString("firstname"), "Ami");
//		Assert.assertEquals(js_get_booking.getString("lastname"), "Mis");
//		System.out.println("Partial update has passed");
		
		//Get all Bookings
		System.out.println("---------------------Get all bookings--------------------");
		
		Response resp = given().when().get();
		int statusCode = resp.getStatusCode();
		assertEquals(statusCode, 200);

		List<Integer> bookingidlist = resp.jsonPath().getList("bookingid"); 
		System.out.println(bookingidlist.size());
		for (int i = 0; i < bookingidlist.size(); i++) {

		int getbookingid = bookingidlist.get(i);
		//   System.out.println(getbookingid);
		try {
		if (String.valueOf(getbookingid).equals("1256")) {
		System.out.println("matched");
		    break;
		}

		} catch (Exception e) {
		System.out.println("Booking id not found ==" + e.getMessage());
		}
		
		
		
//		Response getAllBookingResponse = given().log().all().when().get();
//		List<Object> bookingidlist = getAllBookingResponse.jsonPath().getList("bookingid");
//		
//        System.out.println("Total Bk id: " +bookingidlist);
////		JsonPath js_allBookingIds = ReUsableMethods.rawToJson(getAllBookingResponse);
////		
//		js_allBookingIds.get([].bookingid);
//		
//		//System.out.println("All booking ids length: " +js_allBookingIds.getList([].getAllBookingResponse).size());
//		System.out.println("All booking ids: " +js_allBookingIds.getList(bookingid));
//		

		//Delete Booking
		
//		System.out.println("---------------------Delete booking--------------------");
//		given().log().all().header("Content-Type", "application/json").header("Cookie", "token="+token).when()
//				.delete(bookingid).then().assertThat().log().all().statusCode(201);
//		

		

 }

	}
}