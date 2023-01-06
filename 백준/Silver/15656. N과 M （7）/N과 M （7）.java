import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int N, M;
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
 		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[M];
		
		ArrayList<Integer> list = new ArrayList<>(N);
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		
		dfs(N, M, 0, list);
		bw.flush();
		bw.close();
	}
 
	public static void dfs(int N, int M, int index, ArrayList<Integer> list) throws IOException {

		if (index == M) {
			for(int i=0; i<arr.length; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[index] = list.get(i);
			dfs(N, M, index + 1, list);
		}
	}
}