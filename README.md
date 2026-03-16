# Calculator Project

A Java-based calculator application with comprehensive unit testing, Kelvin-to-Celsius conversion, and code coverage reporting.

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
- **Jenkins** - Continuous integration / automated test reporting

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
mvn clean verify
```

The coverage report will be generated at:

- HTML: `target/site/jacoco/index.html`
- XML: `target/site/jacoco/jacoco.xml`
- JUnit XML reports: `target/surefire-reports/*.xml`

## Kelvin to Celsius Example

Formula:

```text
°C = K - 273.15
```

Example:

```text
300 K -> 26.85 °C
```

## Jenkins Setup

This project has been verified locally with:

```bash
mvn clean verify
```

### Important Jenkins Requirement

Jenkins must run this project with **JDK 21 or newer** because `pom.xml` is configured with:

```xml
<maven.compiler.release>21</maven.compiler.release>
```

If Jenkins uses an older JDK, the build will fail during compilation.

### Freestyle Job Setup

1. Create a **Freestyle project**.
2. Under **Source Code Management**, select **Git** and add your repository URL.
3. Under **Build Steps**, choose **Invoke top-level Maven targets**.
4. In **Goals**, enter:

   ```text
   clean verify
   ```

5. Under **Post-build Actions**:
   - Publish **JUnit** test results using:

     ```text
     target/surefire-reports/*.xml
     ```

   - Publish **JaCoCo / coverage** using:

     ```text
     target/site/jacoco/jacoco.xml
     ```

   If your Jenkins uses the older JaCoCo publisher UI instead of the newer Coverage plugin, use the generated report directory under:

   ```text
   target/site/jacoco
   ```

### Pipeline Option

A root `Jenkinsfile` is included for Jenkins Pipeline jobs. It checks out the code, runs `mvn clean verify`, publishes JUnit test results, and archives the JaCoCo report artifacts.

## Test Coverage

- **Project coverage**: verified with JaCoCo after `mvn clean verify` ✅
  - `Calculator.java` covered
  - `Main.java` covered
  - JaCoCo HTML + XML reports generated

## Test Results

- Total Tests: 24
- Passed: 24 ✅
- Failed: 0
- Errors: 0
- Skipped: 0

## Author

Created as part of Week 4 in-class assignment.

