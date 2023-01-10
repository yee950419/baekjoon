import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static char[] alphabet;
	private static char[] temp;
	private static int L;
	private static int C;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[C];
		temp = new char[L];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet);
		Arrays.fill(temp, alphabet[0]);
		
		printAllCase(0, 0, 0);
	}
	
	public static void printAllCase(int consonantNum, int vowelNum, int index) {
		
		if(index == L) {
			if(consonantNum >= 2 && vowelNum >= 1) {
				if(isSorted(index)) {
					for(int i=0; i<temp.length; i++) {
						System.out.print(temp[i]);
					}
					System.out.println();
				}
			}
			return;
		}
		
		for(int i=index; i<C; i++) {
			if(isVowel(i)) {
				vowelNum++;
				temp[index] = alphabet[i];
				if(isSorted(index)) {
					printAllCase(consonantNum, vowelNum, index+1);
					vowelNum--;
				}
				else {
					vowelNum--;
					return;
				}
			}
			else if(!isVowel(i)){
				consonantNum++;
				temp[index] = alphabet[i];
				if(isSorted(index)) {
					printAllCase(consonantNum, vowelNum, index+1);
					consonantNum--;
				}
				else {
					consonantNum--;
					return;
				}
			}
		}
	}
	
	//모음인지 체크
	public static boolean isVowel(int index) {
		
		char[] vowel = new char[] {'a', 'e', 'i', 'o', 'u'};
		
		for(int i=0; i<vowel.length; i++) {
			if(alphabet[index] == vowel[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isSorted(int index) {
		for(int i=0; i<index-1; i++) {
			if(temp[i] >= temp[i+1]) {
				return false;
			}
		}
		
		return true;
	}
}