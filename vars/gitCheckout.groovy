def call(Map stageParams) {
    checkout([
            $class: 'GitSCM',
            branches: [[name: stageParams.branch]],
            userRemoteConfigs: [[credentialsId: stageParams.credentialsId, url: stageParams.url]]
    ])

//    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '63b9f1a8-ffe7-44fd-a97e-e4178f20d68e', url: 'https://github.com/jokermario/drone.git']])
}