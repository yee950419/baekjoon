import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		int num = 0;
		for(int i=0; i<N; i++) {
			
			num = Integer.parseInt(st.nextToken());
			if(map.get(num) == null) {
				map.put(num, 1);
			}
			else {
				map.put(num, map.get(num)+1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			
			num = Integer.parseInt(st.nextToken());
			sb.append(map.get(num) != null ? map.get(num) : 0).append(" ");
		}
		
		System.out.println(sb);
	}
}