package hust.soict.dsai.lab01.garbage;
import java.io.*;

public class GarbageCreator {
	public static void main(String[] args) throws IOException {
		FileReader input = null;
		long start = System.currentTimeMillis();
		String outputString = "";
		try {
			input = new FileReader("C:\\Users\\PMT_2002\\eclipse-workspace\\OtherProjects\\src\\hust\\soict\\globalict\\garbage\\text.txt");
			
			int c;
			while((c = input.read()) != -1) {
				outputString += c;
			}
			System.out.println(System.currentTimeMillis() - start);
		} finally {
			if (input != null) {
				input.close();
			}
		}
		System.out.println("String is: " + outputString);
	}
}
