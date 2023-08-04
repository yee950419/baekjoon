import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		int temp;
		while(queue.size() != 1) {
			queue.remove();
			temp = queue.poll();
			queue.add(temp);
		}
		
		System.out.println(queue.peek());
	}
}