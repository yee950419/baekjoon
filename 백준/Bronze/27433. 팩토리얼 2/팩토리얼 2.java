import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;

	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		System.out.println(getFactorial(N));

	}
	
	static long getFactorial(long n) {
		
		if(n == 0) {
			return 1;
		}
		return n * getFactorial(n-1);
	}
}