import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] costList = new int[N+1];
		boolean[] visit = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			costList[i] = Integer.parseInt(br.readLine());
		}
		
		int[] weightList = new int[M+1];
		for(int i=1; i<=M; i++) {
			weightList[i] = Integer.parseInt(br.readLine());
		}
		
		Deque<Integer> orderQ = new ArrayDeque<>();
		for(int i=0; i<M*2; i++) {
			orderQ.add(Integer.parseInt(br.readLine()));
		}
		
		Map<Integer, Integer> costMap = new HashMap<>();
		int parkCnt = 0;
		int sum = 0;
		int totalCnt = 0;
		for(int i=0; i<M*2; i++) {
			
			int order = orderQ.poll();
			
			// 차량이 들어오는 경우
			if(order > 0) {
				
				// 주차장이 다 차지 않았을 때,
				if(parkCnt < N) {
					
					for(int j=1; j<=N; j++) {
						if(!visit[j]) {
							
							sum += costList[j] * weightList[order];
							visit[j] = true;
							costMap.put(order, j);
							break;
						}
					}
					
					parkCnt++;
					totalCnt++;
				}
				
				// 주차장이 다 찼을 때,
				else {
					
					Stack<Integer> stack = new Stack<>();
					stack.add(order);
					int next = orderQ.poll();
					
					// 루프 돌면서 빠져나가는 차량을 먼저 나가게 해주고 들어오는 차량 순서 다시 큐에 채워줌
					while(next > 0) {
						stack.add(next);
						next = orderQ.poll();
					}
					
					visit[costMap.get(next*-1)] = false;
					
					while(!stack.isEmpty()) {
						orderQ.addFirst(stack.pop());
					}
					
					sum += costList[costMap.get(next*-1)] * weightList[order];
					
					orderQ.poll();
					visit[costMap.get(next*-1)] = true;
					costMap.put(order, costMap.get(next*-1));
					costMap.remove(next*-1);
					totalCnt++;
				}
			}
			
			// 차량이 빠져나가는 경우
			else {
				visit[costMap.get(order*-1)] = false;
				costMap.remove(order*-1);
				
				parkCnt--;
			}
			
			if(totalCnt >= M) {
				break;
			}
		}
		
		System.out.println(sum);
	}
}