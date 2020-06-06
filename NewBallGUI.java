package Cricket;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class NewBallGUI implements ActionListener {
JFrame frame = new JFrame();
JPanel panelx = new JPanel();
int result;

public NewBallGUI() {
	
	JButton dotBall = new JButton("Dot Ball");
	dotBall.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			result = 0;
		}
		
	});
	
	JButton oneRun = new JButton("1 Run");
	oneRun.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			result = 1;
			frame.dispose();
		}
		
	});
	
	JButton twoRuns = new JButton("2 runs");
	twoRuns.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			result = 2;
		}
		
	});
	
	JButton threeRuns = new JButton("3 runs");
	threeRuns.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			result = 3;
		}
		
	});
	
	JButton fourRuns = new JButton("4!");
	fourRuns.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			result =4;
		}
		
	});
	
	JButton fiveRuns = new JButton("5 Runs");
	fiveRuns.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			result = 5;
		}
		
	});
	
	JButton sixRuns = new JButton("6!");
	sixRuns.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			result = 6;
		}
		
	});
	
	JButton out = new JButton("Out!");
	out.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			result = -1;
		}
		
	});
	JLabel label = new JLabel("" + result);
	
	
	panelx.setBorder(BorderFactory.createLineBorder(Color.black));
	panelx.setLayout(new GridLayout(0, 1));
	panelx.add(dotBall);
	panelx.add(oneRun);
	panelx.add(twoRuns);
	panelx.add(threeRuns);
	panelx.add(fourRuns);
	panelx.add(fiveRuns);
	panelx.add(sixRuns);
	panelx.add(out);
	panelx.add(label);
	
	frame.add(panelx, BorderLayout.CENTER);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Our GUI");
	frame.pack(); 
	frame.setVisible(true);
}
public int returnResult() {
	return result;
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

}
