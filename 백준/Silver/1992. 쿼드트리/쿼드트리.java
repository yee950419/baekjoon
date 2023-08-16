import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int map[][];
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		getResult(0, 0, N);
		
		System.out.println(sb);
	}
	
	static void getResult(int x, int y, int size) {
		
		if(isZipAvailable(x, y, size)) {
			sb.append(map[x][y]);
			return;
		}
		
		sb.append("(");
		size /= 2;
		
		getResult(x, y, size);
		getResult(x, y+size, size);
		getResult(x+size, y, size);
		getResult(x+size, y+size, size);
		
		sb.append(")");
	}
	
	static boolean isZipAvailable(int x, int y, int size) {
		
		int temp = map[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(temp != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}