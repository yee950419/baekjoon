import java.util.Scanner;

public class Main {

   public static void main(String[] args){

	   Scanner sc = new Scanner(System.in);
	
	   int N = sc.nextInt();
	   String str = String.valueOf(N);
	   int len = str.length();
	   int sum = 0;
	   
	   for(int i=1; i<len; i++) {
		   sum += 9 * i * Math.pow(10, i-1);
	   }
	   
	   sum += (N - (Math.pow(10, len-1)) + 1) * len;
	   
	   System.out.println(sum);
   }
}