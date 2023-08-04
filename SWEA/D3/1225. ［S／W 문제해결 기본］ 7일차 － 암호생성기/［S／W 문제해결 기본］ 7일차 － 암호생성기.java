import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T;
	static final int SIZE = 8;
	static int[] nums = new int[SIZE];

	public static void main(String[] args) throws IOException {
		
		for(int i=0; i<10; i++) {
			
			T = Integer.parseInt(br.readLine());
			sb.append("#" + T + " ");
			st = new StringTokenizer(br.readLine());
			
			Queue<Integer> queue = new ArrayDeque<>();
			for(int j=0; j<SIZE; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int count = 1;
			int temp;
			while(true) {
				temp = queue.peek();
				queue.remove();
				queue.add(temp-count);

				if(++count == 6) {
					count = 1;
				}
				
				if(queue.peek() - count <= 0) {
					queue.remove();
					queue.add(0);
					break;
				}
			}
			
			for(int j=0; j<SIZE; j++) {
				sb.append(queue.peek()+" ");
				queue.remove();
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
