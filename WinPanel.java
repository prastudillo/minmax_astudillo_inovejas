import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class WinPanel extends JPanel{
    private JLabel win;
    private JButton reset;
    
	public WinPanel(Panel frame){
		this.setPreferredSize(new Dimension(650 , 100));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.decode("#2980b9"));

        this.win = new JLabel();
        this.win.setFont(new Font("Serif", Font.PLAIN, 20));
        this.win.setForeground(Color.white);
        this.win.setText("You Win!");
        this.win.setHorizontalAlignment(JLabel.CENTER);
        this.win.setVerticalAlignment(JLabel.CENTER);

        this.reset = new JButton("Reset");
        this.reset.setPreferredSize(new Dimension(100,100));


        this.add(win);
        this.add(reset);

        this.reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CardLayout c = (CardLayout) frame.getLayout();
                c.show(frame,"Game");
            }
        });


	}


}


 