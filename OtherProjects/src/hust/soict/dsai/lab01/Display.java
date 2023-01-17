import java.util.Scanner;

public class Display {
	public static void main(String[] args) {
		String monthName[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		Scanner keyboard = new Scanner(System.in);
		
		boolean checkMonthYear = true;
		
		while (checkMonthYear) {
			checkMonthYear = false;
			
			System.out.print("month: ");
			String month = keyboard.nextLine();
			
			System.out.print("year: ");
			String year = keyboard.nextLine();
			
			// Check if year is not number format => enter again
			for (int i=0; i< year.length(); i++) {
				if (year.charAt(i) < '0' || year.charAt(i) > '9') {
					checkMonthYear = true;
					break;
				}
			}
			if (checkMonthYear)  {
				System.out.println("Wrong name of year! Please enter again!");
				continue;
			}
			
			// Check number day by month and year 
			int days = 0;
			int monthDisplay = 0;
			
			for (int i = 0; i < monthName.length; i++) {
				if (month.equals(monthName[i]) || month.equals(monthName[i].substring(0,3)) || month.equals(monthName[i].substring(0,3) + ".") || month.equals(Integer.toString(i+1))) {
					monthDisplay = i + 1;
					
					switch (i + 1) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						days = 31;
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						days = 30;
						break;
					case 2:
						if (Integer.parseInt(year) % 4 == 0 && Integer.parseInt(year) % 100 != 0 || Integer.parseInt(year) % 400 == 0)  days = 29; else days = 28;
						break;
					default:
						break;
					}
					
					break;
				}
				
				if (i == 11) {
					System.out.println("Wrong name of month! Please enter again!");
					checkMonthYear = true;
					break;
				}
			}
			
			if (checkMonthYear == false) {
				System.out.println("There are " + days + " days in month " + monthDisplay + ", year " + year);
			}
		}
	   System.exit(0);
	}
}
