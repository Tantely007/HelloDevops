pipeline {
  agent any

  tools {
    maven 'Maven3'
  }

  stages {

    stage('Checkout') {
      steps {
        git url: 'https://github.com/TON_USER/hello-devops.git'
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

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('SonarLocal') {
          sh 'mvn sonar:sonar'
        }
      }
    }

    stage('Docker Build') {
      steps {
        sh 'docker build -t tonuser/hello-devops:1.0 .'
      }
    }

    stage('Docker Push') {
      steps {
        withCredentials([string(credentialsId: 'dockerhub-pass', variable: 'DOCKER_PASS')]) {
          sh 'docker login -u tonuser -p $DOCKER_PASS'
          sh 'docker push tonuser/hello-devops:1.0'
        }
      }
    }
  }

  post {
    failure {
      echo 'Build FAILED'
    }
    success {
      echo 'Build SUCCESS'
    }
  }
}
