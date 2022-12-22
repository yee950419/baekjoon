import java.util.Scanner;

/*
g(10)
1			-> 1
1, 2		-> 3
1, 3		-> 4
1, 2, 4		-> 7
1, 5		-> 6
1, 2, 3, 6	-> 12
1, 7		-> 8
1, 2, 4, 8	-> 15
1, 3, 9		-> 13
1, 2, 5, 10	-> 18
*/

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		long sum = 0;
		
		for(int i=1; i<=N; i++) {
			sum = sum + i * (N/i);
		}
	
		System.out.println(sum);
	}
}
