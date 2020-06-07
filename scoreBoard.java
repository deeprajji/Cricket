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
	
	private double overs= 0;//firstInning overs
	private double secondInningOvers = 0; //second inning overs
	private int balls = 0;
	private int secondInningBalls = 0; // second inning balls
	private int team1runs= 0;
	private int team2runs = 0;
	
	private int outs= 0;
	private int secondInningOUts = 0;
	
	private int ScoreToBeat;
	private int lastBall;
	ArrayList<Player> playersOnStrike = new ArrayList<>();
	private double maxOvers;
	Team realteam1;
	Team realteam2;
	Team battingTeam;
	Team BowlingTeam;
	ArrayList<Player> playerBowling = new ArrayList<>();
	JLabel label;
	private double requiredStrikeRate;
	private int ballsLeft;
public scoreBoard(double maxOvers, Team team1, Team team2){
	this.maxOvers = maxOvers;
	this.realteam1 = team1;
	this.realteam2 = team2;
	
	 
/*	JButton newBall = new JButton("New Ball");
	
	
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
	*/
}

public void recalculateOvers(){
	overs = (double)balls/6;
}
public void recalculateSecondInningOvers() {
	secondInningOvers = (double)balls/6;
}
public static void main(String[] args) throws InterruptedException {
	settingUpGame x = new settingUpGame();
	
	setUpOvers y = new setUpOvers();
	scoreBoard firstTrial = new scoreBoard(y.returnMaxOvers(), x.team1, x.team2);
	firstTrial.battingTeam = firstTrial.realteam1;
	firstTrial.BowlingTeam = firstTrial.realteam2;
	JFrame ballResultAsker;
	while(firstTrial.overs < firstTrial.maxOvers && firstTrial.outs < firstTrial.battingTeam.team.size()) {
		ballResultAsker = new JFrame();
		String result = JOptionPane.showInputDialog(ballResultAsker,"what was the result of the ball");
		firstTrial.resultOfBall = Integer.parseInt(result);
		if(firstTrial.resultOfBall > -1 && firstTrial.resultOfBall < 7) {
			firstTrial.team1runs += firstTrial.resultOfBall;
			firstTrial.balls ++;
			firstTrial.recalculateOvers();
		}
		else {
			firstTrial.outs ++;
			firstTrial.balls++;
			firstTrial.recalculateOvers();
		}
		
		JLabel score = new JLabel("Score: " + firstTrial.team1runs + "-" + firstTrial.outs);
		JLabel numberOfOvers = new JLabel("Overs: " + firstTrial.overs);
		JFrame scoreBoard = new JFrame();
		JPanel ScoreBoardPanel = new JPanel();
		ScoreBoardPanel.setBorder(BorderFactory.createEmptyBorder(90,90,90,90));
		ScoreBoardPanel.setLayout(new GridLayout(0, 1));
		
		scoreBoard.add(ScoreBoardPanel, BorderLayout.CENTER);
		scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreBoard.setTitle("Our GUI");
		scoreBoard.pack(); 
		scoreBoard.setVisible(true);
		
		ScoreBoardPanel.add(score);
		ScoreBoardPanel.add(numberOfOvers);
		Thread.sleep(5000); // waits 5 seconds before it removes the frame and goes to the next ball
		scoreBoard.dispose();
		
	}
	firstTrial.ScoreToBeat = firstTrial.team1runs;
	firstTrial.BowlingTeam = firstTrial.realteam1;
	firstTrial.battingTeam = firstTrial.realteam2;
	while((firstTrial.secondInningOvers <= firstTrial.maxOvers) && (firstTrial.secondInningOUts<firstTrial.battingTeam.team.size()) && (firstTrial.team2runs <= firstTrial.ScoreToBeat)) {
		ballResultAsker = new JFrame();
		String result = JOptionPane.showInputDialog(ballResultAsker, "What was the result of the ball?");
		firstTrial.resultOfBall = Integer.parseInt(result);
		if(firstTrial.resultOfBall > -1 && firstTrial.resultOfBall < 7) {
			firstTrial.team2runs += firstTrial.resultOfBall;
			firstTrial.secondInningBalls++;
			firstTrial.recalculateSecondInningOvers();
		}
		else {
			firstTrial.secondInningOUts++;
			firstTrial.secondInningBalls++;
			firstTrial.recalculateSecondInningOvers();
		}
		firstTrial.ballsLeft = (int)(firstTrial.maxOvers * 6) - firstTrial.secondInningBalls;
		firstTrial.requiredStrikeRate = (double)(firstTrial.ScoreToBeat - firstTrial.team2runs)/ firstTrial.ballsLeft;
		JLabel score = new JLabel("Score: " + firstTrial.team2runs +" - " + firstTrial.secondInningOUts);
		JLabel numberOfOvers = new JLabel("Overs: " + firstTrial.secondInningOvers);
		JLabel numberOfBallsLeft = new JLabel("Number of Balls Left: " + firstTrial.ballsLeft);
		JLabel requiredStrikeRate = new JLabel("Required Strike Rate to win: " + firstTrial.requiredStrikeRate);
		JLabel whichInning = new JLabel("We are in Inning 2!");
		
		JFrame scoreBoard = new JFrame();
		JPanel ScoreBoardPanel = new JPanel();
		ScoreBoardPanel.setBorder(BorderFactory.createEmptyBorder(90,90,90,90));
		ScoreBoardPanel.setLayout(new GridLayout(0, 1));
		
		scoreBoard.add(ScoreBoardPanel, BorderLayout.CENTER);
		scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scoreBoard.setTitle("Second Inning");
		scoreBoard.pack(); 
		scoreBoard.setVisible(true);
		
		ScoreBoardPanel.add(whichInning);
		ScoreBoardPanel.add(score);
		ScoreBoardPanel.add(numberOfOvers);
		ScoreBoardPanel.add(numberOfBallsLeft);
		ScoreBoardPanel.add(requiredStrikeRate);
		Thread.sleep(5000); // waits 5 seconds before it removes the frame and goes to the next ball
		scoreBoard.dispose();
		
	}
	
	if(firstTrial.team2runs > firstTrial.ScoreToBeat) {
		JFrame winner = new JFrame();
		JPanel winnerPanel = new JPanel();
		winnerPanel.setBorder(BorderFactory.createEmptyBorder(90,90,90,90));
		winnerPanel.setLayout(new GridLayout(0, 1));
		
		winner.add(winnerPanel, BorderLayout.CENTER);
		winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winner.setTitle("Second Inning");
		winner.pack(); 
		winner.setVisible(true);
		int wicketsleft = firstTrial.realteam2.team.size()-firstTrial.secondInningOUts;
		JLabel winningTeam = new JLabel("Congratulations to the team who batted second! You have won with "+ wicketsleft + " Wickets Left!!");
		winnerPanel.add(winningTeam);
		
	}
	else if(firstTrial.team2runs < firstTrial.ScoreToBeat) {
		JFrame winner = new JFrame();
		JPanel winnerPanel = new JPanel();
		winnerPanel.setBorder(BorderFactory.createEmptyBorder(90,90,90,90));
		winnerPanel.setLayout(new GridLayout(0, 1));
		
		winner.add(winnerPanel, BorderLayout.CENTER);
		winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winner.setTitle("result");
		winner.pack(); 
		winner.setVisible(true);
		int runsLeft = firstTrial.ScoreToBeat - firstTrial.team2runs;
		JLabel winningTeam = new JLabel("Congratulations to the team that batted first! you have won by a margin of " + runsLeft +" runs!!");
		winnerPanel.add(winningTeam);
	}
	else {
		JFrame winner = new JFrame();
		JPanel winnerPanel = new JPanel();
		winnerPanel.setBorder(BorderFactory.createEmptyBorder(90,90,90,90));
		winnerPanel.setLayout(new GridLayout(0, 1));
		
		winner.add(winnerPanel, BorderLayout.CENTER);
		winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winner.setTitle("result");
		winner.pack(); 
		winner.setVisible(true);
		JLabel draw = new JLabel("Game ends in a draw, create a new game to decide the winner");
		winnerPanel.add(draw);
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
