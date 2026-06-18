# RestAssured-Framework
This repository describes RestAssured Automation Framework

To run this project, right click on testng.xml file and run as TestNg Suite

Project WorkFlow -
```
pom.xml
   │
   ▼
testng.xml
   │
   ▼
TestNG Runner
(Suite Configuration)
   │
   ▼
BaseTest
(Setup / Logging / Environment Initialization)
   │
   ▼
Config Layer
(ConfigReader + EnvironmentManager)
   │
   ▼
Data Provider Layer
(CSVUtils / JSONUtils / APIDataProvider)
   │
   ▼
Test Class
(StoreTest / UserTest / PetTest)
   │
   ▼
Client Layer
(StoreClient / UserClient / PetClient)
   │
   ▼
Core API Layer
(RequestBuilder + RestAssuredFactory)
   │
   ▼
RestAssured
(HTTP Request Execution)
   │
   ▼
API Server
(Swagger PetStore / Real API)
   │
   ▼
Response Handler
(Response Parsing + Validation)
   │
   ▼
Assertions Layer
(APIAssertions / TestNG Assert)
   │
   ▼
Listeners
(Extent Reports / Allure Reports)
   │
   ▼
Reports & Logs
├── allure-results/
├── extent-reports/
├── logs/
└── test-output/

```
