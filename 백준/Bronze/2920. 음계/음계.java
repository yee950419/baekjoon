import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean isAscending = true;
        boolean isDescending = true;
        int preIdx = Integer.parseInt(st.nextToken());
        for(int i=0; i<7; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(preIdx > num) {
                isAscending = false;
            }
            else if(preIdx < num) {
                isDescending = false;
            }
            preIdx = num;

            if(!isAscending && !isDescending) {
                break;
            }
        }

        if(isAscending) {
            System.out.println("ascending");
        }
        else if(isDescending) {
            System.out.println("descending");
        }
        else if(!isAscending && !isDescending) {
            System.out.println("mixed");
        }
    }
}