# project petstore 
# This project is designed to automate the testing of [petstore] using Rest Assured, Selenium, TestNG, and Extent Reports,also have i used data driven testing.
# It helps to validate API endpoints efficiently.
# Project Root
 # src/test/java (api.endpoints,api.payload,api.test,api.utilities )
 # reports (Extent Reports)
 # test-data (Excel data for Data Driven Testing)
 # pom.xml (Maven dependencies)
# testng.xml (TestNG execution file)
 # README.md (Project Documentation)
  Tech Stack
Automation Framework: TestNG

API Testing: Rest Assured

Reporting: Extent Reports

Build Tool: Maven

Data Handling: Apache POI (Excel)
 Installation & Setup
# Prerequisites
Make sure you have the following installed:
1. Java JDK 8 or later
2. Maven
3. TestNG Plugin (for Eclipse IDEA)
# Features Covered
1. API Testing (GET, POST, PUT, DELETE) with Rest Assured
2.Data-Driven Testing using Apache POI (Excel)
3 Logging with Log4j
4. execute the test with TestNG,xml
5 Test Reports with Extent Reports
 Reporting
After test execution, the Extent Report is generated in the /reports/ folder.

To open the report:
# Navigate to: ./reports/TestReport.html
# Open the file in a web browser

🐞 Handling Errors & Debugging
If Maven build fails, try:

sh
Copy
Edit
mvn clean install -DskipTests
If TestNG tests fail, check the logs in test-output/

Ensure the API endpoints are correct

🤝 Contributing
Fork the repository

Create a new branch (git checkout -b feature-branch)

Commit changes (git commit -m "Added new feature")

Push to GitHub (git push origin feature-branch)

Create a Pull Request

📧 Contact
📌 Your Name: rajeevnayan89830(github)
📌 Email: rajeevnayan90088@gmail.com



✔ TestNG Plugin (for Eclipse/IntelliJ IDEA)
