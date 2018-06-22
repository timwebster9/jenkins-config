pipelineJob("sandbox-scripted") {
   definition {
       cpsScm {
           scm {
               git {
                   remote {
                       url('https://github.com/timwebster9/jenkinsfile-sandbox.git')
                   }
                   branch('master')
               }
           }
           scriptPath('Jenkinsfile.scripted')
       }
   }
}