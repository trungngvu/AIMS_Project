package hust.soict.globalict.garbage;

import java.io.FileReader;
import java.io.IOException;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
		FileReader input = null;
		long start = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		
		try {
			input = new FileReader("C:\\Users\\DELL\\eclipse-workspace\\OtherProjects\\src\\hust\\soict\\globalict\\garbage\\text.txt");
			
			int c;
			while((c = input.read()) != -1) {
				outputStringBuilder.append(c);
			}
			System.out.println(System.currentTimeMillis() - start);
		} finally {
			if (input != null) {
				input.close();
			}
		}
		System.out.println("String is: " + outputStringBuilder);
	}
}
