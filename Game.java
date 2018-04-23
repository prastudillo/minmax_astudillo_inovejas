import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game extends JPanel{
    
    private JButton[][] buttons = new JButton[3][3];
    private Character[][] map = new Character[3][3];
    private Panel frame;

    public Game(Panel frame){
        this.frame = frame;
		this.setPreferredSize(new Dimension(650 , 550));
        this.setLayout(new GridLayout(3,3));
        this.setBackground(Color.decode("#2980b9"));  
        this.initialize();
	}

    public void initialize(){

         //Create grid of buttons for tic tac toe game
        for(int i = 0; i < 3; i++){                   
            for(int j = 0; j < 3; j++){
                
                map[i][j] = 'e';

                //Instantiating buttons 
                buttons[i][j] = new JButton();                
                buttons[i][j].setText("");
                buttons[i][j].setVisible(true);
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setEnabled(true);

                this.add(buttons[i][j]); 
                buttons[i][j].addActionListener(new myActionListener());   
            }
        }

    }
    
    public void disableButtons(){

        for(int i = 0; i < 3; i++){                   
            for(int j = 0; j < 3; j++){
                

                buttons[i][j].setVisible(true);
                buttons[i][j].setEnabled(false);


            }
        }

    }
    public void aiTurn(){
       
       try{
        State ai = new State(map, 'O', 0, -1, -1);
        int row = ai.bestMove.moveRow;
        int col = ai.bestMove.moveCol;
        map[row][col] = 'O';
        buttons[row][col].setText("O");
        buttons[row][col].setEnabled(false);
        check();
       }catch(Exception e){
    
        CardLayout c = (CardLayout) frame.getLayout();
        // this.removeAll();
        // this.initialize();
        c.show(frame,"Draw");
       }
    }

    public void check(){
        Character d = checkDiagonal();
		Character v = checkVertical();
		Character h = checkHorizontal();
		if(d == 'X' || v == 'X' || h == 'X'){
            CardLayout c = (CardLayout) frame.getLayout();
            this.disableButtons();
            // this.removeAll();
            // this.initialize();
            c.show(frame,"Win");
        }  
		else if(d == 'O' || v == 'O' || h == 'O'){
            CardLayout c = (CardLayout) frame.getLayout();
            this.disableButtons();
            // this.removeAll();
            // this.initialize();
            c.show(frame,"Lose");
        } 
        

    }

    public Character checkDiagonal(){ //checks all diagonals if there is a winner
		if( (map[0][0] != 'e') && (map[0][0] == map[1][1]) && (map[1][1] == map[2][2]) ) return map[0][0];
		else if( (map[0][2] != 'e') && (map[0][2] == map[1][1]) && (map[1][1] == map[2][0]) ) return map[0][2];
		else return 'e';
	}
	public Character checkVertical(){ //checks all verticals if there is a winner
		if( (map[0][0] != 'e') && (map[0][0] == map[1][0]) && (map[1][0] == map[2][0]) ) return map[0][0];
		else if( (map[0][1] != 'e') && (map[0][1] == map[1][1]) && (map[1][1] == map[2][1]) ) return map[0][1];
		else if( (map[0][2] != 'e') && (map[0][2] == map[1][2]) && (map[1][2] == map[2][2]) ) return map[0][2];
		else return 'e';
	}
	public Character checkHorizontal(){ //checks all horizontals if there is a winner
		if( (map[0][0] != 'e') && (map[0][0] == map[0][1]) && (map[0][1] == map[0][2]) ) return map[0][0];
		else if( (map[1][0] != 'e') && (map[1][0] == map[1][1]) && (map[1][1] == map[1][2]) ) return map[1][0];
		else if( (map[2][0] != 'e') && (map[2][0] == map[2][1]) && (map[2][1] == map[2][2]) ) return map[2][0];
		else return 'e';	
	}

    //Action Listeners
    public class myActionListener implements ActionListener{      

        public void actionPerformed(ActionEvent a) {

            if(a.getSource() == buttons[0][0]){   
                map[0][0] = 'X';              
                buttons[0][0].setText("X");
                buttons[0][0].setEnabled(false);
                aiTurn();
            } 
            else if(a.getSource() == buttons[0][1]){
                map[0][1] = 'X';
                buttons[0][1].setText("X");
                buttons[0][1].setEnabled(false);
                aiTurn();
            } 
            else if(a.getSource() == buttons[1][0]){
                map[1][0] = 'X';
                buttons[1][0].setText("X");  
                buttons[1][0].setEnabled(false);
                aiTurn();
            } 
            else if(a.getSource() == buttons[1][1]){
                map[1][1] = 'X';
                buttons[1][1].setText("X");
                buttons[1][1].setEnabled(false);
                aiTurn();
            }
            else if(a.getSource() == buttons[1][2]){
                map[1][2] = 'X';
                buttons[1][2].setText("X");
                buttons[1][2].setEnabled(false);
                aiTurn();
            } 
            else if(a.getSource() == buttons[2][2]){
                map[2][2] = 'X';
                buttons[2][2].setText("X");
                buttons[2][2].setEnabled(false);
                aiTurn();
            } 
            else if(a.getSource() == buttons[0][2]){
                map[0][2] = 'X';
                buttons[0][2].setText("X");
                buttons[0][2].setEnabled(false);
                aiTurn();
            }
            else if(a.getSource() == buttons[2][1]){
                map[2][1] = 'X';
                buttons[2][1].setText("X");
                buttons[2][1].setEnabled(false);
                aiTurn();
            }
            else if(a.getSource() == buttons[2][0]){
                map[2][0] = 'X';
                buttons[2][0].setText("X");
                buttons[2][0].setEnabled(false);
                aiTurn();
            }
            
        }
    }

}

 