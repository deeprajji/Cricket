package Cricket;

import java.awt.BorderLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	private static final int SOUTH_WEST = 0;
	int clicks = 0;
	JLabel score;
	JPanel panel;
	JFrame frame;
	
	 
	public GUI()
	{
		
		 frame = new JFrame();
		 JButton newBall = new JButton("new ball");
		 newBall.addActionListener(new ActionListener() {
			 @Override
				public void actionPerformed(ActionEvent e) {
					clicks++;
					score.setText("Score:" + clicks);
				}	 
		 } 
				 );
		 
		 
		
		JButton button = new JButton("Out");
		button.addActionListener(this);
		
		 score = new JLabel("Score:");
		 JLabel scoreboard = new JLabel("Scoreboard:");
		
		 panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button); 
		panel.add(score);
		panel.add(scoreboard,BorderLayout.SOUTH);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.pack(); 
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		clicks++;
		score.setText("Score:" + clicks);
	}
	
}
