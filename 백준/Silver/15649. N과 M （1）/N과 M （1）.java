import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[M];
		boolean[] visit = new boolean[N];
		
		dfs(N, M, 0, arr, visit);
	}
 
	public static void dfs(int N, int M, int index, int[] arr, boolean[] visit) {

		if (index == M) {
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[index] = i + 1;
				dfs(N, M, index + 1, arr, visit);
				visit[i] = false;
			}
		}
	}
}