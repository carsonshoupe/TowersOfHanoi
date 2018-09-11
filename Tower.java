import java.util.Arrays;

class Tower{
	//Instance Variables:
	private Disk[] towerLevels; 
	private int numTowerLevels; 
	
	//Constructors: 
	Tower(int numTowerLevels){
		this(numTowerLevels, false);
	}
	
	Tower(int numTowerLevels, boolean withDisks){
		this.towerLevels = new Disk[numTowerLevels];
		this.numTowerLevels = numTowerLevels;
		
		if (withDisks == true){
			int diskSizeCounter = numTowerLevels;
			for (int level = 0; level < numTowerLevels; level++){
				towerLevels[level] = new Disk(diskSizeCounter, level); 
				diskSizeCounter--; 
			}
		}
	}
	
	//Methods: 
	public Disk[] getTowerLevels(){return this.towerLevels;}
	
	public Disk getTopDisk(){
		if (towerLevels[0] == null){
			System.out.println("There are no disks on this tower");
			return null;
		}
		for (int counter = 1; counter < this.numTowerLevels; counter++){
			if (towerLevels[counter] == null){
				return towerLevels[counter-1];
			}
		}
		
		return towerLevels[this.numTowerLevels-1];
	}
			
	
	public void placeDisk(Disk inputDisk){
		if (this.towerLevels[0] == null){
			this.towerLevels[0] = inputDisk; 
		}
		else{
			for (int counter = 1; counter < towerLevels.length; counter ++){
				if (this.towerLevels[counter] == null && this.towerLevels[counter-1].compareDiskSize(inputDisk) == true){
					getTowerLevels()[counter] = inputDisk;
					break; 
				}
				
				else if (this.towerLevels[counter] == null && this.towerLevels[counter-1].compareDiskSize(inputDisk) == false){
					System.out.println("You tried to put a bigger disk on a smaller disk.  You can't do that.");
				}
					
				else if (counter == towerLevels.length){
					System.out.println("This tower already has the maximum number of disks.  You can't put another disk here"); 
				}
			}
		}
	}
	
	public void moveTopDisk(Tower receivingTower){
		receivingTower.placeDisk(this.getTopDisk());
		this.removeTopDisk(); 
		//System.out.println("Passing Tower: " + this.toString()); 
		//System.out.println("Receiving Tower: " + receivingTower.toString()); 
	}
	
	public void removeTopDisk(){
		for (int counter = numTowerLevels-1; counter >= 0; counter--){
			if (this.towerLevels[counter] instanceof Disk){
				this.towerLevels[counter] = null; 
				break;
			}
		}
	}
	
	public void moveStack(Tower receivingTower, Tower helperTower, int size){		
		if (size == 0){
			System.out.println("The stack is moved");	
		}
		
		if (size >= 1){
			System.out.println("Moving a stack of size " + size);
			moveStack(helperTower, receivingTower, size-1);
			this.moveTopDisk(receivingTower); 
			System.out.println("Current TOH: " + this.toString() + "; " + receivingTower.toString() + "; " + helperTower.toString()); 
			helperTower.moveStack(receivingTower, this, size-1);
		}
	}
	
	@Override
	public String toString(){
		return Arrays.deepToString(towerLevels); 
	}
}
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	