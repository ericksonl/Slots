/*******************************
 * Author: Liam Erickson 
 * Date: March 13, 2020
 ********************************/

public class Casino {
	
	private String casinoName;
	SlotMachine SlotMachine = new SlotMachine();
	
	public Casino(String casinoName) {
		this.casinoName = casinoName;
	}
	
	public String getCasinoName() {return casinoName;}
	
}
