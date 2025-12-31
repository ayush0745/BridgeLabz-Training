import java.util.*;
public class RotationalStringApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String s2 = scanner.next();
		if(rotationcheck(s, s2)) {
			System.out.println("Rotational");
			
		}
		else {
			System.out.println(" not rotational");
		}
		
	}
	public static boolean rotationcheck( String str1, String str2) {
		//usercase 1 length check
		if( str1.length() != str2.length()) return false;
		//concat string 1 to string 2
		String result = str1.concat(str2);
		
		if(result.contains(str2)) return true;
		
		return false;
	}

}
