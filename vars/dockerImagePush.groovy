//def call(String imageName, String imageTag, String dockerHubUser) {
//    withCredentials([usernamePassword(
//            credentialsId: 'docker',
//            passwordVariable: 'PASS',
//            usernameVariable: 'USER')]) {
//
//        sh "docker login -u '$USER' -p '$PASS'"
//    }
//
//    sh """
//        docker image push ${dockerHubUser}/${imageName}:${imageTag}
//        docker image push ${dockerHubUser}/${imageName}:latest
//    """
//}

def call(String ecrRepoName, String aws_account_id, String aws_region){
    sh """
        aws ecr get-login-password --region ${aws_region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${aws_region}.amazonaws.com
        docker push ${aws_account_id}.dkr.ecr.${aws_region}.amazonaws.com/${ecrRepoName}:latest
    """
}