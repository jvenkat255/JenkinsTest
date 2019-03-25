import jenkins.model.*
jenkins = Jenkins.instance

def sonarQualityGateCheck() {
     timeout(time: 15, unit: 'MINUTES') {
        def qualityGate = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
        if (qualityGate.status != 'OK') {
            failedIn = "sonar quality gate check"
            error("Pipeline aborted due to quality gate failure: ${qualityGate.status}")
        }
     }
}
