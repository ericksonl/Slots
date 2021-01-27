import java.util.ArrayList;

/*******************************
 * Author: Liam Erickson 
 * Class: CS257 - Maggie Vanderberg - Lab 9 
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
