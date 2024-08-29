import java.util.*;
import java.io.*;

public class Main {

	private static void runTestCase(Scanner read) {
		
	}



	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		// Below piece of code is just to accept input from "input.txt" and
		// to display output in "output.txt". These set of lines are not going to execute for
		// online judges like codeforces or codechef platforms.
		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				System.setOut(new PrintStream(new FileOutputStream("output.txt")));
				read = new Scanner(new File("input.txt"));
			} catch (Exception e) {}
		}

		int totalTestCases = read.nextInt();
		// int totalTestCases = 1;
		for (int testCase = 0; testCase < totalTestCases; testCase++) {
			runTestCase(read);
		}

	}
}