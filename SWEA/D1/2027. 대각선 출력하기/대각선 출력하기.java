public class Solution {
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		getResult();
		
		System.out.println(sb);
	}
	
	static void getResult() {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i == j) {
					sb.append("#");
				}
				else {
					sb.append("+");
				}
			}
			sb.append("\n");
		}
	}	
}