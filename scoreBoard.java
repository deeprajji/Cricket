package Cricket;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

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
import javax.swing.border.Border;
public class scoreBoard implements ActionListener {
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JFrame asker = new JFrame();
	int resultOfBall;
	
	
	
	int scoreboardRuns;
	NewBallGUI newBallacted;
	
	private String overs;//firstInning overs
	private String secondInningOvers ; //second inning overs
	private int balls = 0;
	private int secondInningBalls = 0; // second inning balls
	private int team1runs= 0;
	private int team2runs = 0;
	
	private int outs= 0;
	private int secondInningOUts = 0;
	
	private int ScoreToBeat;
	private int lastBall;
	ArrayList<Player> playersOnStrike = new ArrayList<>();
	private double maxBalls;
	Team realteam1;
	Team realteam2;
	Team battingTeam;
	Team BowlingTeam;
	ArrayList<Player> playerBowling = new ArrayList<>();
	JLabel label;
	private double requiredStrikeRate;
	private int ballsLeft;
public scoreBoard(double maxOvers, Team team1, Team team2){
	this.maxBalls = maxOvers * 6;
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
	overs = "" + (balls/6) + "." + (balls%6);
}
public void recalculateSecondInningOvers() {
	secondInningOvers = "" + (secondInningBalls/6) +"."+(secondInningBalls%6);
}
public static void main(String[] args) throws InterruptedException {
	settingUpGame x = new settingUpGame();
	
	setUpOvers y = new setUpOvers();
	scoreBoard firstTrial = new scoreBoard(y.returnMaxOvers(), x.team1, x.team2);
	firstTrial.battingTeam = firstTrial.realteam1;
	firstTrial.BowlingTeam = firstTrial.realteam2;
	JFrame ballResultAsker;
	Border border = BorderFactory.createLineBorder(Color.white, 5);
	while(firstTrial.balls < firstTrial.maxBalls && firstTrial.outs < firstTrial.battingTeam.team.size()) {
		ballResultAsker = new JFrame();
		String result = JOptionPane.showInputDialog(ballResultAsker,"what was the result of the ball");
		if(result.compareTo("out") ==0|| result.compareTo("OUT")==0) {
			firstTrial.resultOfBall= -1;
		}
		else {
		firstTrial.resultOfBall = Integer.parseInt(result);
		}
		if(firstTrial.resultOfBall > -1 && firstTrial.resultOfBall < 7) {
			firstTrial.team1runs += firstTrial.resultOfBall;
			firstTrial.balls ++;
			firstTrial.recalculateOvers();
			JLabel score = new JLabel("Score: " + firstTrial.team1runs + "-" + firstTrial.outs);
			score.setBorder(border);
			score.setBackground(Color.GREEN);
			score.setOpaque(true);
			JLabel numberOfOvers = new JLabel("Overs: " + firstTrial.overs);
			numberOfOvers.setBorder(border);
			numberOfOvers.setBackground(Color.GREEN);
			numberOfOvers.setOpaque(true);
			
			JFrame scoreBoard = new JFrame();
			
			
		
			scoreBoard.setBackground(Color.pink);
			
			JPanel ScoreBoardPanel = new JPanel();
			ScoreBoardPanel.setBorder(BorderFactory.createEmptyBorder(290,290,290,290));
			ScoreBoardPanel.setLayout(new GridLayout(0, 1));
			ScoreBoardPanel.setBackground(Color.BLACK);
			
			scoreBoard.add(ScoreBoardPanel, BorderLayout.CENTER);
			scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			scoreBoard.setTitle("Our GUI");
			scoreBoard.pack(); 
			
			
			ScoreBoardPanel.add(score);
			ScoreBoardPanel.add(numberOfOvers);
			scoreBoard.setSize(1600, 1600);
			scoreBoard.setVisible(true);
			Thread.sleep(5000); // waits 5 seconds before it removes the frame and goes to the next ball
			scoreBoard.dispose();
		}
		else {
			firstTrial.outs ++;
			firstTrial.balls++;
			firstTrial.recalculateOvers();
			JLabel score = new JLabel("Score: " + firstTrial.team1runs + "-" + firstTrial.outs);
			score.setBorder(border);
			score.setBackground(Color.RED);
		
			score.setOpaque(true);
			JLabel numberOfOvers = new JLabel("Overs: " + firstTrial.overs);
			numberOfOvers.setBorder(border);
			numberOfOvers.setBackground(Color.RED);
			numberOfOvers.setOpaque(true);
			JFrame scoreBoard = new JFrame();
		
			scoreBoard.setBackground(Color.pink);
			
			JPanel ScoreBoardPanel = new JPanel();
			ScoreBoardPanel.setBorder(BorderFactory.createEmptyBorder(90,90,90,90));
			ScoreBoardPanel.setLayout(new GridLayout(0, 1));
			ScoreBoardPanel.setBackground(Color.BLACK);
			
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
		
	
		
	}
	firstTrial.ScoreToBeat = firstTrial.team1runs;
	firstTrial.BowlingTeam = firstTrial.realteam1;
	firstTrial.battingTeam = firstTrial.realteam2;
	while((firstTrial.secondInningBalls <= firstTrial.maxBalls) && (firstTrial.secondInningOUts<firstTrial.battingTeam.team.size()) && (firstTrial.team2runs <= firstTrial.ScoreToBeat))  {
		ballResultAsker = new JFrame();
		String result = JOptionPane.showInputDialog(ballResultAsker, "What was the result of the ball?");
		if(result.compareTo("out") ==0|| result.compareTo("OUT")==0) {
			firstTrial.resultOfBall= -1;
		}
		else {
		firstTrial.resultOfBall = Integer.parseInt(result);
		}
		if(firstTrial.resultOfBall > -1 && firstTrial.resultOfBall < 7) {
			firstTrial.team2runs += firstTrial.resultOfBall;
			firstTrial.secondInningBalls++;
			firstTrial.recalculateSecondInningOvers();
			
			firstTrial.ballsLeft = (int)(firstTrial.maxBalls) - firstTrial.secondInningBalls;
			firstTrial.requiredStrikeRate = (double)(firstTrial.ScoreToBeat - firstTrial.team2runs)/ firstTrial.ballsLeft;
			JLabel score = new JLabel("Score: " + firstTrial.team2runs +" - " + firstTrial.secondInningOUts);
			score.setBorder(border);
			score.setBackground(Color.GREEN);
			score.setOpaque(true);
			
			JLabel numberOfOvers = new JLabel("Overs: " + firstTrial.secondInningOvers);
			numberOfOvers.setBorder(border);
			numberOfOvers.setBackground(Color.GREEN);
			numberOfOvers.setOpaque(true);
			
			JLabel numberOfBallsLeft = new JLabel("Number of Balls Left: " + firstTrial.ballsLeft);
			numberOfBallsLeft.setBorder(border);
			numberOfBallsLeft.setBackground(Color.GREEN);
			numberOfBallsLeft.setOpaque(true);
			
			JLabel requiredStrikeRate = new JLabel("Required Strike Rate to win: " + firstTrial.requiredStrikeRate);
			requiredStrikeRate.setBorder(border);
			requiredStrikeRate.setBackground(Color.GREEN);
			requiredStrikeRate.setOpaque(true);
			
			JLabel whichInning = new JLabel("We are in Inning 2!");
			whichInning.setBorder(border);
			whichInning.setBackground(Color.LIGHT_GRAY);
			whichInning.setOpaque(true);
			
			JLabel scoreNeeded = new JLabel("Score to beat: "+ firstTrial.ScoreToBeat);
			scoreNeeded.setBorder(border);
			scoreNeeded.setBackground(Color.LIGHT_GRAY);
			scoreNeeded.setOpaque(true);
			
			
			JFrame scoreBoard = new JFrame();
			JPanel ScoreBoardPanel = new JPanel();
			ScoreBoardPanel.setBorder(BorderFactory.createEmptyBorder(90,90,90,90));
			ScoreBoardPanel.setLayout(new GridLayout(0, 1));
			ScoreBoardPanel.setBackground(Color.BLACK);
			
			scoreBoard.add(ScoreBoardPanel, BorderLayout.CENTER);
			scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			scoreBoard.setTitle("Second Inning");
			scoreBoard.pack(); 
			scoreBoard.setVisible(true);
			
			ScoreBoardPanel.add(whichInning);
			ScoreBoardPanel.add(scoreNeeded);
			ScoreBoardPanel.add(score);
			ScoreBoardPanel.add(numberOfOvers);
			ScoreBoardPanel.add(numberOfBallsLeft);
			ScoreBoardPanel.add(requiredStrikeRate);
			Thread.sleep(5000); // waits 5 seconds before it removes the frame and goes to the next ball
			scoreBoard.dispose();
			
		}
		else {
			firstTrial.secondInningOUts++;
			firstTrial.secondInningBalls++;
			firstTrial.recalculateSecondInningOvers();
			firstTrial.ballsLeft = (int)(firstTrial.maxBalls * 6) - firstTrial.secondInningBalls;
			firstTrial.requiredStrikeRate = (double)(firstTrial.ScoreToBeat - firstTrial.team2runs)/ firstTrial.ballsLeft;
			
			firstTrial.requiredStrikeRate = (double)(firstTrial.ScoreToBeat - firstTrial.team2runs)/ firstTrial.ballsLeft;
			
			JLabel score = new JLabel("Score: " + firstTrial.team2runs +" - " + firstTrial.secondInningOUts);
			score.setBorder(border);
			score.setBackground(Color.RED);
			score.setOpaque(true);
			
			JLabel numberOfOvers = new JLabel("Overs: " + firstTrial.secondInningOvers);
			numberOfOvers.setBorder(border);
			numberOfOvers.setBackground(Color.RED);
			numberOfOvers.setOpaque(true);
			
			JLabel numberOfBallsLeft = new JLabel("Number of Balls Left: " + firstTrial.ballsLeft);
			numberOfBallsLeft.setBorder(border);
			numberOfBallsLeft.setBackground(Color.RED);
			numberOfBallsLeft.setOpaque(true);
			
			JLabel requiredStrikeRate = new JLabel("Required Strike Rate to win: " + firstTrial.requiredStrikeRate);
			requiredStrikeRate.setBorder(border);
			requiredStrikeRate.setBackground(Color.RED);
			requiredStrikeRate.setOpaque(true);
			
			JLabel whichInning = new JLabel("We are in Inning 2!");
			whichInning.setBorder(border);
			whichInning.setBackground(Color.LIGHT_GRAY);
			whichInning.setOpaque(true);
			
			JFrame scoreBoard = new JFrame();
			JPanel ScoreBoardPanel = new JPanel();
			ScoreBoardPanel.setBorder(BorderFactory.createEmptyBorder(90,90,90,90));
			ScoreBoardPanel.setLayout(new GridLayout(0, 1));
			ScoreBoardPanel.setBackground(Color.BLACK);
			
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
	
	}
	
	if(firstTrial.team2runs > firstTrial.ScoreToBeat) {
		JFrame winner = new JFrame();
		JPanel winnerPanel = new JPanel();
		winnerPanel.setBorder(BorderFactory.createEmptyBorder(190,190,190,190));
		winnerPanel.setLayout(new GridLayout(0, 1));
		
		winner.add(winnerPanel, BorderLayout.CENTER);
		winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winner.setTitle("Second Inning");
		winner.pack(); 
		winner.setVisible(true);
		int wicketsleft = firstTrial.realteam2.team.size()-firstTrial.secondInningOUts;
		JLabel winningTeam = new JLabel("Congratulations to the team who batted second! You have won with "+ wicketsleft + " Wickets Left!!");
		JLabel team1scored = new JLabel("The team who batted first: " + firstTrial.team1runs + "-" + firstTrial.outs);
		JLabel team2scored = new JLabel("The team who batted second: " + firstTrial.team2runs +"-" + firstTrial.secondInningOUts);
		winnerPanel.add(winningTeam);
		winnerPanel.add(team1scored);
		winnerPanel.add(team2scored);
		
		
	}
	else if(firstTrial.team2runs < firstTrial.ScoreToBeat) {
		JFrame winner = new JFrame();
		JPanel winnerPanel = new JPanel();
		winnerPanel.setBorder(BorderFactory.createEmptyBorder(190,190,190,190));
		winnerPanel.setLayout(new GridLayout(0, 1));
		
		winner.add(winnerPanel, BorderLayout.CENTER);
		winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winner.setTitle("result");
		winner.pack(); 
		winner.setVisible(true);
		int runsLeft = firstTrial.ScoreToBeat - firstTrial.team2runs;
		JLabel winningTeam = new JLabel("Congratulations to the team that batted first! you have won by a margin of " + runsLeft +" runs!!");
		JLabel team1scored = new JLabel("The team who batted first: " + firstTrial.team1runs + "-" + firstTrial.outs);
		JLabel team2scored = new JLabel("The team who batted second: " + firstTrial.team2runs +"-" + firstTrial.secondInningOUts);
		winnerPanel.add(winningTeam);
		winnerPanel.add(team1scored);
		winnerPanel.add(team2scored);
	}
	else {
		JFrame winner = new JFrame();
		JPanel winnerPanel = new JPanel();
		winnerPanel.setBorder(BorderFactory.createEmptyBorder(190,190,190,190));
		winnerPanel.setLayout(new GridLayout(0, 1));
		
		winner.add(winnerPanel, BorderLayout.CENTER);
		winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winner.setTitle("result");
		winner.pack(); 
		winner.setVisible(true);
		JLabel draw = new JLabel("Game ends in a draw, create a new game to decide the winner");
		winnerPanel.add(draw);
		JLabel team1scored = new JLabel("The team who batted first: " + firstTrial.team1runs + "-" + firstTrial.outs);
		JLabel team2scored = new JLabel("The team who batted second: " + firstTrial.team2runs +"-" + firstTrial.secondInningOUts);
		
		winnerPanel.add(team1scored);
		winnerPanel.add(team2scored);
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
