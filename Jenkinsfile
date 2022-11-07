pipeline {
  agent any
  stages {
    stage('log') {
      parallel {
        stage('log') {
          steps {
            sh 'ls -la'
          }
        }

        stage('error') {
          steps {
            build 'test'
          }
        }

      }
    }

  }
}