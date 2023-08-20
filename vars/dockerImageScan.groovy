//def call(String imageName, String dockerHubUser) {
//    sh """
//        trivy image ${dockerHubUser}/${imageName}:latest > scan.txt
//        cat scan.txt
//    """
//}

def call(String ecrRepoName, String aws_account_id, String aws_region){
    sh """
       trivy image ${aws_account_id}.dkr.ecr.${aws_region}.amazonaws.com/${ecrRepoName}:latest > scan.txt
       cat scan.txt
    """
}
