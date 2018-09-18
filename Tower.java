import java.util.Arrays;
import java.util.Stack;

class Tower{
	//Instance Variables:
	private Stack<Disk> towerLevels; 
	private int numTowerLevels; 
	
	//Constructors: 
	Tower(int numTowerLevels){
		this(numTowerLevels, false);
	}
	
	Tower(int numTowerLevels, boolean withDisks){
		this.towerLevels = new Stack<Disk>();
		this.numTowerLevels = numTowerLevels;
		
		if (withDisks == true){
			int towLev = 0; 
			for (int counter = numTowerLevels; counter > 0; counter --){
				towerLevels.push(new Disk(counter, towLev));
				towLev++;
			}
		}
	}
	
	//Methods: 
	public Stack<Disk> getTowerLevels(){return this.towerLevels;}
	
	public Disk getTopDisk(){		
		return towerLevels.pop();
	}
			
	public void placeDisk(Disk inputDisk){
		towerLevels.push(inputDisk);
	}
	
	public void moveTopDisk(Tower receivingTower){
		receivingTower.placeDisk(this.getTopDisk()); 
		//System.out.println("Passing Tower: " + this.toString()); 
		//System.out.println("Receiving Tower: " + receivingTower.toString()); 
	}
	
	public void moveStack(Tower receivingTower, Tower helperTower, int size){		
		if (size == 0){
		}
		
		if (size >= 1){
			//System.out.println("Moving a stack of size " + size);
			moveStack(helperTower, receivingTower, size-1);
			this.moveTopDisk(receivingTower); 
			//System.out.println("Current TOH: " + this.toString() + "; " + receivingTower.toString() + "; " + helperTower.toString()); 
			helperTower.moveStack(receivingTower, this, size-1);
		}
	}
	
	@Override
	public String toString(){ 
		Object[] arr = this.towerLevels.toArray(); 
		return Arrays.toString(arr); 
	}
}
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	