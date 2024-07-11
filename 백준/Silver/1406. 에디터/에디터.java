import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		List<Character> linkedList = new LinkedList<>();
		ListIterator<Character> listIterator = linkedList.listIterator();

		for(int i=0; i<str.length(); i++) {
			
			listIterator.add(str.charAt(i));
		}
		
		for(int i=0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine());
			char order = st.nextToken().charAt(0);
			if(order == 'L') {
				if(listIterator.hasPrevious()) {
					listIterator.previous();					
				}
			}
			else if(order == 'D') {
				if(listIterator.hasNext()) {
					listIterator.next();
				}
			}
			else if(order == 'B') {
				if(listIterator.hasPrevious()) {
					
					listIterator.previous();
					listIterator.remove();
				}
				
			}
			else if(order == 'P') {
				listIterator.add(st.nextToken().charAt(0));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : linkedList) {
			sb.append(c);
		}
		
		System.out.println(sb);
	}
}