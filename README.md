BitGo 
BitGo is a Java-Selenium based automation framework designed for efficient testing and reporting of software applications. 
It leverages TestNG for test execution and integrates with various tools to provide comprehensive test reports.

Project Structure-
BitGo/
├── .idea/                 # IntelliJ IDEA project settings
├── Configuration/         # Configuration files (e.g., properties, YAML)
├── Reports/               # Generated test reports
├── logs/                  # Log files
├── src/                   # Source code
│   └── main/
│       └── java/          # Main application code
│   └── test/
│       └── java/          # Test classes
├── target/                # Compiled classes and build artifacts
├── pom.xml                # Maven project file
└── testng.xml             # TestNG suite configuration

🚀 Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher

Apache Maven 3.6 or higher

An IDE like IntelliJ IDEA or Eclipse

Installation-

Clone the repository:
git clone https://github.com/rishikeshyadav735/BitGo.git
cd BitGo

Build the project using Maven:
mvn clean install

Run tests using TestNG:
mvn test

🧪 Testing
The project utilizes TestNG for organizing and running test cases. Test classes are located in the src/test/java/ directory. The testng.xml file at the root of the project defines the test suites and configurations.

📊 Reporting
Test execution results are generated in the Reports/ directory. These reports provide insights into test case execution, including pass/fail status, execution time, and error messages.

🛠️ Configuration
Configuration files are stored in the Configuration/ directory. These files allow you to set various parameters for test execution, such as environment variables, browser settings, and more.

🤝 Contributing
Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

📞 Contact
For any questions or support, please contact rishikeshyadav902@gmail.com
