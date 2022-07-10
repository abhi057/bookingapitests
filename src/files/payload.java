package files;

public class payload {

	
	public static String createBooking(String firstname, String lastname)
	{
		
		return "{\r\n"
				+ "    \"firstname\" : \""+firstname+"\",\r\n"
				+ "    \"lastname\" : \""+lastname+"\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2022-08-09\",\r\n"
				+ "        \"checkout\" : \"2022-08-11\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"wifi\"\r\n"
				+ "}";
	}
	
	public static String createNewBooking()
	{
		
		return "{\r\n"
				+ "    \"firstname\" : \"Jonty\",\r\n"
				+ "    \"lastname\" : \"Rhodes\",\r\n"
				+ "    \"totalprice\" : 113,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2022-08-09\",\r\n"
				+ "        \"checkout\" : \"2022-08-11\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"poolview\"\r\n"
				+ "}";
	}
	
	
	public static String generateToken()
	{
		return "{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
	}

	
	
}
