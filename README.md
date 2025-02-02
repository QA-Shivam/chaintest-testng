# Chaintest Integration with TestNG
This project demonstrates the integration of Chaintest Reports with TestNG for generating detailed test execution reports. Chaintest is a powerful reporting tool that allows you to capture and analyze your Selenium test results in a comprehensive way.

# Prerequisites
Before you begin, ensure you have the following installed:

Java (JDK 11 or above): Download JDK
Apache Maven: Download Maven
Docker (for running ChainLP Server): Download Docker
TestNG: Automatically included via Maven dependencies

# Integration Steps
Step 1: Set Up ChainLP Server Using Docker
ChainLP Server is a required component to generate the Chaintest reports. It needs to be run using Docker.

Clone the Chaintest repository from GitHub:
git clone: https://github.com/QA-Shivam/chaintest-testng.git
cd src/docker
Use Docker Compose to start the ChainLP Server:
docker compose -f docker-compose-h2.yml up
Note: Docker is only required for ChainLP as it hosts the report generation service. Docker is not a requirement for generating static reports (SimpleGenerator, EmailGenerator). However, Docker is required if you want to generate a comprehensive dashboard or consolidate multiple project reports.

Step 2: Add Dependencies to pom.xml
You need to include the necessary Maven dependencies for Chaintest and related libraries in your pom.xml:

<dependencies>
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>chaintest-testng</artifactId>
        <version>1.0.8</version>
    </dependency>
</dependencies>


Step 3: Add chaintest.properties File
You need to configure the Chaintest settings by adding the chaintest.properties file.
Create a chaintest.properties file inside the src/test/resources folder of your project.
Configure the file by enabling generators and setting project and email configurations to true:

Enable report generators
generator=true

Project name configuration
project.name=YourProjectName

Email configuration for report sharing (set to true to enable email notifications)
email.generator=true
email.recipient=youremail@example.com
email.sender=sender@example.com

Step 4: Add ChainTestListener to TestNG
To enable Chaintest reporting, you need to add the ChainTestListener in your TestNG configuration. This listener will capture the test results and generate reports.

Add the ChainTestListener in your testng.xml file:
<listeners>
    <listener class-name="com.aventstack.chaintest.plugins.ChainTestListener"/>
</listeners>
      
Alternatively, you can use Java Annotations to add the listener at the class level:
@Listeners(com.aventstack.chaintest.plugins.ChainTestListener.class)
public class YourTestClass {
    // Test methods go here
}

Step 5: Run the Tests
Once the setup is complete, you can now run your tests using Maven and TestNG:

mvn clean test
After running the tests, Chaintest will generate detailed reports. If Docker is used to run ChainLP Server, it will be accessible on the configured server address (http://localhost:80).

You can find the report in the ChainLP dashboard if running in Docker or in the generated files in your project directory for static reports.
