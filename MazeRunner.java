import java.util.*;

public class MazeRunner{
	public static Maze myMap=new Maze(); //call the maze class provided by edx course

	public static void main(String[] args){
		intro(); //intro to maze game
		userMove(); //maze game
	}

	public static void intro(){
		System.out.println("Welcome to Maze Runner!");
		System.out.println("Here is your current position:");
		myMap.printMap();
	}

	public static void userMove(){
		Scanner input = new Scanner(System.in);
		String dir = ""; //direction from user
		String pit = ""; //yes or no for user to jump pit
		int moves = 0; //the total number of moves

		//loop dtermines if game is over
		while(!(myMap.didIWin()) && !(moves == 99)){ //did user win or did he pass the number of moves
			System.out.print("Where will you like to move? (R, L, U, D) ");
			dir = input.next(); //direction from user
			dir = dir.toUpperCase(); //uppercase the input

			//input validation
			while(!(dir.equals("R") || dir.equals("L") || dir.equals("U") || dir.equals("D"))){
				System.out.print("Invalid entry ");
				dir = input.next();
				dir = dir.toUpperCase();
			}

			//switch case for user input
			switch(dir){

				case ("R"):	//user chose right
					if(myMap.canIMoveRight()){ //is space available
						myMap.moveRight(); //move right
						myMap.printMap(); //update map
					}else if(myMap.isThereAPit("R")){ //is there a pit?
						System.out.print("Watch out! There is a pit. Jump? ");
						pit = input.next();
						if(pit.equalsIgnoreCase("Y")){ //move right if user wants to, update map
							myMap.jumpOverPit("R");
							myMap.printMap();	
						}
						else{
							System.out.println("Not jumping "); //user doesnt want to jump
							moves = moves - 1; //invalid move
						}
					}
					else{
						System.out.println("Error! Hit a wall"); //a wall was enounctered
						moves = moves - 1; //invalid move
					}
					break;

				case ("L"):	//user chose left
					if(myMap.canIMoveLeft()){ //is space available
						myMap.moveLeft(); //move left
						myMap.printMap(); //update map
					}else if(myMap.isThereAPit("L")){ //is there a pit?
						System.out.print("Watch out! There is a pit. Jump? ");
						pit = input.next();
						if(pit.equalsIgnoreCase("Y")){ //move left if user wants to, update map
							myMap.jumpOverPit("L");
							myMap.printMap();
						}
						else{
							System.out.println("Not jumping "); //user doesnt want to jump
							moves = moves - 1; //invalid move
						}
					}
					else{
						 System.out.println("Error! Hit a wall");
						 moves = moves - 1; //invalid move
					}
					break;

				case ("U"):	//user chose up
					if(myMap.canIMoveUp()){ //is space available
						myMap.moveUp(); //move up
						myMap.printMap(); //update map
					}else if(myMap.isThereAPit("U")){ //is there a pit?
						System.out.print("Watch out! There is a pit. Jump? ");
						pit = input.next();
						if(pit.equalsIgnoreCase("Y")){ //move up if user wants, update map
							myMap.jumpOverPit("U");
							myMap.printMap();
						}
						else{
							System.out.println("Not jumping "); //user doesnt want to jump
							moves = moves - 1; //invalid move
						}
					}
					else{
						 System.out.println("Error! Hit a wall");
						 moves = moves - 1; //invalid move
					}
					break;

				case ("D"):	//user chose down
					if(myMap.canIMoveDown()){ //is space available
						myMap.moveDown(); //move down
						myMap.printMap(); //update map
					}
					else if(myMap.isThereAPit("D")){ //is there a pit?
						System.out.print("Watch out! There is a pit. Jump? ");
						pit = input.next();
						if(pit.equalsIgnoreCase("Y")){ //move down if user wants, update map
							myMap.jumpOverPit("D");
							myMap.printMap();
						}
						else{
							System.out.println("Not jumping "); //user doesnt want to jump
							moves = moves - 1; //invalid move
						}
					}
					else{
						 System.out.println("Error! Hit a wall");
						 moves = moves - 1; //invalid move
					}
					break;
			}

			moves = moves + 1; //update the number of moves, stays the same if move is invalid

			if(moves < 0){ //for the beginning, if moves becasue less than 0
				moves = 0;
			}

			movesMessage(moves);
			System.out.println("***************************************************************");
		}

		if(moves == 99){
			//do nothing, function moveMessage displays loss of game
		}else{
			System.out.println("You win"); //if user won under 100 moves
		}	
	}

	//to warn user the number of moves available
	public static void movesMessage(int numberMoves){
		if(numberMoves == 50){
			System.out.println("***Warning: You have made 50 moves, you have 50 remaining before the maze exit closes***");
		}
		if(numberMoves == 75){
			System.out.println("***Alert! You have made 75 moves, you only have 25 moves left to escape***");
		}
		if(numberMoves == 90){
			System.out.println("***Danger! You have made 90 moves, you only have 10 moves left to escape***");
		}
		if(numberMoves == 99){
			System.out.println("Oh no! You took to long to escape, and now the maze exit is closed FOREVER >:[");
		}
	}
}