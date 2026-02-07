pipeline {
agent any


stages {
stage('Checkout') {
steps {
echo 'Récupération du code source'
}
}


stage('Build') {
steps {
bat 'mvn clean compile'
}
}


stage('Test') {
steps {
bat 'mvn test'
}
}


stage('Package') {
steps {
bat 'mvn package'
}
}
}


post {
success {
echo 'Build réussi ✅'
}
failure {
echo 'Build échoué ❌'
}
}
}