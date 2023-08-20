//def call(String imageName, String imageTag, String dockerHubUser) {
//    sh """
//        docker rmi ${dockerHubUser}/${imageName}:${imageTag}
//        docker rmi ${dockerHubUser}/${imageName}:latest
//    """
//}

def call(String ecrRepoName, String aws_account_id, String aws_region){
    sh """
        docker rmi ${ecrRepoName}:latest ${aws_account_id}.dkr.ecr.${aws_region}.amazonaws.com/${ecrRepoName}:latest
    """
}
