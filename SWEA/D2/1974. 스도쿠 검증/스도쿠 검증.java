import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static int T;
	private static final int SIZE = 9;
	private static List<List<Integer>> sudoku = new ArrayList<>(SIZE);
	private static List<Integer> temp;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		loopTest();
		
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			
			int input;
			for(int i=0; i<SIZE; i++) {
				
				st = new StringTokenizer(br.readLine());
				sudoku.add(new ArrayList<>(SIZE));
				for(int j=0; j<SIZE; j++) {
					
					input = Integer.parseInt(st.nextToken());
					sudoku.get(i).add(input);
				}
			}
			
			if(validateSudoku()) {
				sb.append(1 + "\n");
			}
			else {
				sb.append(0 + "\n");
			}
			
			sudoku.clear();
		}
	}
	
	static boolean validateSudoku() {
		
		boolean isSudoku = true;
		temp = new ArrayList<>(SIZE);
		
		//가로 확인
		for(int i=0; i<SIZE; i++) {
			temp.clear();
			for(int j=0; j<SIZE; j++) {
				
				temp.add(sudoku.get(i).get(j));
			}
			
			if(!validate()) {
				isSudoku = false;
			}
		}
		
		//세로 확인
		for(int i=0; i<SIZE; i++) {
			temp.clear();
			for(int j=0; j<SIZE; j++) {
				
				temp.add(sudoku.get(j).get(i));
			}
			
			Collections.sort(temp);
			
			if(!validate()) {
				isSudoku = false;
			}
		}
		
		//격자 확인
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				
				temp.clear();
				if(!gridValidate(i, j)) {
					isSudoku = false;
				}
			}
		}
		
		
		return isSudoku;
	}
	
	static boolean validate() {
		
		Collections.sort(temp);
		for(int j=0; j<SIZE-1; j++) {
			if(temp.get(j) == temp.get(j+1)) {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean gridValidate(int column, int row) {
		
		for(int i=column*3; i<(column*3)+3; i++) {
			for(int j=row*3; j<(row*3)+3; j++) {
				temp.add(sudoku.get(i).get(j));
			}
		}
		
		if(!validate()) {
			return false;
		}
		
		return true;
	}
}