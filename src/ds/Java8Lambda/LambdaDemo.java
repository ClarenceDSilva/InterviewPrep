public class LambdaDemo {
	//Using an Interface to print HelloWorld (Polymorphism)
	
	//Accepts an argument of an interface Greeting   
	public void greet(Greeting greeting){
		greeting.performInterface();
	}
	
	
	public static void main(String[] args) {
		LambdaDemo ld = new LambdaDemo();
		//lambda function
		Greeting lambdaGreeter = () -> System.out.println("Hello World from the Lambda Greeting Interface");
		Greeting helloWorldGreeter = new HelloWorldGreeter(); // You don't need this if you execute Step2
		ld.greet(helloWorldGreeter);
		
		//Declaring Interfaces Java 8
		Greeting innerClassGreeting = new Greeting() {
			public void performInterface(){
				System.out.println("Inner Class greeting executed");
			}
		};
		innerClassGreeting.performInterface();
		
		//Executing lambda function
		lambdaGreeter.performInterface();
		
		
		//Step 2: The above can per performed also as follows -> Acheived using Polymorphism
		System.out.println("\n");
		ld.greet(lambdaGreeter);
		ld.greet(innerClassGreeting);
	}

}
