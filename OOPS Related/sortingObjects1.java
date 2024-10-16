import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class Main {
    
    public static class Box {
        int index;
        int value;
        
        public Box(int index, int value) {
            this.index = index;
            this.value = value;
        }
        
        @Override
        public String toString() {
            return "Index is: " + this.index + " Value is: " + this.value;
        }
    }
    
	private static void runTestCase(BufferedReader read) throws IOException {
	    
	    int[] tempArr = Stream.of(read.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	    int n = tempArr[0];
	    int k = tempArr[1];
	    
	    int[] arr = Stream.of(read.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
	    
	    PriorityQueue<Box> maxHeap = new PriorityQueue<>((Box obj1, Box obj2) -> {
	        if (obj1.value != obj2.value) {
	            return obj2.value - obj1.value;
	        } else {
	            return obj1.index - obj2.index;
	        }
	        
	        });
	        
	   int[] result = new int[n];
	   int position = 0;
	    
	    for (int index = 0; index < n; index++) {
	        int qu = arr[index] % k;
	        if (qu == 0) {
	            result[position++] = index + 1;
	        } else {
	            maxHeap.add(new Box(index, qu));
	        }
	        
	    }
	    
	    
	    
	    while (!maxHeap.isEmpty()) {
	        Box curr = maxHeap.poll();
	        result[position++] = curr.index + 1;
	    }
	    
	    for (int ele: result) {
	        System.out.print(ele + " ");
	    }
	    System.out.println();
	}

	public static void main(String[] args) throws IOException {

		// Scanner read = new Scanner(System.in);
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		// Below piece of code is just to accept input from "input.txt" and
		// to display output in "output.txt". These set of lines are not going to execute for
		// online judges like codeforces or codechef platforms.
		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				System.setOut(new PrintStream(new FileOutputStream("output.txt")));
				// read = new Scanner(new File("input.txt"));
				read = new BufferedReader(new FileReader("input.txt"));
			} catch (Exception e) {}
		}

		// int totalTestCases = read.nextInt();
		int totalTestCases = Integer.parseInt(read.readLine());
		// int totalTestCases = 1;
		for (int testCase = 0; testCase < totalTestCases; testCase++) {
			runTestCase(read);
		}

	}
}



