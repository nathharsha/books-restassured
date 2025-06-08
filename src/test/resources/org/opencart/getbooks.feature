Feature: Verify Simple Book API

  Scenario: API returns 200 OK for books endpoint
    Given the 'simple books' API is available
    When I send a GET request to 'books' endpoint
    Then the response status code should be 200

  Scenario: API returns a non-empty list of books
    Given the 'simple books' API is available
    When I send a GET request to 'books' endpoint
    Then the response should contain at least one book

  Scenario: API response is under acceptable time
    Given the 'simple books' API is available
    When I send a GET request to 'books' endpoint
    Then the response time should be less than 2 seconds

  Scenario: Each book has required fields
    Given the 'simple books' API is available
    When I send a GET request to 'books' endpoint
    Then each book in the response should have id, name, type, and availability

  Scenario: Response contains expected number of books
    Given the 'simple books' API is available
    When I send a GET request to 'books' endpoint
    Then the response should contain exactly 6 books
