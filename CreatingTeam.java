package Cricket;
import javax.swing.*;
public class CreatingTeam {
	JFrame f; 
	String Playername;
	
	public CreatingTeam(){  
	    f=new JFrame();   
	     Playername=JOptionPane.showInputDialog(f,"Enter Team 1 player Name");      
	}  
	public String playerName() {
		return Playername;
	}
	
}
