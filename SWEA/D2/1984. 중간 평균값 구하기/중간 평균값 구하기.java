import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static List<Integer> list = new ArrayList<>(10);

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		testLoop();
		System.out.println(sb);
	}
	
	static void testLoop() throws IOException {
		
		int inputValue;
		int sum;
		double avg;
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<10; i++) {
				
				inputValue = Integer.parseInt(st.nextToken());
				list.add(inputValue);
			}
			
			sum = 0;
			Collections.sort(list);
			for(int i=0; i<8; i++) {
				
				sum += list.get(i+1);
			}
			
			avg = Math.round((double)sum/8);
			sb.append((int)avg + "\n");
			list.clear();
		}
	}
}