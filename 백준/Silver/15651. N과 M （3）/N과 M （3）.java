import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		arr = new int[M];
		
		dfs(N, M, 0, arr);
		bw.flush();
		bw.close();
	}
 
	public static void dfs(int N, int M, int index, int[] arr) throws IOException {

		if (index == M) {
			for(int i=0; i<arr.length; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			arr[index] = i + 1;
			dfs(N, M, index + 1, arr);
		}
	}
}