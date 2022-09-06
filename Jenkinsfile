pipeline {
    agent any 
    stages {
        stage('gitcode Download') {
            steps {
                git branch: 'main', url: 'https://github.com/mdhack0316/javamavenapp'
            }
        }
        stage('Build Using Maven') {
            steps {
                sh 'mvn clean package'
            }    
        }
        stage('Testing Code') { 
            steps {
                sh 'java -jar target/*.jar'
            }
        }
        stage('Building Dockerfile') {
            steps {
                sh 'docker build -t myjava:${BUILD_NUMBER} . '
            }
        }
       
    }
}
