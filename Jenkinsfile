pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install -DdeviceName="10.1_WXGA_Tablet_API_24" -DplatformVersion="7.0"'
            }
        }
    }
}
