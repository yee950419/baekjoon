import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	private static final String grade[] = {"A+", "A0", "A-", "B+", "B0",
											"B-", "C+", "C0", "C-", "D0"};
	private static int T;
	private static int N, K;
	private static List<Integer> score = new ArrayList<>();
	private static List<Integer> rank = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		testLoop();
		System.out.println(sb);
	}
	
	static void testLoop() throws IOException {
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			sb.append("#" + testCase + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int midScore, finalScore, subjectScore;
			int resultScore;
			
			for(int i=0; i<N; i++) {
				
				st = new StringTokenizer(br.readLine());
				midScore = Integer.parseInt(st.nextToken());
				finalScore = Integer.parseInt(st.nextToken());
				subjectScore = Integer.parseInt(st.nextToken());
				
				resultScore = (midScore * 35) + (finalScore * 45) + (subjectScore * 20);
				score.add(resultScore);
				rank.add(0);
			}
			
			setRank();
			getGrade();
			
			score.clear();
			rank.clear();
		}
	}
	
	static void setRank() {
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
				
				if(i == j) {
					continue;
				}
				if(score.get(i) < score.get(j)) {
					rank.set(i, rank.get(i) + 1);
				}
			}
		}
	}
	
	static void getGrade() {
		
		int numPerGrade = N/10;
		int rankNum = rank.get(K-1) / numPerGrade;
		
		sb.append(grade[rankNum] + "\n");
	}
}