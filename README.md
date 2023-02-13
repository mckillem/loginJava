Register a user.

http://localhost:8080/api/v1/auth/register
{
    "firstName": "Tom",
    "lastName": "Věrný",
    "email": "email@email.com",
    "password": "heslo"
}
Returns a token


Authenticate (login) a user.

http://localhost:8080/api/v1/auth/authenticate
{
    "email": "email@email.com",
    "password": "heslo"
}
Fill in the token


Returns a message from an endpoint.

http://localhost:8080/api/v1/demo-controller
Fill in the token
