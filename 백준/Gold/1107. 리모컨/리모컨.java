import java.util.Scanner;

public class Main {

   public static void main(String[] args){

	   Scanner sc = new Scanner(System.in);
	   
	   int startChannel = 100;
	   int N = sc.nextInt();
	   int brokenButtonNum = sc.nextInt();
	   char[] brokenButtons = new char[brokenButtonNum];
	   int lowCount;
	   String increaseNum;
	   int length;
	   int count;
	   
	   for(int i=0; i<brokenButtonNum; i++) {
		   brokenButtons[i] = sc.next().charAt(0);
	   }
	   
	   //+, - 만으로 가는 횟수
	   lowCount = Math.abs(N - startChannel);
	   
	   //가장 가까운 수를 구하고 +, -로 가는 횟수
	   loop : for(int i=0; i<1000000; i++) {
		   increaseNum = String.valueOf(i);
		   length = increaseNum.length();
		   
		   for(int j=0; j<brokenButtonNum; j++) {
			   for(int k=0; k<length; k++) {
				   if(increaseNum.charAt(k) == brokenButtons[j]) {
					   continue loop;
				   }
			   }
		   }
		   count = Math.abs(N-i) + length;
		   
		   if(lowCount > count) {
			   lowCount = count;
		   }
	   }
	   
	   System.out.println(lowCount);
	   
   }
}