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
- Docker (for container build/run and optional Jenkins deploy stage)

### Run Tests
```bash
mvn clean test
```

### Generate Code Coverage Report
```bash
mvn clean verify
```

The JaCoCo coverage report will be generated at: `target/site/jacoco/index.html`

## Test Results

✅ **All 24 Tests Passing**
- ExtraTest: 7 tests
- KelvinToCelsiusTest: 4 tests  
- CalculatorTest: 5 tests
- SquareTest: 6 tests
- MainTest: 2 tests

## Code Coverage

✅ **100% Code Coverage**
- **Calculator.java**: 100% instruction coverage (78/78), 100% branch coverage (4/4), 100% line coverage (23/23)
- **Main.java**: 100% instruction coverage (71/71), 100% line coverage (21/21)

## Docker Setup

### Build Docker Image
```bash
docker build -t otp1_calculator:local .
```

### Run Docker Container
```bash
docker run --rm otp1_calculator:local
```

Expected output:
```
...Power on...
Add 500      = 500.0
Add 200      = 700.0
Subtract 100 = 600.0
Divide by 2  = 300.0
Multiply by 10 = 3000.0
...Resetting...
Add 500      = 500.0
...Power off...
```

## Jenkins Integration

A declarative pipeline (`Jenkinsfile`) is included for automated build, test, and deployment:

### Pipeline Stages
1. **Checkout** - Clones repository from GitHub
2. **Build, Test, Coverage** - Runs `mvn clean verify` with JaCoCo
3. **Build Docker Image** - Creates Docker image (can be disabled)
4. **Smoke Test Docker Image** - Verifies image runs correctly
5. **Push Docker Image** - Deploys to Docker Hub (optional)

### Setup Instructions
See [JENKINS_SETUP.md](JENKINS_SETUP.md) for detailed configuration steps.

### Building with Jenkins
```groovy
// Jenkins will automatically:
// 1. Clone your GitHub repo
// 2. Run Maven clean verify
// 3. Generate JaCoCo coverage reports
// 4. Publish test results (24 tests)
// 5. Build and test Docker image
// 6. Archive JaCoCo reports as artifacts
```

### Post-Build Artifacts
- JUnit test reports: `target/surefire-reports/*.xml`
- JaCoCo coverage: `target/site/jacoco/**`
- Built JAR: `target/*.jar`
- Docker build logs: `docker-output.log`

## API Documentation

### Calculator Methods

#### Basic Operations
```java
calculator.add(double n);           // Adds to result
calculator.subtract(double n);      // Subtracts from result
calculator.multiply(double n);      // Multiplies result
calculator.divide(double n);        // Divides result (throws ArithmeticException if n=0)
```

#### Advanced Operations
```java
calculator.square(double n);        // Sets result to n²
calculator.squareRoot(double n);    // Sets result to √n (throws IllegalArgumentException if n<0)
calculator.kelvinToCelsius(double n); // Converts K to °C: result = n - 273.15
```

#### Utility Methods
```java
calculator.getResult();             // Returns current result
calculator.reset();                 // Resets result to 0
calculator.powerOn();               // Initialize calculator
calculator.powerOff();              // Shutdown calculator
```

### Example Usage
```java
Calculator calc = new Calculator();
calc.powerOn();
calc.add(300);
calc.kelvinToCelsius(300);          // Converts 300K to Celsius
System.out.println(calc.getResult()); // Output: 26.85
```

## Continuous Integration / Continuous Deployment

This project is set up for CI/CD with:
- **Version Control**: GitHub (`https://github.com/elkuuz/OTP1_Calculator`)
- **Build Automation**: Maven with JaCoCo code coverage
- **Pipeline**: Jenkins Declarative Pipeline with automated testing and Docker deployment
- **Container Registry**: Docker Hub (optional deployment)

## Author

Elias Eide

## License

This project is open source and available on GitHub.

## Assignment Details

**Week 4-5 In-Class Temperature Converter & Calculator Extension**

This project implements:
1. ✅ Kelvin-to-Celsius conversion function with formula: °C = K - 273.15
2. ✅ Comprehensive JUnit 5 test cases (24 tests total)
3. ✅ JaCoCo code coverage report (100% coverage achieved)
4. ✅ Jenkinsfile for automated pipeline execution
5. ✅ Docker containerization with multi-stage build
6. ✅ GitHub repository for version control

````

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

A root `Jenkinsfile` is included for Jenkins Pipeline jobs. It performs:

- Checkout
- `mvn clean verify` (tests + JaCoCo report)
- JUnit publishing (`target/surefire-reports/*.xml`)
- JaCoCo artifact archiving (`target/site/jacoco/**`)
- Optional Docker image build + smoke test
- Optional Docker Hub push

Pipeline parameters:

- `BUILD_DOCKER_IMAGE` (default `true`)
- `DEPLOY_TO_DOCKER_HUB` (default `false`)
- `DOCKER_IMAGE` (default `elkuuz/otp1_calculator`)
- `DOCKER_TAG` (default `latest`)

For Docker Hub deployment from Jenkins, add a `Username with password` credential with ID `dockerhub-credentials`.

## Docker (Local Verification)

Build and run locally:

```bash
docker build -t otp1_calculator:local .
docker run --rm otp1_calculator:local
```

Expected output includes calculator console lines such as `...Power on...`.

Optional Docker Hub push from local terminal:

```bash
docker tag otp1_calculator:local <dockerhub-user>/otp1_calculator:latest
docker login
docker push <dockerhub-user>/otp1_calculator:latest
```

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

