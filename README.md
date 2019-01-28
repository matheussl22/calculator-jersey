# Calculator Jersey
Is this project was developed to example.

## Started on docker
To build: docker build -t calculator-jersey:latest .

To run: docker run -p 8080:8080 -t -i calculator-jersey

To access application: http://localhost:8080/myapp/application.wadl

## Follows examples.
Call: http://localhost:8080/myapp/rest-calculator/add/1/1/1     
Return: 3.0        
Call: http://localhost:8080/myapp/rest-calculator/subtract/10/5/1    
Return: 4.0               
Call: http://localhost:8080/myapp/rest-calculator/multiply/2/2/5    
Return: 20.0                    
Call: http://localhost:8080/myapp/rest-calculator/divide/10/2           
Return: 5.0           
Call: http://localhost:8080/myapp/rest-calculator/add-percent/1000/10          
Return: 1100.0            
Call: http://localhost:8080/myapp/rest-calculator/subtract-percent/1000/10      
Return: 900.0     
 
## Running the tests
To run test, you need exec command "mvn test" or run from IDE.

## Built With
* [Jersey / JAX-RS](https://jersey.github.io/) - RESTful Web Services in Java.
* [Maven](https://maven.apache.org/) - Dependency Management.
* [Java](https://docs.oracle.com/cd/E19798-01/821-1841/gilru/index.html) - Java platform technology.
* [Junit](https://junit.org/junit4/javadoc/latest/) - Used to run test.

## Authors
* **Matheus Warmeling Matias** 
    - [GitHub](https://github.com/matheussl22)
    - [Linkedin](https://www.linkedin.com/in/matheus-warmeling-matias-293aa457/)

## License
There isn't license on project.


