package Cricket;
import java.util.ArrayList;
public class GameSetUp {
	Team team1 = new Team();
	Team team2 = new Team();
	public GameSetUp() {
		numberOfPlayers robot = new numberOfPlayers();
		team1.team = new ArrayList<Player>(robot.returnPlayerNUmbers());
		CreatingTeam placeHolder;
		
		for(int i =0; i < robot.returnPlayerNUmbers(); i++) {
			placeHolder = new CreatingTeam();
			team1.team.add(new Player(placeHolder.playerName()));
		}
		robot = new numberOfPlayers();
		team2.team = new ArrayList<Player>(robot.returnPlayerNUmbers());
		for(int i =0; i < robot.returnPlayerNUmbers(); i++) {
			placeHolder = new CreatingTeam();
			team2.team.add(new Player(placeHolder.playerName()));
		}
		
		
	}
	
}
