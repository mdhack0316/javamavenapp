pipeline {
    agent any

    stages {
        stage('Pulling The Code') {
            steps {
                git branch: 'main', url: 'https://github.com/mdhack0316/javamavenapp'
            }
        }
        stage('Build Jar File Using Maven Tool') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Testing The Code') {
            steps {
                sh 'java -jar target/*.jar'
            }
        }
        stage('Building Docker Image') {
            steps {
                sh 'sudo docker build -t mdhack/mymavenapp:${BUILD_NUMBER} .'
            }
        }
        stage('Pusing the Image Into Docker HUB') {
            steps {
                withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWD', variable: 'DOCKERPASSWORD')]) {
    // some block
                 sh 'sudo docker login -u mdhack -p  $DOCKERPASSWORD'
                 sh 'sudo docker push mdhack/mymavenapp:${BUILD_NUMBER}'
}
               
            }
        }
        stage('Test Dokcer Container') {
            steps {
                sh 'sudo docker rm -f test'
                sh 'sudo docker run -itd -p 8088:8080 --name test mymavenapp'
            }
        }
    }  
}

