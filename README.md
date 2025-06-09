# Books API Test Automation

This project demonstrates API test automation using **REST Assured**, **Cucumber (BDD)**, **Hamcrest**, and **Maven** for the Simple Books API - (https://simple-books-api.glitch.me).

---

## Scope

- API tested: `GET /books`
- Validation of:
    - HTTP Status Code
    - Response Time
    - Response Size
    - JSON Body Structure (fields like `id`, `name`, `type`, `available`)
    - Response when requested for details of a specific book ID
    - Error scenarios when invalid method or invalid book ID is passed
- BDD Scenarios using Cucumber
- HTML Report generation with `maven-cucumber-reporting`

---

## How to Run

1. **Clone the repo**
   ```bash
   git clone https://github.com/yourusername/books-api-test.git
   cd books-api-test
   
2. **Run the tests**
   ```bash
   mvn clean verify

4. **Report**
   ```bash
    After tests are run, report can be accessed here:
   target/cucumber-html-reports/overview-features.html
