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
aws ecr get-login-password --region ${aws_region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${aws_region}.amazonaws.com
//    """
//}

def call(String ecrRepoName, String aws_account_id, String aws_region){
    def awsCliCommand = "aws ecr get-login-password --region ${aws_region}"
    def loginCommand = sh(script: awsCliCommand, returnStdout: true).trim()
    sh script: "${loginCommand} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${aws_region}.amazonaws.com"
    sh """
        docker push ${aws_account_id}.dkr.ecr.${aws_region}.amazonaws.com/${ecrRepoName}:latest
    """
}