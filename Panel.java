import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Panel extends JPanel{
    private TurnIndicator turnIndicator;
    private WinPanel win;
    private LosePanel lose;
    private DrawPanel draw;
    private Game game;

	public Panel(GameFrame frame){
		this.setLayout(new CardLayout());

    }
    
    public void initialize(){
         
        this.turnIndicator = new TurnIndicator(this);
        this.win = new WinPanel(this,this.game);
        this.lose = new LosePanel(this,this.game);
        this.draw = new DrawPanel(this,this.game);


        this.add(turnIndicator,"TurnIndicator");
        this.add(win,"Win");
        this.add(lose,"Lose");
        this.add(draw,"Draw");

        CardLayout c = (CardLayout) this.getLayout();

        c.show(this,"Game");

    }

    public void setGame(Game game){
        this.game = game;
    }

}


 