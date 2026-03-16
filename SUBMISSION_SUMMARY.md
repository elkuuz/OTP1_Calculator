# Week 5 In-Class Assignment - Submission Summary

## Project Status: ✅ COMPLETE

### What Has Been Implemented

#### 1. ✅ Kelvin-to-Celsius Conversion Function
- **Method**: `calculator.kelvinToCelsius(double kelvin)`
- **Formula**: °C = K - 273.15
- **Location**: `/src/main/java/Calculator.java` (Line 38-40)
- **Example**: 300K → 26.85°C

#### 2. ✅ Comprehensive JUnit Tests
- **Total Tests**: 24 tests (all passing ✅)
- **Test Classes**:
  - `ExtraTest.java`: 7 tests (lifecycle and utility testing)
  - `KelvinToCelsiusTest.java`: 4 parametrized tests (K to C conversions)
  - `CalculatorTest.java`: 5 tests (basic operations)
  - `SquareTest.java`: 6 tests (square operations)
  - `MainTest.java`: 2 tests (application entry point)

#### 3. ✅ JaCoCo Code Coverage Report
- **Coverage**: 100% ✅
- **Calculator.java**: 
  - Instruction Coverage: 78/78 (100%)
  - Branch Coverage: 4/4 (100%)
  - Line Coverage: 23/23 (100%)
  - Method Coverage: 12/12 (100%)
- **Main.java**:
  - Instruction Coverage: 71/71 (100%)
  - Line Coverage: 21/21 (100%)
  - Method Coverage: 2/2 (100%)
- **Report Location**: `/target/site/jacoco/index.html`
- **Generate Command**: `mvn clean verify`

#### 4. ✅ Jenkinsfile (Pipeline Configuration)
- **File**: `/Jenkinsfile`
- **Type**: Declarative Pipeline
- **Stages**:
  1. Checkout - Clone from GitHub
  2. Build, Test, Coverage - Maven clean verify with JaCoCo
  3. Build Docker Image - Create container image
  4. Smoke Test Docker Image - Verify container runs
  5. Push Docker Image - Deploy to Docker Hub (optional)
- **Post-Build Actions**:
  - Publish JUnit test reports
  - Archive JaCoCo coverage reports
  - Archive Docker output logs

#### 5. ✅ Docker Setup
- **Dockerfile**: Multi-stage build
  - Stage 1: Maven build (Java 21)
  - Stage 2: Runtime (JRE 21)
- **Build Command**: `docker build -t otp1_calculator:local .`
- **Run Command**: `docker run --rm otp1_calculator:local`
- **Status**: ✅ Working perfectly

#### 6. ✅ GitHub Repository
- **URL**: https://github.com/elkuuz/OTP1_Calculator
- **Branch**: main
- **Commits**: Recent commits include Jenkinsfile, Docker, and documentation
- **Status**: Public, fully accessible

### Files Included in Repository

```
Wee4_InClass_Calculator/
├── pom.xml                          # Maven configuration with JaCoCo
├── Dockerfile                       # Multi-stage Docker build
├── Jenkinsfile                      # CI/CD pipeline configuration
├── README.md                        # Comprehensive project documentation
├── JENKINS_SETUP.md                 # Step-by-step Jenkins setup guide
├── src/
│   ├── main/java/
│   │   ├── Calculator.java          # Main calculator with kelvinToCelsius
│   │   └── Main.java                # Application entry point
│   └── test/java/
│       ├── AbstractParent.java       # Base test class with lifecycle
│       ├── CalculatorTest.java       # Basic operation tests
│       ├── ExtraTest.java            # Comprehensive tests
│       ├── KelvinToCelsiusTest.java  # Temperature conversion tests
│       ├── MainTest.java             # Entry point tests
│       └── SquareTest.java           # Square operation tests
└── target/
    ├── calculator-project-1.0-SNAPSHOT.jar  # Built JAR
    ├── jacoco.exec                   # JaCoCo coverage data
    ├── surefire-reports/             # Test reports (24 tests)
    └── site/jacoco/                  # JaCoCo HTML report
```

### Test Execution Results

```
Tests run: 24, Failures: 0, Errors: 0, Skipped: 0

Test Breakdown:
├── ExtraTest..................... 7/7 PASSED ✅
├── KelvinToCelsiusTest........... 4/4 PASSED ✅
├── CalculatorTest............... 5/5 PASSED ✅
├── SquareTest................... 6/6 PASSED ✅
└── MainTest..................... 2/2 PASSED ✅
```

### Build Status

- **Maven Build**: ✅ SUCCESS (1.679s)
- **Compilation**: ✅ 2 source files compiled
- **Tests**: ✅ 24/24 passed
- **JaCoCo Report**: ✅ Generated
- **JAR Creation**: ✅ calculator-project-1.0-SNAPSHOT.jar
- **Docker Image**: ✅ Built and tested

### How to Reproduce Locally

#### Prerequisites
```bash
# Ensure you have:
- Java 21 (or higher)
- Maven 3.9.9 (or later)
- Docker Desktop
```

#### Build and Test
```bash
cd /Users/eliaseide/IdeaProjects/Wee4_InClass_Calculator

# Generate coverage report
mvn clean verify

# View JaCoCo report
open target/site/jacoco/index.html

# Build Docker image
docker build -t otp1_calculator:local .

# Run Docker image
docker run --rm otp1_calculator:local
```

#### Jenkins Setup
1. Follow instructions in `JENKINS_SETUP.md`
2. Create Freestyle job: `Eliaseide_Calculator_V1`
3. Point to GitHub repo: https://github.com/elkuuz/OTP1_Calculator
4. Configure Maven build: `mvn clean verify`
5. Add post-build actions for JUnit and JaCoCo reports
6. Click "Build Now"

### Expected Artifacts for Jenkins

When Jenkins runs successfully, you should see:
1. **Console Output**: Shows all 24 tests passing
2. **Test Results**: JUnit report with 24/24 passed
3. **JaCoCo Report**: Coverage dashboard with 100% coverage
4. **Docker Output**: Smoke test showing calculator running

### GitHub Repository Details

**Repository URL**: https://github.com/elkuuz/OTP1_Calculator

**Recent Commits**:
- "Add comprehensive documentation and Jenkins setup guide"
- "Fix Jenkinsfile Maven path configuration for macOS"
- "Add README with project documentation"

**Key Branches**: main

**Access**: Public (no authentication required)

### Technologies Stack

| Component | Version |
|-----------|---------|
| Java | 21 |
| Maven | 3.9.9 |
| JUnit | 5.10.2 |
| JaCoCo | 0.8.9 |
| Docker | Latest |
| Jenkins | Latest |

### Coverage Summary

**100% Code Coverage Achieved** ✅

- All methods tested
- All branches covered
- All lines executed
- Zero uncovered code paths

### Assignment Completion Checklist

- ✅ Implemented Kelvin-to-Celsius conversion function
- ✅ Created comprehensive JUnit test cases (24 tests)
- ✅ Generated JaCoCo coverage report (100% coverage)
- ✅ Created Jenkinsfile for automated pipeline
- ✅ Set up Docker containerization
- ✅ Published to GitHub repository
- ✅ Documented all features and setup instructions
- ✅ All tests passing (24/24)
- ✅ Docker image builds and runs successfully

---

## For Oma Submission

### Items to Submit:

1. **GitHub Repository Link**:
   ```
   https://github.com/elkuuz/OTP1_Calculator
   ```

2. **Local Maven Build Evidence** (Screenshot showing 24 tests passing):
   ```bash
   # Run this command:
   mvn clean verify
   
   # You should see:
   # Tests run: 24, Failures: 0, Errors: 0, Skipped: 0
   # BUILD SUCCESS
   ```

3. **JaCoCo Coverage Report** (Screenshot showing 100% coverage):
   ```bash
   # After running: mvn clean verify
   # View HTML report:
   open target/site/jacoco/index.html
   ```

4. **Docker Image Working** (Screenshot showing output):
   ```bash
   # Run:
   docker build -t otp1_calculator:local .
   docker run --rm otp1_calculator:local
   
   # You should see:
   # ...Power on...
   # [calculations]
   # ...Power off...
   ```

5. **Jenkins Pipeline** (Screenshot when running in Jenkins):
   - Build URL: http://localhost:8080/job/Eliaseide_Calculator_V1
   - Should show all stages passing with 24 tests

---

**Status**: Ready for submission ✅
**Date Completed**: March 16, 2026
**All Requirements Met**: Yes ✅

