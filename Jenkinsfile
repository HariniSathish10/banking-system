pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                git url: 'https://github.com/HariniSathish10/banking-system.git',
credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
