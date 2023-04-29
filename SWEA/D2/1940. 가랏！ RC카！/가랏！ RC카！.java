import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			getDistance();
		}
	}
	
	static void getDistance() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int distance = 0;
		int velocity = 0;
		int command;
		int change = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			command = Integer.parseInt(st.nextToken());
			
			if(command == 0) {
				distance += velocity;
			}
			else {
				change = Integer.parseInt(st.nextToken());
				
				if(command == 1) {
					velocity += change;
				}
				else if(command == 2) {
					velocity -= change;
					
					if(velocity < 0) {
						velocity = 0;
					}
				}
				
				distance += velocity;
			}
		}
		
		sb.append(distance + "\n");
	}
}