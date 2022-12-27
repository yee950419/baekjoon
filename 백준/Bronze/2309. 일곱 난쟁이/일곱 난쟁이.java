import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

   public static void main(String[] args){

	   Scanner sc = new Scanner(System.in);
	   int sum = 0;
	   ArrayList<Integer> heights = new ArrayList<>(9);
	   
	   for(int i=0; i<9; i++) {
		   heights.add(sc.nextInt());
	   }
	   
	   Collections.sort(heights);
	   
	   for(int a=0; a<3; a++) {
		   for(int b=a+1; b<4; b++) {
			   for(int c=b+1; c<5; c++) {
				   for(int d=c+1; d<6; d++) {
					   for(int e=d+1; e<7; e++) {
						   for(int f=e+1; f<8; f++) {
							   for(int g=f+1; g<9; g++) {
								   sum = heights.get(a) + heights.get(b) + heights.get(c) + 
										   heights.get(d) + heights.get(e) + heights.get(f) + heights.get(g);
								   if(sum == 100) {
									   System.out.println(heights.get(a));
									   System.out.println(heights.get(b));
									   System.out.println(heights.get(c));
									   System.out.println(heights.get(d));
									   System.out.println(heights.get(e));
									   System.out.println(heights.get(f));
									   System.out.println(heights.get(g));
									   break;
								   }
							   }
							   if(sum==100) {
								   break;
							   }
						   }
						   if(sum==100) {
							   break;
						   }
					   }
					   if(sum==100) {
						   break;
					   }
				   }
				   if(sum==100) {
					   break;
				   }
			   }
			   if(sum==100) {
				   break;
			   }
		   }
		   if(sum==100) {
			   break;
		   }
	   }
   }
}