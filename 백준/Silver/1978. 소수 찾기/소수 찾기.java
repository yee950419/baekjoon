import java.util.Scanner;

public class Main{
	public static boolean sortPrimeNum(int n) {
		boolean isPrime = true;
		
		if(n<=1) {
			isPrime = false;
		}
		if(n>2) {
			for(int i=2;i<=(int)Math.sqrt(n);i++) {
				if(n%i==0) {
					isPrime=false;
				}
			}
		}
		return isPrime;
	}
	
	public static int getPrimeNumCount(int[] array) {
		int count=0;
		
		for(int i=0;i<array.length;i++) {
			if(sortPrimeNum(array[i])==true) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] array = new int[N];
		int count;
		
		for(int i=0;i<N;i++) {
			array[i] = sc.nextInt();
		}
		count = getPrimeNumCount(array);
		System.out.println(count);
		sc.close();
	}
}