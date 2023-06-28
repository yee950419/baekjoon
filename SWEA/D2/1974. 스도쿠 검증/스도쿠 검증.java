import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static final int SIZE = 9;
	private static int T;
	private static int[][] sudoku = new int[SIZE][SIZE];
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			getIsSudokuComplete();
		}
	}

	static void getIsSudokuComplete() throws IOException {
		
		for(int i=0; i<SIZE; i++) {
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<SIZE; j++) {
				
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(isComplete()) {
			sb.append(1 + "\n");
		}
		else {
			sb.append(0 + "\n");
		}
	}
	
	static boolean isComplete() {
		
		Set<Integer> nums = new HashSet<>();
		
		//가로 방향 확인
		for(int i=0; i<SIZE; i++) {
			
			for(int j=0; j<SIZE; j++) {
				
				nums.add(sudoku[i][j]);
			}
			
			if(nums.size() != SIZE) {
				
				return false;
			}
			nums.clear();
		}
		
		//세로 방향 확인
		for(int i=0; i<SIZE; i++) {
			
			for(int j=0; j<SIZE; j++) {
				
				nums.add(sudoku[j][i]);
			}
			
			if(nums.size() != SIZE) {
				
				return false;
			}
			nums.clear();
		}
		
		//3X3 격자 확인
		for(int i=0; i<3; i++) {
			if(!validate3X3Vertical(i*3, SIZE/3 * (i+1))) {
				
				return false;
			}
		}
		
		return true;
	}
	
	static boolean validate3X3Vertical(int start, int end) {
		
		for(int i=0; i<3; i++) {
			
			for(int j=start; j<end; j++) {
				if(!validate3X3Horizontal(start, end, i*3, SIZE/3 * (i+1))) {
					
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean validate3X3Horizontal(int startI, int endI, int startJ, int endJ) {
		
		Set<Integer> nums = new HashSet<>();
		
		for(int i=startI; i<endI; i++) {
		
			for(int j=startJ; j<endJ; j++) {
				nums.add(sudoku[i][j]);
			}
		}
		
		if(nums.size() != SIZE) {
			
			return false;
		}
		
		return true;
	}
}