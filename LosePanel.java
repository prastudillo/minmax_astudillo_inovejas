import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LosePanel extends JPanel{
    private JLabel lose;
    private JButton reset;
    
	public LosePanel(Panel frame){
		this.setPreferredSize(new Dimension(650 , 100));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.decode("#2980b9"));

        this.lose = new JLabel();
        this.lose.setFont(new Font("Serif", Font.PLAIN, 20));
        this.lose.setForeground(Color.white);
        this.lose.setText("You Lose!");
        this.lose.setHorizontalAlignment(JLabel.CENTER);
        this.lose.setVerticalAlignment(JLabel.CENTER);

        this.reset = new JButton("Reset");
        this.reset.setPreferredSize(new Dimension(100,100));

        this.add(lose);
        this.add(reset);

        this.reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout c = (CardLayout) frame.getLayout();
                c.show(frame,"Game");
            }
        });


	}


}


 