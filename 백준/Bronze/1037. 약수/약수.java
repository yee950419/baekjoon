import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int biggest;
		int smallest;
		
		if(size > 50) {
			System.out.println("50보다 작거나 같아야 합니다.");
		}
		
		int[] factors = new int[size];
		
		for(int i=0; i<size; i++) {
			factors[i] = sc.nextInt();
		}
		
		
		
		System.out.println(getFactors(factors, size));
	}
	
	public static int getFactors(int[] factors, int size) {
		int smallest = factors[0];
		int biggest = factors[0];
		
		for(int i=0; i<size-1; i++) {
			if(biggest < factors[i+1]) {
				biggest = factors[i+1];
			}
			if(smallest > factors[i+1]) {
				smallest = factors[i+1];
			}
		}
		
		return smallest * biggest;
	}

}