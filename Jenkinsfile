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

        stage('') {
          steps {
            script {
              pipeline{
                agent { label 'built-in' }
                tools {
                  maven '3.8.4'
                }
                stages{
                  stage('teste'){
                    steps {
                      sh 'mvn --version'
                    }
                  }
                }
              }
            }

          }
        }

      }
    }

  }
}