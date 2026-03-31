import java.util.*;

public class ConcatenatesStrings{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String [] arr = new String[] {"ayush","rathour"};
		
		StringBuffer str = new StringBuffer();
		for(String s : arr) {
			
			str.append(s);
		}
		System.out.println(str.toString());
		scanner.close();
	}
}