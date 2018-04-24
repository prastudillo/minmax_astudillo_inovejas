import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WinPanel extends JPanel{
    private JLabel win;
    private JButton reset;
    private Game game;
    
	public WinPanel(Panel frame, Game game){
        this.game = game;
		this.setPreferredSize(new Dimension(650 , 100));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#2980b9"));

        this.win = new JLabel();
        this.win.setFont(new Font("Arial", Font.PLAIN, 50));
        this.win.setForeground(Color.white);
        this.win.setText("You Win!");
        this.win.setHorizontalAlignment(JLabel.CENTER);
        this.win.setVerticalAlignment(JLabel.CENTER);

        this.reset = new JButton("Reset");
        this.reset.setPreferredSize(new Dimension(100,50));


        this.add(win,BorderLayout.CENTER);
        this.add(reset,BorderLayout.LINE_END);

        this.reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout c = (CardLayout) frame.getLayout();
                c.show(frame,"TurnIndicator");
                game.removeAll();
                game.initialize();
            }
        });


	}


}


 