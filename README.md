# Spring boot interceptor
A spring boot based http requests interceptor that should solve all the CORS and other Spring security issues.
The idea is to create a list of httpMethod-URI couples with all the endpoints that does not require authentication.
If the requested resource is in one of these endpoints, we let the user pass in any case, otherwise, a custom JWT
token validation is done.
The token logic follows the JWT legacy strategy, based in username-passowrd authentication.
