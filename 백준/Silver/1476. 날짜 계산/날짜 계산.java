import java.util.Scanner;

public class Main {

   public static void main(String[] args){

	   Scanner sc = new Scanner(System.in);
	   
	   int E = sc.nextInt();
	   int S = sc.nextInt();
	   int M = sc.nextInt();
	   int e, s, m;
	   
	   int year = 1;
	   while(true) {
		   e = year%15;
		   s = year%28;
		   m = year%19;
		   
		   if(e == 0) {
			   e = 15;
		   }
		   if(s == 0) {
			   s = 28;
		   }
		   if(m == 0) {
			   m = 19;
		   }
		   
		   if(((e == E) && (s == S)) && (m == M)) {
			   
			   System.out.println(year);
			   break;
		   }
		   year++;
	   }
   }
}
