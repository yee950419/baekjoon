import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, R, C;
	static int count;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int mapSize = (int) Math.pow(2, N);
		count = 0;
		recur(mapSize, 0, 0);
	}
	
	static void recur(int size, int r, int c) {
		
		if(size == 1) {
			System.out.println(count);
			return;
		}
		
		int tempSize = size / 2;
		if(R < r + tempSize && C < c + tempSize) {
			recur(tempSize, r, c);
		}
		else if(R < r + tempSize && C >= c + tempSize) {
			count += (size * size) / 4;
			recur(tempSize, r, c+tempSize);
		}
		else if(R >= r + tempSize && C < c + tempSize) {
			count += ((size * size) / 4) * 2;
			recur(tempSize, r+tempSize, c);
		}
		else if(R >= r + tempSize && C >= c + tempSize) {
			count += ((size * size) / 4) * 3;
			recur(tempSize, r+tempSize, c+tempSize);
		}
	}
}