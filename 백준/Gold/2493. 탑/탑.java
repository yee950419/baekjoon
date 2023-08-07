import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] tops;
	static int[] indexs;
	
	
	public static void main(String[] args) throws IOException {
		
		Stack<int[]> stack = new Stack<>();
		
		N = Integer.parseInt(br.readLine());
		tops = new int[N];
		indexs = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			
			while(!stack.isEmpty() && stack.peek()[0] < tops[i]) {
				if(stack.peek()[0] >= tops[i]) {
					indexs[i] = stack.peek()[1];
					stack.add(new int[] {tops[i], i+1});
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				stack.add(new int[] {tops[i], i+1});
			}
			else {
				indexs[i] = stack.peek()[1];
				stack.add(new int[] {tops[i], i+1});
			}
		}
		
		for(int i=0; i<indexs.length; i++) {
			sb.append(indexs[i] + " ");
		}
		
		System.out.println(sb);
	}
}
