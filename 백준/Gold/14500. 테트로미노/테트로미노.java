import java.util.Scanner;

public class Main {

   public static void main(String[] args){

	   Scanner sc = new Scanner(System.in);
	   
	   int N = sc.nextInt();
	   int M = sc.nextInt();
	   int max = 0;
	   
	   int[][]nums = new int[N][M];
	   
	   for(int i=0; i<N; i++) {
		   for(int j=0; j<M; j++) {
			   nums[i][j] = sc.nextInt();
		   }
	   }
	   
	   //가로 4개일때
	   for(int i=0; i<N; i++) {
		   for(int j=0; j<M-3; j++) {
			   max = getMaxNum(max, nums[i][j] + nums[i][j+1] + nums[i][j+2] + nums[i][j+3]);
		   }
	   }
	   
	   //세로 4개일때
	   for(int i=0; i<N-3; i++) {
		   for(int j=0; j<M; j++) {
			   max = getMaxNum(max, nums[i][j] + nums[i+1][j] + nums[i+2][j] + nums[i+3][j]);
		   }
	   }

	   //세로 3개, 가로 2개일때
	   for(int i=0; i<N-2; i++) {
		   for(int j=0; j<M-1; j++) {
			   //3 1
			   max = getMaxNum(max, nums[i][j] + nums[i][j+1] + nums[i+1][j] + nums[i+2][j]);
			   max = getMaxNum(max, nums[i][j] + nums[i+1][j] + nums[i+1][j+1] + nums[i+2][j]);
			   max = getMaxNum(max, nums[i][j] + nums[i+1][j] + nums[i+2][j] + nums[i+2][j+1]);
			   //1 3
			   max = getMaxNum(max, nums[i][j] + nums[i][j+1] + nums[i+1][j+1] + nums[i+2][j+1]);
			   max = getMaxNum(max, nums[i][j+1] + nums[i+1][j] + nums[i+1][j+1] + nums[i+2][j+1]);
			   max = getMaxNum(max, nums[i][j+1] + nums[i+1][j+1] + nums[i+2][j] + nums[i+2][j+1]);
			   //2 2
			   max = getMaxNum(max, nums[i][j] + nums[i+1][j] + nums[i+1][j+1] + nums[i+2][j+1]);
			   max = getMaxNum(max, nums[i][j+1] + nums[i+1][j] + nums[i+1][j+1] + nums[i+2][j]);
		   }
	   }
	   
	   //세로 2개, 가로 3개일때
	   for(int i=0; i<N-1; i++) {
		   for(int j=0; j<M-2; j++) {
			   //2 1 1 가로가 위
			   max = getMaxNum(max, nums[i][j] + nums[i][j+1] + nums[i][j+2] + nums[i+1][j]);
			   max = getMaxNum(max, nums[i][j] + nums[i][j+1] + nums[i][j+2] + nums[i+1][j+1]);
			   max = getMaxNum(max, nums[i][j] + nums[i][j+1] + nums[i][j+2] + nums[i+1][j+2]);
			   //2 1 1 가로가 아래
			   max = getMaxNum(max, nums[i+1][j] + nums[i+1][j+1] + nums[i+1][j+2] + nums[i][j]);
			   max = getMaxNum(max, nums[i+1][j] + nums[i+1][j+1] + nums[i+1][j+2] + nums[i][j+1]);
			   max = getMaxNum(max, nums[i+1][j] + nums[i+1][j+1] + nums[i+1][j+2] + nums[i][j+2]);
			   //1 2 1
			   max = getMaxNum(max, nums[i][j+1] + nums[i][j+2] + nums[i+1][j] + nums[i+1][j+1]);
			   max = getMaxNum(max, nums[i][j] + nums[i][j+1] + nums[i+1][j+1] + nums[i+1][j+2]);
		   }
	   }
	   
	   //가로 2개, 세로 2개일때
	   for(int i=0; i<N-1; i++) {
		   for(int j=0; j<M-1; j++) {
			   max = getMaxNum(max, nums[i][j] + nums[i][j+1] + nums[i+1][j] + nums[i+1][j+1]);
		   }
	   }
	   
	   System.out.println(max);
   }
   
   public static int getMaxNum(int max, int sum) {
	   if(max < sum) {
		   return sum;
	   }
	   return max;
   }
}