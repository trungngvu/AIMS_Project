import java.util.Scanner;
import java.lang.Math;

public class Equation {
	static void PTBN(double a, double b) {
		if (a == 0) {
			if (b == 0) {
				System.out.println("Phuong trinh vo so nghiem");
			} else {
				System.out.println("Phuong trinh vo nghiem");
			}
		} else {
			double x = -b / a;
			System.out.println("Ngiem cua phuong trinh la: " + x);
		}
	}

	static void PTBH(double a, double b, double c) {
		double delta = b * b - 4 * a * c;

		if (delta < 0) {
			System.out.println("Phuong trinh vo so nghiem");
		} else {
			if (delta == 0) {
				System.out.println("Phuong trinh co 1 nghiem kep: " + (-b / (2 * a)));
			} else {
				if (delta > 0) {
					System.out.println("Phuong trinh co 2 nghiem: " + ((-b + Math.sqrt(delta)) / (2 * a)) + " va "
							+ +((-b - Math.sqrt(delta)) / (2 * a)));
				}
			}
		}
	}

	static void HPTBN(double a, double b, double c, double d, double e, double f) {
		double aa = a / d;
		double bb = b / e;
		double cc = c / f;

		if (aa == bb) {
			if (aa != cc) {
				System.out.println("He phuong trinh vo nghiem");
			} else {
				System.out.println("He phuong trinh vo so nghiem");
			}
		} else {
			double dd = a * e - d * b;
			double d1 = c * e - f * b;
			double d2 = a * f - d * c;
			System.out.println("He phuong trinh co mot nghiem: x = " + d1 / dd + " va " + "y = " + d2 / dd);
		}
	}

	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);

		boolean checkComplete = true;

		while (checkComplete) {
			checkComplete = false;

			System.out.println("Chon phuong trinh:");
			System.out.println("1. phuong trinh bac nhat: (ax + b = 0)");
			System.out.println("2. phuong trinh bac hai: (ax^2 + bx + c = 0)");
			System.out.println("3. he phuong trinh bac nhat: (ax + by = c; dx + ey = f)");
			System.out.print("lua chon:");
			int choose = Integer.parseInt(keyboard.nextLine());

			if (choose == 1) {
				System.out.println("");
				System.out.println("ax + b = 0");
				System.out.print("a = ");
				double a = Double.parseDouble(keyboard.nextLine());
				System.out.print("b = ");
				double b = Double.parseDouble(keyboard.nextLine());

				PTBN(a, b);
			} else {
				if (choose == 2) {
					System.out.println("");
					System.out.println("ax^2 + bx + c = 0");
					System.out.print("a = ");
					double a = Double.parseDouble(keyboard.nextLine());
					System.out.print("b = ");
					double b = Double.parseDouble(keyboard.nextLine());
					System.out.print("c = ");
					double c = Double.parseDouble(keyboard.nextLine());

					PTBH(a, b, c);
				} else {
					if (choose == 3) {
						System.out.println("");
						System.out.println("ax + by = c; dx + ey = f");
						System.out.print("a = ");
						double a = Double.parseDouble(keyboard.nextLine());
						System.out.print("b = ");
						double b = Double.parseDouble(keyboard.nextLine());
						System.out.print("c = ");
						double c = Double.parseDouble(keyboard.nextLine());
						System.out.print("d = ");
						double d = Double.parseDouble(keyboard.nextLine());
						System.out.print("e = ");
						double e = Double.parseDouble(keyboard.nextLine());
						System.out.print("f = ");
						double f = Double.parseDouble(keyboard.nextLine());

						HPTBN(a, b, c, d, e, f);
					} else {
						System.out.println("Lua chon cua ban khong ton tai!!!");
						System.out.println("Lua chon lai!!!");
						System.out.println("");
						checkComplete = true;
					}
				}
			}

		}

	}
}
