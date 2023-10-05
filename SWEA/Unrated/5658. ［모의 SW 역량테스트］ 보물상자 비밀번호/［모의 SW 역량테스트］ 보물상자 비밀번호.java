import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static int N, K;
	static Queue<Character> q = new LinkedList<>();
	static TreeSet<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		loopTest();
		System.out.println(sb);
	}
	
	static void loopTest() throws IOException {
		
		for(int tc=1; tc<=T; tc++) {
			sb.append("#" + tc + " ");
			
			getResult();
			
		}
	}
	
	static void getResult() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new TreeSet<>(Collections.reverseOrder());
		String str = br.readLine();
		for(int i=0; i<N; i++) {
			q.offer(str.charAt(i));
		}
		
		int rotate = N/4;
		for(int k=0; k<rotate; k++) {
			
			for(int i=0; i<4; i++) {
				
				String temp = "";
				for(int j=i*rotate; j<(N/4)*(i+1); j++) {
					char ch = q.poll();
					temp += ch;
					q.offer(ch);
				}
				
				int decimal = Integer.parseInt(temp, 16);
				list.add(decimal);
			}
			
			char ch = q.poll();
			q.offer(ch);
		}
		
		int cnt = 1;
		for(int n : list) {
			if(cnt++ == K) {
				sb.append(n + "\n");
			}
		}
		
		q.clear();
		list.clear();
	}
}
