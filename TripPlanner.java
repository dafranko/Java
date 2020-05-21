import java.util.Scanner;

public class TripPlanner{

	public static void main(String[] args) {
		Greetings();
		System.out.println();
		TravelBudget();
		System.out.println();
		TimeDifference();
		System.out.println();
		CountryArea();
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

		//to get two decimal places
		moneyPerDayUS = moneyPerDayUS * 100;
		moneyPerDayUS = (int) moneyPerDayUS;
		moneyPerDayUS = (double) moneyPerDayUS;
		moneyPerDayUS = moneyPerDayUS / 100.00;

		//to get two decimal places
		moneyInTotal = moneyInTotal * 100;
		moneyInTotal = (int) moneyInTotal;
		moneyInTotal = (double) moneyInTotal;
		moneyInTotal = moneyInTotal / 100.00;

		//to get two decimal places
		moneyPerDayDest = moneyPerDayDest * 100;
		moneyPerDayDest = (int) moneyPerDayDest;
		moneyPerDayDest = (double) moneyPerDayDest;
		moneyPerDayDest = moneyPerDayDest / 100.00;

		System.out.println("If you are travelling for "+days+" days that is the same as "+hours+" hours or "+minutes+" minutes");
		System.out.println("If you are going to spend $"+money+" USD that means per day you can spend up to $"+moneyPerDayUS+" USD");
		System.out.println("Your total budget in "+currency+" is "+moneyInTotal+" "+currency+", which per day is "+moneyPerDayDest+" "+currency);
		System.out.println("************");
	}

	//tells user the time difference
	public static void TimeDifference(){
		Scanner input = new Scanner(System.in);
		System.out.print("What is the time difference, in hours, between your home country and your destination? ");
		int hourDiff0 = input.nextInt(); //difference in hours between user home and destination from user
		int hourDiff1 = hourDiff0 % 24; //used for calculating time difference
		int hourDiff3 = hourDiff1 + 24; //if input is negative
		int hourDiff2 = hourDiff1 + 12; //if input is positive
		boolean flag = true; //for if statements
		
		if(hourDiff0 < 0){ //when input is negative
			System.out.println("That means when it is midnight at home it will be "+hourDiff3+":00 in your travel destination and when it is noon at home it will be "+hourDiff2+":00");
			flag = false;
		}

		if(hourDiff0 == 12){ //when input is 12, needed for proper format
			hourDiff2 = 0;
			System.out.println("That means when it is midnight at home it will be "+hourDiff1+":00 in your travel destination and when it is noon at home it will be 0"+hourDiff2+":00");
			flag = false;
		}

		if(hourDiff2 > 24){ //when the hour difference is greater than 24
			hourDiff2 = hourDiff2 % 24; //gets the time value after 00:00
			System.out.println("That means when it is midnight at home it will be "+hourDiff1+":00 in your travel destination and when it is noon at home it will be "+hourDiff2+":00");
			flag = false;
		}
		if(flag){
			System.out.println("That means when it is midnight at home it will be "+hourDiff1+":00 in your travel destination and when it is noon at home it will be "+hourDiff2+":00");
		}

		System.out.println("************");
	}

	//tell user destination size in miles2
	public static void CountryArea(){
		Scanner input = new Scanner(System.in);
		System.out.print("What is the square area of your destination in km2? ");
		int areaKm = input.nextInt(); //user input

		double conversion = 2.59; //conversion var for km to mi

		double areaMi = areaKm / conversion; //holds miles2

		//round to two decimals
		areaMi = areaMi * 100;
		areaMi = (int) areaMi;
		areaMi = (double) areaMi;
		areaMi = areaMi / 100.0;

		System.out.println("In miles2 that is "+areaMi);
		System.out.println("************");
	}
}