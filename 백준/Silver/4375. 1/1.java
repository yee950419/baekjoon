import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		long i;
		int index;
		
		while(sc.hasNextInt()) {
			n = sc.nextInt();
			i = 1;
			index = 1;
			
			if(n < 1 || n > 10000) {
				System.out.println("1~10000 사이의 수를 입력하시오.");
			}
			
			if(n % 2 == 0 || n % 5 == 0) {
				System.out.println("error");
			}
			else {
				while(true) {
					if(i % n == 0) {
						System.out.println(index);
						break;
					} else {
						i = (i*10 + 1) % n;
						index++;
					}
				}
			}	
		}
	}
}