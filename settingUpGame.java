package Cricket;
import java.util.ArrayList;
public class settingUpGame {
	
	
	
		Team team1 = new Team();
		Team team2 = new Team();
		public settingUpGame() {
			numberOfPlayers temp = new numberOfPlayers();
			team1.team = new ArrayList<Player>(temp.returnPlayerNUmbers());
			CreatingTeam placeHolder;
			
			for(int i =0; i < temp.returnPlayerNUmbers(); i++) {
				placeHolder = new CreatingTeam();
				team1.team.add(new Player(placeHolder.playerName()));
			}
			temp = new numberOfPlayers();
			team2.team = new ArrayList<Player>(temp.returnPlayerNUmbers());
			for(int i =0; i < temp.returnPlayerNUmbers(); i++) {
				placeHolder = new CreatingTeam();
				team2.team.add(new Player(placeHolder.playerName()));
			}
			
			
		}
		
	}


