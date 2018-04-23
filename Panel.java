import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Panel extends JPanel{
    private TurnIndicator turnIndicator;
    private WinPanel win;
    private LosePanel lose;
    private DrawPanel draw;
    
	public Panel(GameFrame frame){
		this.setLayout(new CardLayout());
 
        
        this.turnIndicator = new TurnIndicator(this);
        this.win = new WinPanel(this);
        this.lose = new LosePanel(this);
        this.draw = new DrawPanel(this);


        // this.add(new Game(this),"Game");
        this.add(turnIndicator,"TurnIndicator");
        this.add(win,"Win");
        this.add(lose,"Lose");
        this.add(draw,"Draw");

        CardLayout c = (CardLayout) this.getLayout();

        c.show(this,"Game");


	}


}


 