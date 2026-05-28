pipeline {
    agent any

    tools {
        maven 'MyMaven'
        jdk 'JDK 21'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/your-repo/banking-system.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t banking-account-service .'
            }
        }
    }
}
