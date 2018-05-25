pipelineJob("gradle-gatling") {
   definition {
       cpsScm {
           scm {
               git {
                   remote {
                       url('https://github.com/timwebster9/gradle-gatling.git')
                   }
                   branch('master')
               }
           }
           scriptPath('Jenkinsfile')
       }
   }
}