import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int moneyCount = 0;
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		getLessMoneyCount(n);
		
		System.out.println(moneyCount);
	}
	
	static void getLessMoneyCount(int n) {
		
		if(n < 5 && n%2 == 1) {
			moneyCount = -1;
			return;
		}
		
		if((n % 5) % 2 == 1) {
			moneyCount += (n/5)-1;
			n -= ((n/5) - 1) * 5;
			moneyCount += (n/2);
			n -= (n/2) * 2;
		}
		else {
			moneyCount += n/5;
			n -= (n/5) * 5;
			moneyCount += n/2;
			n -= (n/2) * 2;
		}
		
		if(n != 0) {
			moneyCount = -1;
		}
	}
}