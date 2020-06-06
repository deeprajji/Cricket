package Cricket;
import javax.swing.*;

public class numberOfPlayers {
JFrame F;
int number;
public numberOfPlayers() {
	F = new JFrame();
	String StringNumber = JOptionPane.showInputDialog(F,"how many players are on this team");
	number = Integer.parseInt(StringNumber);
	
}
public int returnPlayerNUmbers() {
	return number;
}
}
