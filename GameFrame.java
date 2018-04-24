import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameFrame extends JFrame{
    
    private Panel panel;
    private Game game;

	public GameFrame(String name){
		super(name);
		this.setPreferredSize(new Dimension(650 , 650));
        this.setLayout(new BorderLayout());
 
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new Panel(this);
        this.game = new Game(panel);
        this.panel.setGame(this.game);
        this.panel.initialize();

        this.add(panel,BorderLayout.NORTH);
        this.add(game,BorderLayout.CENTER);
        
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}