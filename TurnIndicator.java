import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TurnIndicator extends JPanel{
    private JLabel title;
    private JButton reset;
    
	public TurnIndicator(Panel frame){

		this.setPreferredSize(new Dimension(650 , 100));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#2980b9"));

        this.title = new JLabel();
        this.title.setFont(new Font("Serif", Font.PLAIN, 20));
        this.title.setForeground(Color.white);
        this.title.setText("Tic-Tac-Toe");
        this.title.setHorizontalAlignment(JLabel.CENTER);
        this.title.setVerticalAlignment(JLabel.CENTER);


        this.add(title,BorderLayout.CENTER);
	}


}


 