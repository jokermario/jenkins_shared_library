def call(String imageName, String dockerHubUser) {
    sh """
        trivy image ${dockerHubUser}/${imageName} ${dockerHubUser}/${imageName}:latest > scan.txt
        cat scan.txt
    """
}
