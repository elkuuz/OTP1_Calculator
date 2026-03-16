pipeline {
    agent any

    options {
        timestamps()
    }

    parameters {
        booleanParam(name: 'BUILD_DOCKER_IMAGE', defaultValue: true, description: 'Build and smoke-test Docker image')
        booleanParam(name: 'DEPLOY_TO_DOCKER_HUB', defaultValue: false, description: 'Push image to Docker Hub (optional)')
        string(name: 'DOCKER_IMAGE', defaultValue: 'elkuuz/otp1_calculator', description: 'Docker Hub repository in format user/repo')
        string(name: 'DOCKER_TAG', defaultValue: 'latest', description: 'Image tag to build/push')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build, Test, Coverage') {
            steps {
                sh '''#!/bin/bash
                export PATH="/opt/homebrew/bin:$PATH"
                mvn -B clean verify
                '''
            }
        }

        stage('Build Docker Image') {
            when {
                expression { params.BUILD_DOCKER_IMAGE }
            }
            steps {
                sh "docker build -t ${params.DOCKER_IMAGE}:${params.DOCKER_TAG} ."
            }
        }

        stage('Smoke Test Docker Image') {
            when {
                expression { params.BUILD_DOCKER_IMAGE }
            }
            steps {
                sh "docker run --rm ${params.DOCKER_IMAGE}:${params.DOCKER_TAG} | tee docker-output.log"
                sh "grep -q '\\.\\.\\.Power on\\.\\.\\.' docker-output.log"
            }
        }

        stage('Push Docker Image (Optional)') {
            when {
                expression { params.BUILD_DOCKER_IMAGE && params.DEPLOY_TO_DOCKER_HUB }
            }
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''#!/bin/sh
                    echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    docker push "${DOCKER_IMAGE}:${DOCKER_TAG}"
                    docker logout
                    '''
                }
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: false
            archiveArtifacts artifacts: 'target/site/jacoco/**,target/jacoco.exec,target/*.jar,docker-output.log', allowEmptyArchive: true, fingerprint: true
        }
    }
}

