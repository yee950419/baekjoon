import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int highestCommonFactor = 1;
		int smallestCommonMultiple = 1;
		int i = 2;
		
		while(num1 != 1 || num2 != 1) {
			if(num1 % i == 0 && num2 % i == 0) {
				highestCommonFactor *= i;
				smallestCommonMultiple *= i;
				num1 /= i;
				num2 /= i;
			} else if(num1 % i == 0 && num2 % i != 0) {
				smallestCommonMultiple *= i;
				num1 /= i;
			} else if(num1 % i != 0 && num2 % i == 0){
				smallestCommonMultiple *= i;
				num2 /= i;
			} else {
				i++;
			}
		}
		System.out.println(highestCommonFactor);
		System.out.println(smallestCommonMultiple);
	}
}