pipeline {

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install -DdeviceName="10.1_WXGA_Tablet_API_24" -DplatformVersion="7.0"'
            }
        }
    }
}
