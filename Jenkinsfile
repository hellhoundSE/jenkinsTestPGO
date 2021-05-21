pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                sh 'gradle test --tests'
            }
        }
        stage('Unit Tests') {
            steps {
                sh 'gradle build'
            }
        }
    }
}
