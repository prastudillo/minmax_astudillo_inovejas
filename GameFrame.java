import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameFrame extends JFrame{
    
    private Panel panel;

	public GameFrame(String name){
		super(name);
		this.setPreferredSize(new Dimension(650 , 650));
        this.setLayout(new BorderLayout());
 
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new Panel(this);

        this.add(panel);
        
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}