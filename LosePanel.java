import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LosePanel extends JPanel{
    private JLabel lose;
    private JButton reset;
    private Game game;

	public LosePanel(Panel frame){
		this.setPreferredSize(new Dimension(650 , 100));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#2980b9"));

        this.lose = new JLabel();
        this.lose.setFont(new Font("Arial", Font.PLAIN, 50));
        this.lose.setForeground(Color.white);
        this.lose.setText("You Lose!");
        this.lose.setHorizontalAlignment(JLabel.CENTER);
        this.lose.setVerticalAlignment(JLabel.CENTER);

        this.reset = new JButton("Reset");
        this.reset.setPreferredSize(new Dimension(50,50));
        this.reset.setMargin(new Insets(0, 0, 0, 0));

        this.add(lose,BorderLayout.CENTER);
        this.add(reset,BorderLayout.LINE_END);

        this.reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout c = (CardLayout) frame.getLayout();
                c.show(frame,"TurnIndicator"); 
                game = new Game(frame);
                game.removeAll();
                game.initialize();
                // System.out.println("Hello");
            }
        });


	}


}


 