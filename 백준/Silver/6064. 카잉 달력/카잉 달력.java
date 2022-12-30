import java.util.Scanner;

public class Main {

   public static void main(String[] args){

	   Scanner sc = new Scanner(System.in);
	
	   int T = sc.nextInt();
	   int[] result = new int[T];
	   int M, N, x, y, k;
	   boolean isSolved;
	   
	   for(int i=0; i<T; i++) {
		   M = sc.nextInt();
		   N = sc.nextInt();
		   x = sc.nextInt();
		   y = sc.nextInt();
		   isSolved = false;
		   
		   //N == y가 같을 경우 j%N 이 y가 아닌 0이 나오므로 비교를 위해
		   if(N == y) {
			   y = 0;
		   }
		   /*
		    * x가 3 일때 M이 10이면,
		    * 3, 13, 23, 33, 43
		    * x + (M*i) 식으로 증가하므로 */
		   for(int j=x; j<=M*N; j+=M) {
			   if(j%N == y) {
				   isSolved = true;
				   result[i] = j;
				   break;
			   }
		   }
		   
		   if(!isSolved) {
			   result[i] = -1;
		   }
	   }
	   
	   for(int i=0; i<T; i++) {
		   System.out.println(result[i]);
	   }
   }
}