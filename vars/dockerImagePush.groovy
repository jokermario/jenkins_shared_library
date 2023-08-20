def call(String imageName, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(
            credentialsId: 'docker',
            passwordVariable: 'PASS',
            usernameVariable: 'USER')]) {

        sh "docker login -u '$USER' -p '$PASS'"
    }

    sh """
        docker image push ${dockerHubUser}/${imageName}:${imageTag}
        docker image push ${dockerHubUser}/${imageName}:latest
    """
}