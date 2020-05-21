import java.util.*;

public class OddsAndEvens{
	public static void main(String[] args){
		Game();
	}

	//method has the entire game
	public static void Game(){
		Scanner input = new Scanner(System.in); //nwe Scanner
		System.out.println("Let's play a game called \"Odds and Evens\"");
		System.out.print("What is your name? ");
		String name = input.next(); //get user's name
		System.out.print("Hi "+name+", which fo you choose? (O)dds or (E)vens ");
		String choice = input.next(); //get user choice

		while(!(choice.equals("O")) && !(choice.equals("E"))){ //if input is invalid
			System.out.print("Invalid entry! Try again ");
			choice = input.next();
		}

		if(choice.equals("O")){
			System.out.println(name+" has picked odds! The computer will be evens.");
		}

		if(choice.equals("E")){
			System.out.println(name+" has picked evens! The computer will be odds.");
		}

		System.out.println("---------------------------------------");

		System.out.println();

		System.out.print("How many \"fingers\" do you put out? ");
		int userFingers = input.nextInt(); //# of fingers user will use

		while(userFingers < 0 || userFingers > 5){ //if input is invalid
			System.out.print("Invalid entry! Try again ");
			userFingers = input.nextInt();
		}

		Random rand = new Random(); //new random
		int computer = rand.nextInt(6); //get random number of fingers
		System.out.println("The computer plays "+computer+" \"fingers\"");
		System.out.println("----------------------------------------");

		System.out.println();

		int sum = userFingers + computer;
		System.out.println(userFingers+" + "+computer+" = "+sum);

		boolean decision = sum % 2 == 0;

		if(decision){ //if even
			if(choice.equals("E")){
				System.out.println(sum+" is ...even!");
				System.out.println("That means "+name+" wins! :)");
			}else{
				System.out.println(sum+" is ...even!");
				System.out.println("That means the computer wins! :(");
			}
		}else{
			if(choice.equals("O")){
				System.out.println(sum+" is ...odd!");
				System.out.println("That means "+name+" wins! :)");	
			}else{
				System.out.println(sum+" is ...odd!");
				System.out.println("That means the computer wins! :(");
			}
		}
	}
}