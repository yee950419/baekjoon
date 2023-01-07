import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static int N;
	private static char[][] arr;
	
	public static void main(String[] args) throws IOException {
 		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		int maxCount = 0;
		int max = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
		}
		
		max = getLeftToRightMaxCount(0) < getTopToBottomMaxCount(0) ? 
				getTopToBottomMaxCount(0) : getLeftToRightMaxCount(0);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==0) {
					swap(i, j, i+1, j);
					maxCount = getLeftToRightMaxCount(i);
					max = max < maxCount ? maxCount : max;
					maxCount = getTopToBottomMaxCount(i);
					max = max < maxCount ? maxCount : max;
					swap(i, j, i+1, j);
				}
				else if(i == N-1) {
					swap(i, j, i-1, j);
					maxCount = getLeftToRightMaxCount(i);
					max = max < maxCount ? maxCount : max;
					maxCount = getTopToBottomMaxCount(i);
					max = max < maxCount ? maxCount : max;
					swap(i, j, i-1, j);
				}
				else {
					swap(i, j, i+1, j);
					maxCount = getLeftToRightMaxCount(i);
					max = max < maxCount ? maxCount : max;
					maxCount = getTopToBottomMaxCount(i);
					max = max < maxCount ? maxCount : max;
					swap(i, j, i+1, j);
					swap(i, j, i-1, j);
					maxCount = getLeftToRightMaxCount(i);
					max = max < maxCount ? maxCount : max;
					maxCount = getTopToBottomMaxCount(i);
					max = max < maxCount ? maxCount : max;
					swap(i, j, i-1, j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==0) {
					swap(j, i, j, i+1);
					maxCount = getLeftToRightMaxCount(i);
					max = max < maxCount ? maxCount : max;
					maxCount = getTopToBottomMaxCount(i);
					max = max < maxCount ? maxCount : max;
					swap(j, i, j, i+1);
				}
				else if(i == N-1) {
					swap(j, i, j, i-1);
					maxCount = getLeftToRightMaxCount(i);
					max = max < maxCount ? maxCount : max;
					maxCount = getTopToBottomMaxCount(i);
					max = max < maxCount ? maxCount : max;
					swap(j, i, j, i-1);
				}
				else {
					swap(j, i, j, i+1);
					maxCount = getLeftToRightMaxCount(i);
					max = max < maxCount ? maxCount : max;
					maxCount = getTopToBottomMaxCount(i);
					max = max < maxCount ? maxCount : max;
					swap(j, i, j, i+1);
					swap(j, i, j, i-1);
					maxCount = getLeftToRightMaxCount(i);
					max = max < maxCount ? maxCount : max;
					maxCount = getTopToBottomMaxCount(i);
					max = max < maxCount ? maxCount : max;
					swap(j, i, j, i-1);
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static int getLeftToRightMaxCount(int index) {
		int count = 1;
		int max = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[index][i] == arr[index][i+1]) {
				count++;
			}
			else {
				count = 1;
			}
			if(count > max) {
				max = count;
			}
		}
		
		return max;
	}
	
	public static int getTopToBottomMaxCount(int index) {
		int count = 1;
		int max = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i][index] == arr[i+1][index]) {
				count++;
			}
			else {
				count = 1;
			}
			if(count > max) {
				max = count;
			}
		}
		
		return max;
	}
	
	public static void swap(int i1, int j1, int i2, int j2) {
		char temp;
		
		temp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = temp;
	}
}