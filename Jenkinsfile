pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build, Test, Coverage') {
            steps {
                sh 'mvn clean verify'
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: false
            archiveArtifacts artifacts: 'target/site/jacoco/**, target/jacoco.exec, target/*.jar', fingerprint: true
        }
    }
}

