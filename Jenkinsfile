pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
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
