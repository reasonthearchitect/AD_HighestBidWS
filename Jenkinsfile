node {
    stage 'Checkout'
    git url: 'https://github.com/reasonthearchitect/AD_HighestBidWS.git'

    stage 'Build'
    sh "./gradlew clean build"
    //step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/TEST-*.xml'])

    stage 'BuildRunDocker'
    sh 'docker kill highestbid'
    sh 'docker rm highestbid'
    sh 'docker build -t reasonthearchitect/highestbid .'
    sh 'docker run -d --name highestbid -p 8230:8230 reasonthearchitect/highestbid'
}