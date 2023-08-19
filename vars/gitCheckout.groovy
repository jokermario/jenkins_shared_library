def call(Map stageParams) {
    checkout([
            $class: 'GitSCM',
            branches: [[name: stageParams.branch]],
            userRemoteConfigs: [[credentialsId: stageParams.credentialsId, url: stageParams.url]]
    ])
}