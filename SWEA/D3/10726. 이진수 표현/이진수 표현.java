import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int TC;
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		TC = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}

	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=TC; testCase++) {
			sb.append("#" + testCase + " ");
			
			getIsBitAllOneOrNot();
		}
	}
	
	static void getIsBitAllOneOrNot() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int size = 0;
		int temp = 1;
		while(M / temp != 0) {
					
			size++;
			temp *= 2;
		}
		
		String strM = "";
		for(int i=0; i<size; i++) {

			if(M >= Math.pow(2, size-1-i)) {
				strM += "1";
				M -= Math.pow(2, size-1-i);
			}
			else {
				strM += "0";
			}
		}
		
		boolean isAllOne = true;
		if(size < N) {
			sb.append("OFF\n");
		}
		else {
			for(int i=0; i<N; i++) {
				
				int idx = strM.length()-1-i;
				if(strM.charAt(idx) != '1') {
					isAllOne = false;
					break;
				}
			}
			
			if(isAllOne) {
				sb.append("ON\n");
			}
			else {
				sb.append("OFF\n");
			}
		}
	}
}