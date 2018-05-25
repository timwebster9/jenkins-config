pipelineJob('gradle-gatling') {
    definition {
        cps {
            sandbox()
            script("""
pipeline {

  agent {
	kubernetes {
	  label 'k8s'
	  defaultContainer 'jnlp'
	  yaml """
apiVersion: v1
kind: Pod
metadata:
  labels:
	some-label: some-label-value
spec:
  containers:
  - name: java
	image: openjdk:8-jdk-alpine
	command:
	- cat
	tty: true
  - name: docker
	image: docker:18.05.0-ce-git
	command:
	- cat
	tty: true
"""
	}
  }
    stages {
		stage('Gradle Build') {
			steps {
				container('java') {
					sh './gradlew build'
				}
			}
		}
		/*
        stage('Gradle Build') {
        	agent {
                kubernetes {
                    label 'java'
                    inheritFrom 'base'
                    containerTemplate {
                        name 'java'
                        image 'openjdk:8-jdk-alpine'
                        ttyEnabled true
                        command 'cat'
                    }
                }
            }
            steps {
                script {
                    sh("./gradlew build")
                }
            }
        }
		stage('Docker Build') {
			agent {
				kubernetes {
					label 'docker'
					inheritFrom 'base'
					containerTemplate {
						name 'docker'
						image 'docker:18.05.0-ce-git'
						ttyEnabled true
						command 'cat'
					}
				}
			}
			steps {
				timeout(5) {
					waitUntil {
					   script {
						 return false;
					   }
					}
				}
				//script {
				//	sh("docker build -t timw/gradle-gatling .")
				//}
			}
		}
		stage('Start App') {
			steps {
				script {
					sh("./gradlew bootRun")
				}
			}
		}
		stage('Wait for App') {
			steps {
				timeout(5) {
                    waitUntil {
                       script {
                         def r = sh script: 'wget -q http://localhost:8080 -O /dev/null', returnStatus: true
                         return (r == 0);
                       }
                    }
                }
			}
		}
		stage('Performance Test') {
			steps {
				script {
					sh("./gradlew gatlingRun")
				}
			}
		}
		*/
    }
}
      """.stripIndent())
        }
    }
}