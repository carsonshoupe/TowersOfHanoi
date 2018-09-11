class TowersOfHanoi{
	//Instance Variables:
	private Tower[] towers; 
	private int numDisks; 
	
	//Constructors:
	TowersOfHanoi(int numOfLevels){
		this.numDisks = numOfLevels; 
		towers = new Tower[3]; 
		towers[0] = new Tower(numOfLevels, true); 
		towers[1] = new Tower(numOfLevels); 
		towers[2] = new Tower(numOfLevels); 
	}
	
	//Methods: 
	public Tower[] getTowers(){return this.towers;}
	public int getNumDisks(){return this.numDisks;}			
	
	public TowersOfHanoi solver(){
		this.getTowers()[0].moveStack(this.getTowers()[2], this.getTowers()[1], numDisks);
		return this;
	}
	
	@Override
	public String toString(){
		String outputString = ""; 
		outputString = this.getTowers()[0].toString() + "; " + this.getTowers()[1].toString() + "; " + this.getTowers()[2].toString(); 
		return outputString;
	}
		
}

		
		
		
			
		
		
	
	
	
	
	