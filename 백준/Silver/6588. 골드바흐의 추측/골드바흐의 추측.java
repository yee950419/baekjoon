import java.util.Scanner;

public class Main{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int n = 1;
		
		while(n != 0) {
			
			n = sc.nextInt();
			
			for(int i=3; i<=n/2; i++) {
				if(isPrime(i) && isPrime(n-i)) {
					System.out.println(n + " = " + i + " + " + (n-i));
					break;
				}
			}
		}
		
	}
	
	public static boolean isPrime(int n) {
		
		for(int i=2; i*i<=n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}