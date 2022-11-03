pipeline {
  agent any
  stages {
    stage('checkout code') {
      steps {
        git(url: 'https://github.com/hmneto/spring-boot-authorize-and-authentication', branch: 'main')
      }
    }

    stage('Log') {
      parallel {
        stage('Log') {
          steps {
            sh 'ls -la'
          }
        }

        stage('') {
          steps {
            sh 'mvn test'
          }
        }

      }
    }

  }
}