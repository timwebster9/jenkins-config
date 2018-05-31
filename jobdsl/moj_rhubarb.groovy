pipelineJob("moj-rhubarb") {
   definition {
       cpsScm {
           scm {
               git {
                   remote {
                       url('git@github.com:hmcts/moj-rhubarb-recipes-service.git')
                       credentials('git')
                   }
                   branch('master')
               }
           }
           scriptPath('Jenkinsfile')
       }
   }
}