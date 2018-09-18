import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class TowersOfHanoiTester{
	
	@Test
	public void tohTester(){
		TowersOfHanoi toh = new TowersOfHanoi(29); 
		System.out.println(toh.toString());
		System.out.println(toh.solver().toString()); 
	}
	 
}



//javac -cp .;C:\junit\junit-4.10.jar TowersOfHanoiTester.java
//java -cp .;C:\junit\junit-4.10.jar org.junit.runner.JUnitCore TowersOfHanoiTester
