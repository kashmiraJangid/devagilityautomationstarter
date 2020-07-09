pipeline {
  agent any
  parameters{
    string(name: 'PUBLIC_IP')
  }
  stages {
    stage('Test') {
      steps {
        sh "mvn clean test -Dpublic.ip=${params.PUBLIC_IP}"
      }
    }
  }
}
