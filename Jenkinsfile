pipeline {
    agent any
    stages {
        stage('Tests') {
            steps {
                sh 'gradle test --tests'
            }
        }
        stage('Build') {
            steps {
                sh 'gradle build'
            }
        }
    }
}
