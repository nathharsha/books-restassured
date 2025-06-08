# Books API Test Automation

This project demonstrates API test automation using **REST Assured**, **Cucumber (BDD)**, **JUnit**, and **Maven** for the Simple Books API - (https://simple-books-api.glitch.me).

---

## Scope

- API tested: `GET /books`
- Validation of:
    - HTTP Status Code
    - Response Time
    - Response Size
    - JSON Body Structure (fields like `id`, `name`, `type`, `available`)
- BDD Scenarios using Cucumber
- HTML Report generation with `maven-cucumber-reporting`

---

## How to Run

1. **Clone the repo**
   ```bash
   git clone https://github.com/yourusername/books-api-test.git
   cd books-api-test
   
2. **Run the tests**
   mvn clean verify

3. **Report**
    After tests are run, report can be accessed here: target/cucumber-html-reports/overview-features.html