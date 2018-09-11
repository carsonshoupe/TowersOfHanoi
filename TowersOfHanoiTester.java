class TowersOfHanoiTester{

public static void main(String args[]){
	TowersOfHanoi toh = new TowersOfHanoi(5); 
	
	System.out.println(toh.toString()); 
	
	System.out.println(toh.solver().toString()); 
}
}