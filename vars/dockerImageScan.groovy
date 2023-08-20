def call(String imageName, String imageTag, String dockerHubUser) {
    sh """
        trivy image ${dockerHubUser}/${imageName} ${dockerHubUser}/${imageName}:latest > scan.txt
        cat scan.txt
    """
}
