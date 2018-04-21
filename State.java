import java.io.*;
import java.awt.*;
import java.util.*;

public class State{
	Character[][] map;
	Character value; //x or o
	String type;
	int utility, terminal;
	ArrayList<State> nextStates = new ArrayList<State>();
	State bestMove;
	int moveRow, moveCol;
	int depth;

	public State(Character[][] map, Character value, int depth, int moveRow, int moveCol){
		this.map = map;
		this.value = value;
		this.terminal = 0;
		this.depth = depth;
		this.moveRow = moveRow;
		this.moveCol = moveCol;
		checkTerminal();

		if(terminal == 0){
			performMinMax();
		}else{
			utility = terminal;
		}
	}

	public void checkTerminal(){ //checks if the node is in its terminal state
		Character d = checkDiagonal();
		Character v = checkVertical();
		Character h = checkHorizontal();
		if(d == 'X' || v == 'X' || h == 'X') terminal = -1;
		else if(d == 'O' || v == 'O' || h == 'O') terminal = 1;
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

	public Character[][] createNewMap(int row, int col){ //creates the instance of a next possible map
		Character[][] newMap = new Character[3][3];
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				newMap[i][j] = map[i][j];
			}
		}
		newMap[row][col] = value;
		return newMap;
	}

	public void performMinMax(){ //performs the minmax algorithm
		Character[][] dummy;
		Character newVal;
		if(value == 'X') newVal = 'O';
		else newVal = 'X';

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(map[i][j] == 'e'){
					dummy = createNewMap(i, j);
					nextStates.add(new State(dummy, newVal, (depth+1), i, j));
				}
			}
		}

		if(value == 'O') getMax();
		else{
			getMin();
		}
	}

	public void getMax(){ //if the node is max
		if(nextStates.size() != 0){			
			utility = nextStates.get(0).utility;
			bestMove = nextStates.get(0);
			State ns;
			for(int i=1; i<nextStates.size(); i++){
				ns = nextStates.get(i);
				if(utility < ns.utility) {
					utility = ns.utility;
					bestMove = ns;
				}
			}
		}else utility = 0;
	}
	public void getMin(){
		if(nextStates.size() != 0){
			utility = nextStates.get(0).utility;
			bestMove = nextStates.get(0);
			State ns;
			for(int i=1; i<nextStates.size(); i++){
				ns = nextStates.get(i);
				if(utility > ns.utility) {
					utility = ns.utility;
					bestMove = nextStates.get(i);
				}
			}
		}else utility = 0;
	}

	public void printMap(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print(map[i][j].toString() + ' ');
			}
			System.out.println();
		}
	}
}