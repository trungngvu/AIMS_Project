	
import java.util.Scanner;

public class calculate {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("First number: ");
		String strNum1 = keyboard.nextLine();
		double num1 = Double.parseDouble(strNum1);
		
		System.out.println("Second number: ");
		String strNum2 = keyboard.nextLine();
		double num2 = Double.parseDouble(strNum2);
		
		double sum = num1 + num2;
		double dif = num1 - num2;
		double pro = num1 * num2;
		double quo = num1 / num2;
		
		System.out.println("Sum: " + sum);
		System.out.println("Dif: " + dif);
		System.out.println("Pro: " + pro);
		System.out.println("Quo: " + quo);
	}
}
