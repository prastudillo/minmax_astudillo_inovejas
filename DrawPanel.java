import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawPanel extends JPanel{
    private JLabel draw;
    private JButton reset;
    
	public DrawPanel(Panel frame){
		this.setPreferredSize(new Dimension(650 , 100));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.decode("#2980b9"));

        this.draw = new JLabel();
        this.draw.setFont(new Font("Serif", Font.PLAIN, 20));
        this.draw.setForeground(Color.white);
        this.draw.setText("Draw!");
        this.draw.setHorizontalAlignment(JLabel.CENTER);
        this.draw.setVerticalAlignment(JLabel.CENTER);

        this.reset = new JButton("Reset");
        this.reset.setPreferredSize(new Dimension(100,100));

        this.add(draw);
        this.add(reset);

        this.reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout c = (CardLayout) frame.getLayout();
                c.show(frame,"Game");
            }
        });


	}


}


 