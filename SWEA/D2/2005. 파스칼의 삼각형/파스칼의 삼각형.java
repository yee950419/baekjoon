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
	
	private static int T;
	private static int N;
	private static List<List<Integer>> triangle = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		
		getTriangle();
		System.out.println(sb);
	}
	
	static void getTriangle() throws IOException {
		
		//입력이 최대 10이므로 크기가 10인 삼각형 만들기
		for(int i=0; i<10; i++) {
			triangle.add(new ArrayList<>());
			triangle.get(i).add(1);
		}
		//세로 길이
		for(int i=0; i<triangle.size() - 1; i++) {
			//가로 길이
			for(int j=0; j<triangle.get(i).size() - 1; j++) {
				triangle.get(i+1).add(triangle.get(i).get(j) + triangle.get(i).get(j+1));
			}
			triangle.get(i+1).add(1);
		}
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			sb.append("#" + testCase + "\n");
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<triangle.get(i).size(); j++) {
					sb.append(triangle.get(i).get(j) + " ");
				}
				sb.append("\n");
			}
		}
	}
}