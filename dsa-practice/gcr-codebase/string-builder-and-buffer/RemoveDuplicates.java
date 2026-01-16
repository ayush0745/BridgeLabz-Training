import java.util.*; 

public class RemoveDuplicates{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder s = new StringBuilder(scanner.next());
		StringBuilder str = new StringBuilder();
		HashSet<Character> set = new HashSet<>();
		
		for( char c : s.toString().toCharArray()) {
			if(set.contains(c)) continue;
			set.add(c);
			
			str.append(c);
			
			
		}
		System.out.println(str.toString());
		
		scanner.close();
	}
}