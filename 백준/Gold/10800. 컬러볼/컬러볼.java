import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Ball{
	int num;
	int color;
	int size;
	
	public Ball(int num, int color, int size) {
		this.num = num;
		this.color = color;
		this.size = size;
	}
}

public class Main {
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static Ball[] balls;
	static int[] colorSum;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		ans = new int[N];
		balls = new Ball[N];
		colorSum = new int[N+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			balls[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 사이즈 비교를 통한 정렬
		Arrays.sort(balls, (b1, b2) -> {
			return b1.size - b2.size;
		});
		
		int sum = 0;
		int idx = 0;
		// balls 	= 2:1:3		3:4:8 		0:1:10 		1:3:15
		// colorSum = 0			13			0			0			8
		// ans 		= 8 		21 			0  			3
		// sum		= 21
		for(int i=1; i<N; i++) {
			while(balls[idx].size < balls[i].size) {
				
				//같은 색상 제외
				sum += balls[idx].size;
				colorSum[balls[idx].color] += balls[idx].size;
				idx++;
			}
			ans[balls[i].num] = sum - colorSum[balls[i].color];
		}
		
		for(int i=0; i<N; i++) {
			sb.append(ans[i] + "\n");
		}

		System.out.println(sb);
	}
}
