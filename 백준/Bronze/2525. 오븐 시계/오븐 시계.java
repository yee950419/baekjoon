import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int waiting = Integer.parseInt(br.readLine());
		
		m += waiting;
		int plusH = m/60;
		if(plusH > 0) {
			m -= (60*plusH);
			h += plusH;
			if(h >= 24) {
				h -= 24;
			}
		}
		
		System.out.println(h + " " + m);
	}
}