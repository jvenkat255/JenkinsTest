//def Sonarqube
pipeline {
	agent { label 'ATG'}
     options { 
    skipDefaultCheckout()
    disableConcurrentBuilds()
   }
	   
    stages {
    stage('Clear workspace') {
      steps {
        cleanWs()
      }
    }  
    stage('Source Checkout') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], 
        doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], 
        userRemoteConfigs: [[credentialsId: 'jvenkat255', url: 'https://github.com/jvenkat255/JenkinsTest.git']]])
        //pipelineScripts = load ("Sonarqube.groovy")
      }
    }
    
 stage('Sonarqube') {
    environment {
        scannerHome = tool 'SonarQube_Scanner_2.8'
    }
    steps {
        withSonarQubeEnv('sonarqube_atg') {
            //bat "${scannerHome}/bin/sonar-scanner"
            bat "gradlew -i sonarqube"
        }
        //timeout(time: 1, unit: 'MINUTES') {
          //  waitForQualityGate abortPipeline: true
        //}
    }
 }
 //stage('Quality Gate') {
           // steps {
           //   timeout(time: 2, unit: 'MINUTES') {
               // waitForQualityGate abortPipeline: true
          //   }
            //}
         // }
     
             
     
   
   
    
  }
 
   
} 
