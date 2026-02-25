# Calculator Project

A Java-based calculator application with comprehensive unit testing and code coverage reporting.

## Features

- Basic arithmetic operations (add, subtract, multiply, divide)
- Advanced operations (square, square root)
- Temperature conversion (Kelvin to Celsius)
- Error handling for invalid operations

## Project Structure

```
src/
├── main/java/
│   ├── Calculator.java    # Main calculator implementation
│   └── Main.java          # Application entry point
└── test/java/
    ├── AbstractParent.java       # Base test class with lifecycle methods
    ├── CalculatorTest.java       # Basic operation tests
    ├── ExtraTest.java           # Additional comprehensive tests
    ├── KelvinToCelsiusTest.java # Temperature conversion tests
    └── SquareTest.java          # Square and square root tests
```

## Technologies Used

- **Java 21**
- **JUnit 5.10.2** - Unit testing framework
- **Maven** - Build automation and dependency management
- **JaCoCo 0.8.9** - Code coverage analysis

## Building and Testing

### Prerequisites
- Java 21 or higher
- Maven 3.x

### Run Tests
```bash
mvn clean test
```

### Generate Code Coverage Report
```bash
mvn clean test jacoco:report
```

The coverage report will be generated at `target/site/jacoco/index.html`

## Test Coverage

- **Calculator.java**: 100% coverage ✅
  - All methods tested
  - All branches covered
  - 19 test cases passing

## Test Results

- Total Tests: 19
- Passed: 19 ✅
- Failed: 0
- Errors: 0
- Skipped: 0

## Author

Created as part of Week 4 in-class assignment.

