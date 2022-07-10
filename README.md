# bookingapitests
----------------------------------------------------------------------------------------------------------------------------------------------
Description:
----------------------------------------------------------------------------------------------------------------------------------------------
I have implemented the three test cases with a Maven project using Rest Assured and Java with TestNG. Have used JSON parser and implemented POJO classes. 
The flow is as follows:
1. Generate Token
2. Create Booking and cature the booking id from the response - POST a booking 
3. Retrive all booking and verify that newly generated booking id exists - GET all bookings
4. Update firstname and lastname of the nelwly created booking- PATCH a booking
5. Retrive the updated booking and verify that update is successful - GET a booking 
6. Delete the newly created booking - DELETE a booking 
7. Verify that newly created booking is deleted
----------------------------------------------------------------------------------------------------------------------------------------------
Structure and guide run the scripts:
----------------------------------------------------------------------------------------------------------------------------------------------
src --
      |
       files ( It has POJO classes and some reuseable method classes) 
      |
       hotelbookingtests ( It has BookingTests.java file. Right click on this and run as testNG test and see the results in console)
       
 ----------------------------------------------------------------------------------------------------------------------------------------------
 Sample run output:
 ----------------------------------------------------------------------------------------------------------------------------------------------
 
[RemoteTestNG] detected TestNG version 7.4.0
---------------------Generate Token--------------------
Request method:	POST
Request URI:	https://restful-booker.herokuapp.com/auth
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*/*
				Content-Type=application/json
Cookies:		<none>
Multiparts:		<none>
Body:
{
    "username": "admin",
    "password": "password123"
}
{"token":"53a0179904bb6af"}
Token to be passed: 53a0179904bb6af
---------------------Create booking--------------------
Request method:	POST
Request URI:	https://restful-booker.herokuapp.com/booking
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Cookie=token=53a0179904bb6af
				Accept=*/*
				Content-Type=application/json
Cookies:		<none>
Multiparts:		<none>
Body:
{
    "firstname": "Abhi",
    "lastname": "Ang",
    "totalprice": 112.0,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-08-09",
        "checkout": "2022-08-09"
    }
}
{"bookingid":1682,"booking":{"firstname":"Abhi","lastname":"Ang","totalprice":112,"depositpaid":false,"bookingdates":{"checkin":"2022-08-09","checkout":"2022-08-09"}}}
Booking Id created is:1682
---------------------Get all bookings--------------------
Total booking ids: 1600
Booking id to be updated is1682
---------------------Partial update booking--------------------
Request method:	PATCH
Request URI:	https://restful-booker.herokuapp.com/booking/1682
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Cookie=token=53a0179904bb6af
				Accept=*/*
				Content-Type=application/json
Cookies:		<none>
Multiparts:		<none>
Body:
{
    "firstname": "Tom",
    "lastname": "Harry"
}
HTTP/1.1 200 OK
Server: Cowboy
Connection: keep-alive
X-Powered-By: Express
Content-Type: application/json; charset=utf-8
Content-Length: 139
Etag: W/"8b-CaA6i3Ro/r8Qae3TK8OrHqwTQJw"
Date: Sun, 10 Jul 2022 17:18:19 GMT
Via: 1.1 vegur

{
    "firstname": "Tom",
    "lastname": "Harry",
    "totalprice": 112,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-08-09",
        "checkout": "2022-08-09"
    }
}
---------------------Retrieve booking--------------------
First Name is: Tom
Last Name is: Harry
Booking Start Date is: 2022-08-09
Booking End Date is: 2022-08-09
Partial update has passed
---------------------Delete booking--------------------
Request method:	DELETE
Request URI:	https://restful-booker.herokuapp.com/booking/1682
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Cookie=token=53a0179904bb6af
				Accept=*/*
				Content-Type=application/json
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
HTTP/1.1 201 Created
Server: Cowboy
Connection: keep-alive
X-Powered-By: Express
Content-Type: text/plain; charset=utf-8
Content-Length: 7
Etag: W/"7-rM9AyJuqT6iOan/xHh+AW+7K/T8"
Date: Sun, 10 Jul 2022 17:18:22 GMT
Via: 1.1 vegur

Created
Request method:	GET
Request URI:	https://restful-booker.herokuapp.com/booking/1682
Proxy:			<none>
Request params:	<none>
Query params:	<none>
Form params:	<none>
Path params:	<none>
Headers:		Accept=*/*
Cookies:		<none>
Multiparts:		<none>
Body:			<none>
PASSED: deleteBooking
PASSED: partialUpdateBooking
PASSED: postbooking

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================


       
       


