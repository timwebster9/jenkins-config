pipelineJob("standalone-perf-test") {
   definition {
       cpsScm {
           scm {
               git {
                   remote {
                       url('https://github.com/timwebster9/standalone-perf-test.git')
                   }
                   branch('master')
               }
           }
           scriptPath('Jenkinsfile')
       }
   }
}