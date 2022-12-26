import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		long fx[] = new long[1000001];
		long gx[] = new long[1000001];
		
		Arrays.fill(fx, 1);
		
		
		for(int i=2; i<fx.length; i++) {
			for(int j=1; i*j<fx.length; j++) {
				fx[i*j] += i;
			}
		}
		
		for(int i=1; i<gx.length; i++) {
			gx[i] += gx[i-1] + fx[i];
		}
		
		while(T-- > 0) {
			int input = Integer.parseInt(br.readLine());
			
			sb.append(gx[input]).append("\n");
		}
		
		System.out.println(sb);
	}
}