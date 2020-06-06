package Cricket;
import java.util.ArrayList;
import java.util.Scanner;
public class Game {
private double overs= 0;
private int balls = 0;
private int team1runs= 0;
private String result= "";
private int outs= 0;
private double runRate = 0.0;
private int projected = 0;
private int ScoreToBeat;
ArrayList<Player> playersOnStrike = new ArrayList<>();
private double maxOvers;
Team realteam1;
Team realteam2;
Team battingTeam;
Team BowlingTeam;
ArrayList<Player> playerBowling = new ArrayList<>();
public Game(double maxOvers, Team team1, Team team2)
{
this.maxOvers = maxOvers;
this.realteam1 = team1;
this.realteam2 = team2;
}



public int firstInnings() {
	battingTeam = realteam1;//will add coin toss
	BowlingTeam = realteam2;
	scoreBoard firstInningScoreBoard ;
	Player temp = new Player("temp");
	playersOnStrike.add(battingTeam.team.get(0));
	playersOnStrike.add(battingTeam.team.get(1));
	playerBowling.add(BowlingTeam.team.get(0));
	int counter = 1; 
	while(overs <= maxOvers && outs < battingTeam.team.size()) {
		if(overs%6 ==0.0) {
			//need to change bowler
			temp = playersOnStrike.get(0);
			playersOnStrike.set(0,playersOnStrike.get(1));
			playersOnStrike.set(1, temp);
		}
		//firstInningScoreBoard= new scoreBoard(team1runs);
		balls++;
		this.recalculateOvers();
		//if(firstInningScoreBoard.returnResultOfBall() > -1) {
		//	team1runs += firstInningScoreBoard.returnResultOfBall();
//			playersOnStrike.get(0).addRuns(firstInningScoreBoard.returnResultOfBall());
			playersOnStrike.get(0).addBallsFaced();
		//need to add Team Runs
//			playerBowling.get(0).addRunsAllowed(firstInningScoreBoard.returnResultOfBall());
			playerBowling.get(0).addBallsDealt();
	//		if(firstInningScoreBoard.returnResultOfBall() % 2 == 0) {
				
			}
	//		else {
				temp = playersOnStrike.get(0);
				playersOnStrike.set(0, playersOnStrike.get(1));
				playersOnStrike.set(1, temp);
//			}
//		}
	//	else {
			outs++;
			playerBowling.get(0).addBallsDealt();
			playerBowling.get(0).addWickets(1);
			playersOnStrike.get(0).addBallsFaced();
			//add team outs
			if(counter< battingTeam.team.size()) {
				
			
			counter ++;
			playersOnStrike.set(0, battingTeam.team.get(counter));
			}
	//	}
		
//	}
	
	
ScoreToBeat = team1runs;
	
	
	
	
	
	
	
	
	return team1runs;
}
public void recalculateOvers(){
	overs = (double)balls/6;
}
public int returnRuns() {
	return team1runs;
}

	
}

