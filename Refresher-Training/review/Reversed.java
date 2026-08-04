import java.util.*;
public class Reversed {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		String [] str = s.split(" ");
		String [] result = new String[str.length];
		
		for( int i = 0 ; i < str.length ; i++) {
			result[i] = str[i].toLowerCase();
			result[i] = reverse(result[i]);
		}
		
		for(int l = 0 ;l < result.length ; l++) {
			System.out.println(result[l]);
		}
	}
	public static String reverse(String t) {
		char [] s = t.toCharArray();
		int i =0 ;
		int j = s.length -1;
		while(i < j) {
			char temp;
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
		return new String(s);
	}
}
