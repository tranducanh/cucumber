pipeline {
    agent any
    tools {
            maven 'Maven 3.3.9'
            jdk 'jdk8'
    }
    stages {
       stage ('Initialize') {
                steps {
                    sh '''
                        echo "PATH = ${PATH}"
                        echo "M2_HOME = ${M2_HOME}"
                    '''
                }
            }
        stage('Build') {
            steps {
                sh 'mvn clean install -DdeviceName="10.1_WXGA_Tablet_API_24" -DplatformVersion="7.0"'
            }
        }
    }
}
