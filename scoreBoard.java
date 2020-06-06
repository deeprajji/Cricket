package Cricket;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class scoreBoard implements ActionListener {
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JFrame asker = new JFrame();
	int resultOfBall;
	
	
	
	int scoreboardRuns;
	NewBallGUI newBallacted;
	
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
	JLabel label;
public scoreBoard(double maxOvers, Team team1, Team team2){
	this.maxOvers = maxOvers;
	this.realteam1 = team1;
	this.realteam2 = team2;
	 label = new JLabel("Score: " + team1runs);
	JButton newBall = new JButton("New Ball");
	
	
	newBall.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			 
		String result = JOptionPane.showInputDialog(asker,"what was the result of the ball");
		
		resultOfBall = Integer.parseInt(result);
		
		}
	});
	panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
	panel.setLayout(new GridLayout(0, 1));
	panel.add(newBall);
	panel.add(label);
	
	frame.add(panel, BorderLayout.CENTER);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Our GUI");
	frame.pack(); 
	frame.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
public int returnResultOfBall() {
	return resultOfBall;
}
public int firstInnings() {
	battingTeam = realteam1;//will add coin toss
	BowlingTeam = realteam2;
	
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
		
		balls++;
		this.recalculateOvers();
		if(resultOfBall > -1) {
			team1runs += resultOfBall;
			playersOnStrike.get(0).addRuns(this.returnResultOfBall());
			playersOnStrike.get(0).addBallsFaced();
		//need to add Team Runs
			playerBowling.get(0).addRunsAllowed(this.returnResultOfBall());
			playerBowling.get(0).addBallsDealt();
			if(this.returnResultOfBall() % 2 == 0) {
				
			}
			else {
				temp = playersOnStrike.get(0);
				playersOnStrike.set(0, playersOnStrike.get(1));
				playersOnStrike.set(1, temp);
			}
		}
		else {
			outs++;
			playerBowling.get(0).addBallsDealt();
			playerBowling.get(0).addWickets(1);
			playersOnStrike.get(0).addBallsFaced();
			//add team outs
			if(counter< battingTeam.team.size()) {
				
			
			counter ++;
			playersOnStrike.set(0, battingTeam.team.get(counter));
			}
		}
	frame.repaint();	
	}
	
	
ScoreToBeat = team1runs;
	
	
	
	
	
	
	
	
	return team1runs;
}
public void recalculateOvers(){
	overs = (double)balls/6;
}
public int returnRuns() {
	return team1runs;
}
public static void main(String[] args) {
	GameSetUp x = new GameSetUp();
	
	setUpOvers y = new setUpOvers();
	scoreBoard firstTrial = new scoreBoard(y.returnMaxOvers(), x.team1, x.team2);
	System.out.print("Came back");
	firstTrial.firstInnings();
			
}
}
