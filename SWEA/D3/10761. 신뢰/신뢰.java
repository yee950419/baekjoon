import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int TC;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		TC = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}

	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=TC; testCase++) {
			sb.append("#" + testCase + " ");
			
			getLeastTime();
		}
	}
	
	static void getLeastTime() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		char[] robotOrders = new char[N];
		int[] buttonPosition = new int[N];
		
		for(int i=0; i<N; i++) {
			robotOrders[i] = st.nextToken().charAt(0);
			buttonPosition[i] = Integer.parseInt(st.nextToken());
		}
		
		int positionB = 1;	//B의 현재 위치
		int positionO = 1;	//O의 현재 위치
		int leftBMoveTime = 0;	//B가 확보해 놓은 시간
		int leftOMoveTime = 0;	//O가 확보해 놓은 시간
		int index = 0;	//차례
		int time = 0;	//소요 시간
		while(index < N) {
			
			char turnOfRobot = robotOrders[index];
			int turnOfPosition = buttonPosition[index];
			
			if(turnOfRobot == 'B') {
				
				int difference = Math.abs(turnOfPosition - positionB);
				if(difference == 0 || difference <= leftBMoveTime) {
					positionB = turnOfPosition;
					leftBMoveTime = 0;
					index++;
					time++;
					leftOMoveTime++;
					continue;
				}
				else {
					if(turnOfPosition > positionB) {
						positionB++;
					}
					else {
						positionB--;
					}
					leftOMoveTime++;
				}
			}			
			else if(turnOfRobot == 'O') {
				
				int difference = Math.abs(turnOfPosition - positionO);
				if(difference == 0 || difference <= leftOMoveTime) {
					positionO = turnOfPosition;
					leftOMoveTime = 0;
					index++;
					time++;
					leftBMoveTime++;
					continue;
				}
				else {
					if(turnOfPosition > positionO) {
						positionO++;
					}
					else {
						positionO--;
					}
					leftBMoveTime++;
				}
			}
			
			time++;
		}
		
		sb.append(time + "\n");
	}
}