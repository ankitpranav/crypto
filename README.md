# crypto
web app for analysing bitcoin prices


have created an application for getting the statistical data for bitcoin prices.

there are 2 endpoints exposed :

1st : http://localhost:8080/crypto/meanOfPrices

type : get

will accept the number of minutes as a param

--> http://localhost:8080/crypto/meanOfPrices?minutes=10

resposne : will give the mean value of the bitcoin price ove a period of x minutes from now

2nd : http://localhost:8080/crypto/minMaxOfPrices

type : get

will accept the number of minutes as a param

--> http://localhost:8080/crypto/minMaxOfPrices?minutes=10

response : will return the minimum and the maximum price of the bitcoin over a period of x minuted from now.

3rd : http://localhost:8080/crypto/getCurrentPrice

type : get

will accept the currency as a param

--> http://localhost:8080/crypto/getCurrentPrice?currency=USD

response : will return the current proce of the bitcoin

Steps to follow :

--> go to the CryptoApplication class and run the application
--> once the spring application is loaded, hit the given end points for the result