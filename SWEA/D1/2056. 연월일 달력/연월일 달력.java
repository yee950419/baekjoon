import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static String date;
	private static int[] maxDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		
		getResult();
		System.out.println(sb);
	}
	
	static void getResult() throws IOException {
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			date = st.nextToken();
			
			sb.append("#" + (i + 1) + " ");
			validateDate(date);
		}
	}
	
	static void validateDate(String date) {
		String year = date.substring(0, 4);
		String month = date.substring(4, 6);
		String day = date.substring(6, 8);
		
		int monthToInt = Integer.parseInt(month);
		int dayToInt = Integer.parseInt(day);
		
		if(monthToInt < 1 || monthToInt > 12) {
			sb.append("-1\n");
		}
		else if(dayToInt > maxDay[monthToInt-1]) {
			sb.append("-1\n");
		}
		else {
			sb.append(year + "/" + month + "/" + day + "\n");
		}
	}
}