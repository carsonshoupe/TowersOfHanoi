class Disk{
	//Instance Variables: 
	private int size; 
	private int towerLevel;
		
	
	// Constructors: 
	Disk(int inputSize, int inputTowerLevel){
		this.size = inputSize;
		this.towerLevel = inputTowerLevel;
	}
	
	Disk(int inputSize){
		this.size = inputSize;
	}
	
	
	//Methods:
	public int getSize(){return this.size;}
	public int getTowerLevel(){return this.towerLevel;}	
	
	public boolean compareDiskSize(Disk smallDisk){
		if (this.getSize() > smallDisk.getSize()){
			return true; 
		}
		else{
			return false;
		}
	}
	
	@Override
	public String toString(){
		String output = "" + this.getSize(); 
		return output; 
	}
		
}
	
	