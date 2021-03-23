pipeline{

	agent any 
	
	stages {
	 	
	 	stage('Compile Stage'){
	 	
	 		steps {
	 		
	 			withMaven(maven : 'maven_3_6_3'){
	 				sh 'maven clean install'
	 			
	 				}
	 			}
	 		}
	 		stage('Test Stage'){
	 	
	 		steps {
	 		
	 			withMaven(maven : 'maven_3_6_3'){
	 				sh 'maven test'
	 			
	 				}
	 			}
	 		}
	 		
	 		stage('Cucumber Reports') {
	 			
	 			steps {
	 				cucumber buildStatus : "UNSTABLE",
	 					fileIncludePattern: "**/cucumber.json",
	 					jsonReportDirectory : 'target' 
	 			
	 			
	 			}
	 		
	 		}
	 		
		}
}
	 			
