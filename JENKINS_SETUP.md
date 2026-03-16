# Jenkins Setup Guide for OTP1_Calculator

## Quick Setup Instructions

### Step 1: Create a New Freestyle Job in Jenkins

1. Click **"New Item"** in Jenkins
2. Enter job name: `Eliaseide_Calculator_V1`
3. Select **"Freestyle project"**
4. Click **OK**

### Step 2: Configure Source Code Management

1. Under **"Source Code Management"**, select **Git**
2. **Repository URL**: `https://github.com/elkuuz/OTP1_Calculator.git`
3. **Branch Specifier**: `main` (or `*/main`)
4. Leave credentials empty (for public repo)
5. Click **Save**

### Step 3: Configure Build Trigger (Optional)

1. Under **"Build Triggers"**, check **"Poll SCM"**
2. **Schedule**: `H H * * *` (daily build at midnight)
3. Click **Save**

### Step 4: Configure Build Steps

1. Click **"Configure"** on the job
2. Under **"Build"** section, click **"Add build step"**
3. Select **"Invoke top-level Maven targets"**
4. **Goals**: `clean verify`
5. **POM location**: (leave blank - uses default)
6. Click **Save**

### Step 5: Configure Post-Build Actions

1. Click **"Configure"** on the job
2. Scroll to **"Post-build Actions"**
3. Click **"Add post-build action"**
4. Select **"Publish JUnit test result report"**
5. **Test report XMLs**: `target/surefire-reports/*.xml`
6. Click **"Add post-build action"**
7. Select **"Publish HTML reports"** (for JaCoCo coverage)
8. **HTML directory to archive**: `target/site/jacoco`
9. **Index page[s]**: `index.html`
10. **Report name**: `JaCoCo Coverage Report`
11. Click **Save**

### Step 6: Build the Project

1. Click **"Build Now"** on the job page
2. Watch the build progress in the **"Build History"**
3. Click on the build number to see full console output

## Pipeline Configuration (If Using Jenkinsfile)

If you want to use the Jenkinsfile (declarative pipeline):

1. Create a **New Item** and select **"Pipeline"**
2. Under **"Pipeline"**, select **"Pipeline script from SCM"**
3. **SCM**: Select **Git**
4. **Repository URL**: `https://github.com/elkuuz/OTP1_Calculator.git`
5. **Branch**: `main`
6. **Script Path**: `Jenkinsfile`
7. Click **Save**
8. Click **"Build Now"**

## Expected Build Results

- ✅ All 24 unit tests pass
- ✅ JaCoCo coverage report generated
- ✅ Docker image built and smoke-tested
- ✅ Test reports published
- ✅ Coverage report available

## Accessing Reports

After build success:

1. **Test Results**: Click **"Latest Test Result"** link
2. **Coverage Report**: Click **"JaCoCo Coverage Report"** link under build artifacts
3. **Console Output**: View full build logs in console

## Troubleshooting

### "mvn: command not found" error

**Solution**: Maven path is added to Jenkinsfile. Ensure the Jenkinsfile has:
```groovy
export PATH="/opt/homebrew/bin:$PATH"
```

### Tests not found

**Solution**: Ensure `target/surefire-reports/*.xml` path is correct in post-build actions.

### Docker build fails

**Solution**: Ensure Docker daemon is running: `docker ps`

## GitHub Repository

- **URL**: https://github.com/elkuuz/OTP1_Calculator
- **Branch**: main
- **Status**: Public repository

## Project Details

- **Language**: Java 21
- **Build Tool**: Maven 3.9.9
- **Testing**: JUnit 5
- **Coverage**: JaCoCo 0.8.9
- **Container**: Docker with multi-stage build
- **Test Count**: 24 tests
- **All Tests**: ✅ PASSING

