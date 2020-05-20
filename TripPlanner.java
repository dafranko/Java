import java.util.Scanner;

public class TripPlanner{

	public static void main(String[] args) {
		Greetings();
		System.out.println();
		TravelBudget();
		System.out.println();
		TimeDifference();

	}
	//greet the user, get name and destination
	public static void Greetings(){
		Scanner input = new Scanner(System.in);
		System.out.println("Wlecome to Vacation Planner!");
		System.out.print("What is your name? ");
		String name = input.next(); //user name
		System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
		String city = input.next(); //destination
		System.out.println("Great! " + city + " sounds like a great trip");
		System.out.println("************");
	}

	//get more user info: days and budget for trip
	public static void TravelBudget(){
		Scanner input = new Scanner(System.in);
		System.out.print("How many days are you going to spend travelling? ");
		int days = input.nextInt(); //number of days of trip
		System.out.print("How much money, in USD, are you planning on spending on your trip? ");
		int money = input.nextInt(); //money to be spent
		System.out.print("What is the three letter curreny symbol for your travel destination? ");
		String currency = input.next(); //currency name
		System.out.print("How many " + currency + " are there in 1 USD? ");
		double conversion = input.nextDouble(); //conversion rate for USD

		int hours = days * 24; //total hours of trip
		int minutes = hours * 60; //total minutes of trip

		double moneyPerDayUS = (double) money / days; //money per day in USD 
		double moneyInTotal = (double) money * conversion; //total money in destination currency
		double moneyPerDayDest = (double) moneyInTotal / days; //money per day in destination currency

		System.out.println("If you are travelling for "+days+" days that is the same as "+hours+" hours or "+minutes+" minutes");
		System.out.println("If you are going to spend $"+money+" USD that means per day you can spend up to $"+moneyPerDayUS+" USD");
		System.out.println("Your total budget in "+currency+" is "+moneyInTotal+" "+currency+", which per day is "+moneyPerDayDest+" "+currency);
	}

	public static void TimeDifference(){
		Scanner input = new Scanner(System.in);
		System.out.print("What is the time difference, in hours, between your home country and your destination? ");
		int hourDiff0 = input.nextInt(); //difference in hours between user home and destination
		int hourDiff1 = hourDiff0 % 24; //used for calculating time difference
		int hourDiff3 = hourDiff1 + 24; //if input is negative
		int hourDiff2 = hourDiff1 + 12; //if input is positive
		if(hourDiff0 < 0){
			//System.out.println(hourDiff1 - 12);
			System.out.println("That means when it is midnight at home it will be "+hourDiff3+":00 in your travel destination and when it is noon at home it will be "+hourDiff2+":00");

		}
		else{
			System.out.println("That means when it is midnight at home it will be "+hourDiff1+":00 in your travel destination and when it is noon at home it will be "+hourDiff2+":00");
		}

	}


}