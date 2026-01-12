# BoomBolt Automation Framework

A scalable, data-driven Selenium automation framework built using **Java, TestNG, Maven, and Page Object Model (POM)**.  
The framework automates **end-to-end e-commerce flows** including **Login, Registration, Cart, and Checkout**, and supports **parallel execution, headless mode, and detailed Extent reporting**, making it CI/CD ready.

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
│ ├── CheckoutPage.java
│ ├── HomePage.java
│
├── testCases
│ ├── Test_01_LoginDDT.java
│ ├── Test_01_RegistrationTest.java
│ ├── Test_01_RegistrationDDT.java
│ ├── Test_02_CheckoutTest.java
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

yaml
Copy code

---

## ✅ Key Features

- ✔ ThreadLocal WebDriver for parallel-safe execution  
- ✔ Data-driven testing for Login & Registration  
- ✔ Handles valid, invalid, and duplicate scenarios  
- ✔ End-to-end checkout automation  
- ✔ Razorpay payment iframe handling  
- ✔ Headless execution controlled via configuration  
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

### 🔹 Checkout
- Add item and proceed to checkout
- Fill billing and contact details
- Place order (non-payment flow)
- Handle Razorpay payment failure popup inside iframe

> ⚠️ Note: Real payment gateways are intentionally not automated as per industry best practices.

---

## ⚙️ Configuration

Update `config.properties`:

```properties
appURL=https://boombolt.in/my-account/
homeURL=https://boombolt.in/
browser=chrome
headless=true
country=India
state=Karnataka
headless=true → CI / pipeline execution

headless=false → Local debugging

▶️ How to Run Tests
Run all tests
bash
Copy code
mvn test
Run via TestNG XML
bash
Copy code
mvn test -DsuiteXmlFile=testng.xml
📊 Reports
Extent Reports are generated under:

bash
Copy code
/reports
Screenshots are captured automatically on test failures.

🧠 Design Highlights
Page Objects expose business-level actions, not UI steps

Tests are stateless and isolated, safe for DDT and parallel runs

Explicit waits are centralized in BasePage

Expected-result-driven DDT for reliability

Third-party iframe handling implemented for payment failures

👨‍💻 Author
Imran Ahamad
Automation Test Engineer | Selenium | Java | TestNG | API Testing

