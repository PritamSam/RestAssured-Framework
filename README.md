# RestAssured-Framework
This repository describes RestAssured Automation Framework

To run this project, right click on testng.xml file and run as TestNg Suite

After running the full test suite, refresh the Reports root folder by right-clicking on it and selecting Refresh. 
Then, within the Reports folder, right-click on the first report file and select Open With > Web Browser.

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
