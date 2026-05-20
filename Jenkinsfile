pipeline {
    agent any

    stages {

        stage('clone and clean repo') {
            steps {
                sh 'rm -rf tp-demoic'
                sh 'git clone https://github.com/Mihajaand/tp-demoic'
                sh '/Users/macbook/maven/bin/mvn clean -f tp-demoic/pom.xml'
            }
        }

        stage('Test') {
            steps {
                sh '/Users/macbook/maven/bin/mvn test -f tp-demoic/pom.xml'
            }
        }

        // AJOUTER PACKAGE ICI
        stage('Package') {
            steps {
                sh '/Users/macbook/maven/bin/mvn package -DskipTests -f tp-demoic/pom.xml'
            }
        }

        stage('Build the docker image') {
    steps {

        sh 'docker build -t mihajaand/triang7:1.0.0 tp-demoic'

        withCredentials([string(credentialsId: 'dockerhubpass', variable: 'dockerHubPass')]) {

            sh 'echo $dockerHubPass | docker login -u mihajaand --password-stdin'

        }

        sh 'docker push mihajaand/triang7:1.0.0'
    }
}

        stage('Deploy') {
            steps {
                sh '/Users/macbook/maven/bin/mvn deploy -f tp-demoic/pom.xml'
            }
        }

        stage('Sonar') {
            steps {
                sh '/Users/macbook/maven/bin/mvn sonar:sonar -Dsonar.projectKey=triangle-app -Dsonar.host.url=http://localhost:9000 -Dsonar.login=squ_b39ec22064000f8658c7f10a74e1ada58bf3781d -f tp-demoic/pom.xml'
            }
        }
    }
}