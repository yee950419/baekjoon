import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static long arr[];		// 원소를 저장하는 배열
	static long tree[];		// Segment Tree

	static long init(int node, int start, int end) {
		if(start == end) {		// 단말 노드
			return tree[node] = arr[start];		// 원소의 값을 노드에 저장한다.
		}
		else {									// 중간 노드
			// 하위 노드의 값을 더해서 저장
			int mid = (start+end) >> 1;
			int nextNode = node << 1;
			return tree[node] = init(nextNode, start, mid) + init(nextNode + 1, mid + 1, end);
		}
	}

	static long sum(int node, int start, int end, int left, long right) {
		if(left > end || right < start) {		// 구간 합을 구할 범위 밖
			return 0;
		}
		// start~end가 구간 합을 구할 범위 내에 속하는 원소
		
		// 단말 노드일때
		if(left <= start && end <= right) {
			return tree[node];
		}
		// 하위 노드의 sum값을 구한다.
		int mid = (start+end) >> 1;
		int nextNode = node << 1;
		//		왼쪽 하위 노드								오른쪽 하위 노드
		return sum(nextNode, start, mid, left, right) + sum(nextNode+1, mid+1, end, left, right);
	}

	static void update(int node, int start, int end, int index, long diff) {
		if(index < start || index > end) {	// 범위 밖에 있는 node
			return;
		}
		
		// 범위 내에 있는 node
		tree[node] += diff;		// 차이 값을 update
		
		if(start == end) {		// leaf node
			arr[index] = tree[node];
			return;
		}
		
		// 중간 노드 => 하위 노드도 변경
		int mid = (start+end) >> 1;
		int nextNode = node << 1;
		update(nextNode, start, mid, index, diff);
		update(nextNode+1, mid+1, end, index, diff);
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());		// 원소 수
		int M = Integer.parseInt(st.nextToken());		// 구간합 구할 횟수
		int K = Integer.parseInt(st.nextToken());		// update 횟수
		
		arr = new long[N];
		tree = new long[N << 2];
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		init(1, 0, N-1);
		for(int i=0, end=M+K; i<end; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(command == 1) {	// 변경
				long diff = b - arr[a-1];
				update(1, 0, N-1, a-1, diff);
			}
			else {				// sum
				bw.write(sum(1, 0, N-1, a-1, b-1) + "\n");
			}
		}
		
		br.close();
		bw.close();
	}
}