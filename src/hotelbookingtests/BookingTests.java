package hotelbookingtests;

import static io.restassured.RestAssured.given;

import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import files.GetBooking;
import files.GetDates;
import files.PartialUpdate;
import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BookingTests {

	public static String uri = "https://restful-booker.herokuapp.com";
	public static String token = "";
	public static String newbookingid = "";

	@BeforeClass
	public void generatetoken() {
		RestAssured.baseURI = uri + "/auth";
		// Generate Token

		System.out.println("---------------------Generate Token--------------------");
		String postTokenResponse = given().log().all().header("Content-Type", "application/json")
				.body(payload.generateToken()).when().post().then().assertThat().statusCode(200)
				.header("server", "Cowboy").extract().response().asString();

		System.out.println(postTokenResponse);
		JsonPath js_token = new JsonPath(postTokenResponse); // for parsing Json
		token = js_token.getString("token");
//		String tokenid = "token=" + token;
//		String token = "d4eaaf392919b99";
		System.out.println("Token to be passed: " + token);

	}

	@Test(priority = 1)
	public void postbooking() {
		// Create a booking

		RestAssured.baseURI = uri + "/booking";
//
		System.out.println("---------------------Create booking--------------------");

		GetBooking bk = new GetBooking();
		GetDates dts = new GetDates();

		bk.setFirstname("Abhi");
		bk.setLastname("Ang");
		bk.setDepositpaid(false);
		bk.setTotalprice(112);
		dts.setCheckin("2022-08-09");
		dts.setCheckout("2022-08-09");
		bk.setBookingdates(dts);

		String postBookingResponse = given().log().all().header("Content-Type", "application/json")
				.header("Cookie", "token=" + token).body(bk).when().post().then().assertThat().statusCode(200)
				.header("server", "Cowboy").extract().response().asString();

		System.out.println(postBookingResponse);
		// parsing the json
		JsonPath js_booking = ReUsableMethods.rawToJson(postBookingResponse);
		String generatedbooking = js_booking.getString("bookingid");
		System.out.println("Booking Id created is:" + generatedbooking);
		newbookingid = generatedbooking;
		// Get all bookings
		System.out.println("---------------------Get all bookings--------------------");

		Response resp = given().when().get();
		int statusCode = resp.getStatusCode();
		assertEquals(statusCode, 200);

		List<Integer> bookingidlist = resp.jsonPath().getList("bookingid");
		System.out.println("Total booking ids: " + bookingidlist.size());
		for (int i = 0; i < bookingidlist.size(); i++) {
			int getbookingid = bookingidlist.get(i);

			if (String.valueOf(getbookingid).equals(newbookingid))
			{
				System.out.println("Newly created booking id found");
			break;
			}
			else {
				System.out.println("Newly created booking id not found");
			}

		}

	}

	
// partial update
//	
	@Test(priority = 2)

	public void partialUpdateBooking() {

		System.out.println("Booking id to be updated is" + newbookingid);

		System.out.println("---------------------Partial update booking--------------------");

		PartialUpdate pu = new PartialUpdate();
		pu.setFirstname("Tom");
		pu.setLastname("Harry");

		given().log().all().header("Content-Type", "application/json").header("Cookie", "token=" + token).body(pu)
				.when().patch(newbookingid).then().assertThat().log().all().statusCode(200);
//
//	given().log().all().header("Content-Type", "application/json").header("Cookie", "token="+token)
//			.body("{\r\n" + "    \"firstname\": \"Ami\",\r\n" + "    \"lastname\": \"Mis\"\r\n" + "}").when()
//			.patch(bookingid).then().assertThat().log().all().statusCode(200).body("firstname", equalTo("Ami"));
//
//	// Retrieve booking

		System.out.println("---------------------Retrieve booking--------------------");
		GetBooking br = given().expect().defaultParser(Parser.JSON).when().get(newbookingid).as(GetBooking.class);

		System.out.println("First Name is: " + br.getFirstname());
		System.out.println("Last Name is: " + br.getLastname());
		System.out.println("Booking Start Date is: " + br.getBookingdates().getCheckin());
		System.out.println("Booking End Date is: " + br.getBookingdates().getCheckout());

//	String getBookingResponse = given().log().all().when().get("5885").then().assertThat().statusCode(200)
//			.header("server", "Cowboy").extract().response().asString();
//
//	System.out.println(getBookingResponse);
//	JsonPath js_get_booking = new JsonPath(getBookingResponse); // for parsing Json
//	System.out.println(js_get_booking.getString("firstname"));
//	System.out.println(js_get_booking.getString("lastname"));
//
		Assert.assertEquals(br.getFirstname(), "Tom");
		Assert.assertEquals(br.getLastname(), "Harry");
		System.out.println("Partial update has passed");

	}

	@Test(priority = 3)
	public void deleteBooking() {

		// Delete Booking

		System.out.println("---------------------Delete booking--------------------");

		given().log().all().header("Content-Type", "application/json").header("Cookie", "token=" + token).when()
				.delete(newbookingid).then().assertThat().log().all().statusCode(201);

		// verify that booking is deleted

		given().log().all().when().get(newbookingid).then().assertThat().statusCode(404);

//	given().log().all().header("Content-Type", "application/json").header("Cookie", "token="+token).when()
//			.delete(bookingid).then().assertThat().log().all().statusCode(201);

	}

}
