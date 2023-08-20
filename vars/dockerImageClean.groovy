def call(String imageName, String imageTag, String dockerHubUser) {
    sh """
        docker rmi ${dockerHubUser}/${imageName}:${imageTag}
        docker rmi ${dockerHubUser}/${imageName}:latest
    """
}
