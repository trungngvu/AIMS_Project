import java.util.Scanner;

public class mainTriangle {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);

		int numberStar = -1;

		System.out.println("Enter n star");
		while (numberStar < 0) {
			System.out.print("n =  ");
			numberStar = keyboard.nextInt();

			if (numberStar < 0) {
				System.out.println("Wrong, please type again!!!");
			}
		}

		for (int i = 0; i < numberStar; i++) {
			for (int j = 1; j < numberStar * 2; j++) {
				if (j >= numberStar - i && j <= numberStar + i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}

	}
}
