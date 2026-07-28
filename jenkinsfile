pipeline {
	agent any
	
	stages {
		stage('Checkout'){
			steps{
				git	'https://github.com/surajswamy20/AutomationFramework-secretSauce.git'
			}
		stage('Build'){
			steps{
				bat 'mvn clean test'
			}
		}
		}
	}
}