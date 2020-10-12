# IngCodingChallenge

This project is the implementation of my solution for ING Coding Challenge.

Based on the document I received, I created 2 rest APIs to get and update user details.

There are 6 users already in the in-memory database, 5 of which are normal users and one is ADMIN.

These users can be used to test the API:

password    username    firstN    lastname    role
'123'      'rihanna'   'rihanna'  'zekri'     'ROLE_ADMIN'
'1234'     'user2'     'user2'    'user2'     'ROLE_USER'
'12345'    'user3'     'user3'    'user3'     'ROLE_USER'
'123456'   'user4'     'user4'    'user4'     'ROLE_USER'
'1234567'  'user5'     'user5'    'user5'     'ROLE_USER'
'12345678' 'user6'     'user6'    'user6'     'ROLE_USER'

To make things easy, I have run the application in an AWS instance which can be accessed by this URL:
http://ec2-18-189-13-49.us-east-2.compute.amazonaws.com:8080/ing/api

In this project, I used JWT authentication which means it's necessary to login first, get the JWT token and then use the other apis.

In order to login, open Postman and call the login api at:
http://ec2-18-189-13-49.us-east-2.compute.amazonaws.com:8080/ing/api/login

using a POST method and send a json payload to the api:
{
	"username":"user2",
	"password":"1234"
}

The result is a JSON with one string field. Copy that String.

In another tab, call the getDetails method:
http://ec2-18-189-13-49.us-east-2.compute.amazonaws.com:8080/ing/api/user/userdetails/5
using a GET method but in the Authorization subpanel, choose Bearer Token and paste the token from last step to the right field.


For the updatedetail api, you have to login as "rihanna" first. Then follow the previous step to add the token to the request and call:
http://ec2-18-189-13-49.us-east-2.compute.amazonaws.com:8080/ing/api/user/updatedetails
using PUT method. In the body, send a json for the fields you wish to update:
{
	"userId": 5,
	"lastName":"Z"
}

I've also added Swagger to this project which can be accessed via:
http://ec2-18-189-13-49.us-east-2.compute.amazonaws.com:8080/ing/swagger-ui/index.html
No authentication is needed for this URL.


Of course if you prefer to run the application on your local machine, you can always download this source and run it in your environment.

Regards,
Rihanna

