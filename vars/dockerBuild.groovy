//def call(String imageName, String imageTag, String dockerHubUser) {
//    sh """
//        docker image build -t ${dockerHubUser}/${imageName} .
//        docker image tag ${dockerHubUser}/${imageName} ${dockerHubUser}/${imageName}:${imageTag}
//        docker image tag ${dockerHubUser}/${imageName} ${dockerHubUser}/${imageName}:latest
//    """
//}

def call(String ecrRepoName, String aws_account_id, String aws_region){
    sh """
        docker build -t ${ecrRepoName} .
        docker tag ${ecrRepoName}:latest ${aws_account_id}.dkr.ecr.${aws_region}.amazonaws.com/${ecrRepoName}:latest
    """
}
