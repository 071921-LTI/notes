pipeline {
   agent any
   
    environment {
        PORT_HOST="8081"
        PORT_CONT="8080"
        IMAGE_TAG="springboot-demo"
        CONTAINER_NAME="bootdemo-app"
        DB_URL=credentials('DB_URL')
        DB_USER=credentials('DB_USER')
        DB_PASS=credentials('DB_PASS')
    }

   stages {
      stage('checkout'){
          steps {
            script {
                properties([pipelineTriggers([githubPush()])])
            }
            git branch: 'main', url: 'https://github.com/vinh-tranhuu/springboot-demo.git'

          }
      }
      stage('clean') {
         steps {
            sh 'mvn clean'
         }
      }
      stage('package') {
         steps {
            sh 'mvn package -Dmaven.test.skip=true'
         }
      }
      stage('remove previous image if exists') {
            steps {
                sh 'docker rmi -f ${IMAGE_TAG} || true'
            }
        }

       stage('create image') {
            steps {
                sh 'docker build -t ${IMAGE_TAG} -f Dockerfile .'
            }
        }
        stage('remove previous container if exists') {
            steps {
                sh 'docker stop ${CONTAINER_NAME} || true'
            }
        }
        stage('create container') {
            steps {
                sh 'docker run -e DB_URL=${DB_URL} -e DB_USER=${DB_USER} -e DB_PASS=${DB_PASS} -d --rm -p ${PORT_HOST}:${PORT_CONT} --name ${CONTAINER_NAME} ${IMAGE_TAG} '
            }
        }
    }
}
