import java.util.*;

public class OddsAndEvens{
	public static void main(String[] args){
		Pick();
	}

	//greet user and user's pick of even or odd
	public static void Pick(){
		Scanner input = new Scanner(System.in);
		System.out.println("Lets play a game called \"Odds and Evens\"");
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
	}
}