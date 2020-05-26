import java.util.*;

public class MazeRunner{
	public static Maze myMap=new Maze(); //call the maze class provided by edx course

	public static void main(String[] args){
		intro();
		String game = userMove();
		System.out.println("You win");	
	}

	public static void intro(){
		System.out.println("Welcome to Maze Runner!");
		System.out.println("Here is your current position:");
		myMap.printMap();
	}

	public static String userMove(){
		Scanner input = new Scanner(System.in);
		String dir = "";
		String pit = "";
		//might need a big while loop here
		while(!(myMap.didIWin())){
			System.out.print("Where will you like to move? (R, L, U, D) ");
			dir = input.next();
			dir = dir.toUpperCase();
			System.out.println(dir);

			while(!(dir.equals("R") || dir.equals("L") || dir.equals("U") || dir.equals("D"))){
				System.out.print("Invalid entry ");
				dir = input.next();
				dir = dir.toUpperCase();
			}

			switch(dir){
				case ("R"):	
					if(myMap.canIMoveRight()){
						myMap.moveRight();
						myMap.printMap();
					}else if(myMap.isThereAPit("R")){
						System.out.println("Watch out! There is a pit. Jump? ");
						pit = input.next();
						if(pit.equalsIgnoreCase("Y")){
							myMap.jumpOverPit("R");
							myMap.printMap();	
						}
						else{
							System.out.println("Not jumping ");
						}
					}
					else{
						System.out.println("Error! Hit a wall");
					}
					break;

				case ("L"):	
					if(myMap.canIMoveLeft()){
						myMap.moveLeft();
						myMap.printMap();
					}
					else if(myMap.isThereAPit("L")){
						System.out.println("Watch out! There is a pit. Jump? ");
						pit = input.next();
						if(pit.equalsIgnoreCase("Y")){
							myMap.jumpOverPit("L");
							myMap.printMap();
						}
						else{
							System.out.println("Not jumping ");
						}
					}
					else{
						 System.out.println("Error! Hit a wall");
					}
					break;

				case ("U"):	
					if(myMap.canIMoveUp()){
						myMap.moveUp();
						myMap.printMap();
					}else if(myMap.isThereAPit("U")){
						System.out.println("Watch out! There is a pit. Jump? ");
						pit = input.next();
						if(pit.equalsIgnoreCase("Y")){
							myMap.jumpOverPit("U");
							myMap.printMap();
						}
						else{
							System.out.println("Not jumping ");
						}
											}
					else{
						 System.out.println("Error! Hit a wall");
					}
					break;

				case ("D"):	
					if(myMap.canIMoveDown()){
						myMap.moveDown();
						myMap.printMap();
					}
					else if(myMap.isThereAPit("D")){
						System.out.println("Watch out! There is a pit. Jump? ");
						pit = input.next();
						if(pit.equalsIgnoreCase("Y")){
							myMap.jumpOverPit("D");
							myMap.printMap();
						}
						else{
							System.out.println("Not jumping ");
						}
					}
					else{
						 System.out.println("Error! Hit a wall");
					}
					break;
			}
		}
		return dir;
	}
}