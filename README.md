# BoomBolt Automation Framework

A scalable, data-driven Selenium automation framework built using **Java, TestNG, Maven, and Page Object Model (POM)**.  
The framework supports **parallel execution, headless mode, and detailed Extent reporting**, making it CI/CD ready.

---

## 🚀 Tech Stack

- **Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Reporting:** Extent Reports (ThreadLocal-safe)  
- **Data Driven Testing:** TestNG DataProvider + Excel  
- **Browser Management:** WebDriverManager  
- **Test Data Generation:** Java Faker  

---

## 📁 Project Structure

src/test/java
│
├── pageObjects
│ ├── BasePage.java
│ ├── LoginPage.java
│ ├── MyAccountPage.java
│
├── testCases
│ ├── Test_01_LoginDDT.java
│ ├── Test_01_RegistrationTest.java
│ ├── Test_01_RegistrationDDT.java
│
├── testBase
│ └── BaseClass.java
│
├── utilities
│ ├── DataProviders.java
│ ├── ExcelUtility.java
│ └── ExtentReportManager.java
│
└── testData
└── MOCK_DATA.xlsx


---

## ✅ Key Features

- ✔ ThreadLocal WebDriver for parallel-safe execution  
- ✔ Data-driven testing (Login & Registration)  
- ✔ Handles valid, invalid, and duplicate scenarios  
- ✔ Headless execution controlled via config  
- ✔ Clean separation of tests and page logic  
- ✔ Extent Reports with screenshots on failure  
- ✔ CI/CD ready design  

---

## 🧪 Test Coverage

### 🔹 Login
- Valid credentials
- Invalid credentials
- Data-driven execution

### 🔹 Registration
- Valid registration
- Invalid data
- Duplicate email scenario
- Data-driven execution

---

## ⚙️ Configuration

Update `config.properties`:

```properties
appURL=https://boombolt.in/my-account/
browser=chrome
headless=true

headless=true → CI execution

headless=false → Local debugging

▶️ How to Run Tests
Run via TestNG XML
mvn test

Run Specific Suite
mvn test -DsuiteXmlFile=testng.xml

📊 Reports

Extent Reports are generated under:

/reports


Screenshots are captured automatically on failures.

🧠 Design Highlights

Page Objects expose business actions, not UI steps

Tests are stateless and isolated, safe for DDT

Explicit waits are centralized in BasePage

Expected-result-driven DDT for reliability

👨‍💻 Author

Imran Ahamad
Automation Test Engineer | Selenium | Java | TestNG | API Testing
