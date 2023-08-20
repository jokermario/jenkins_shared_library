def call(String imageName, String imageTag, String dockerHubUser) {
    sh """
        docker image build -t ${dockerHubUser}/${imageName} .
        docker image tag ${dockerHubUser}/${imageName} ${dockerHubUser}/${imageName}:${imageTag}
        docker image tag ${dockerHubUser}/${imageName} ${dockerHubUser}/${imageName}:latest
    """
}