pipeline {
  agent any
  parameters{
    string(name: 'url')
  }
  stages {
    stage('Test') {
      steps {
        sh "mvn clean test -Durl=${params.url}"
      }
    }
  }
}
