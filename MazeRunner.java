import java.util.*;

public class MazeRunner{
	public static Maze myMap=new Maze(); //call the maze class provided by edx course

	public static void main(String[] args){
		intro();
		String game = userMove();
		System.out.println(game);	
	}

	public static void intro(){
		System.out.println("Welcome to Maze Runner!");
		System.out.println("Here is your current position:");
		myMap.printMap();
	}

	public static String userMove(){
		Scanner input = new Scanner(System.in);
		System.out.print("Where will you like to move? (R, L, U, D) ");
		String ch = input.next();
		ch = ch.toUpperCase();
		System.out.println(ch);
		while(!(ch.equals("R") || ch.equals("L") || ch.equals("U") || ch.equals("D"))){
			System.out.print("Invalid entry ");
			ch = input.next();
			ch = ch.toUpperCase();
		}
		return ch;
	}
}