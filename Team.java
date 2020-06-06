package Cricket;
import java.util.ArrayList;

public class Team {
private String name;
private int outs;
private int runs;
public Team() {
	this.name = name;
	runs = 0;
	outs = 0;
}
ArrayList<Player> team = new ArrayList<Player>();

public ArrayList<Player> team() {
	return team;
}

}
