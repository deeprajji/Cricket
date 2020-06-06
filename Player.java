package Cricket;

public class Player {
private int runs;
private int wickets;
private int runsAllowed;
private int catches;
private String name;
private double runRate;
private double economy;
private int ballsFaced;
private int ballsDealt;

public Player(String name) {
	this.name = name;
	runs = 0;
	wickets = 0;
	runsAllowed = 0;
	catches = 0;
	runRate = 0.0;
	economy = 0.0;
	ballsFaced = 0;
	ballsDealt = 0;
}
public void addRuns(int x) {
	runs+= x;
	
}
public void addBallsFaced() {
	ballsFaced++;
}
public void addBallsDealt() {
	ballsDealt++;
}
public String returnName() {
	return name;
}
public int returnRuns() {
	return runs;
}
public void addWickets(int x) {
	wickets += x;
}
public int returnWickets() {
	return wickets;
	
}
public void addRunsAllowed(int x) {
	runsAllowed+= x;
}
public int runsAllowed() {
	return runsAllowed;
}
public double returnEconomy() {
	return economy;
}
public double returnRunRate() {
	return runRate;
}
}
