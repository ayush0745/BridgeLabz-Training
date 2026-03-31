import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

class SongAlreadyExistsException extends Exception{
	public SongAlreadyExistsException(String message) {
		super(message);
	}
}
public class  MusicPlaylistManager{
	
	public static void main(String[] args) {
		
		
		LinkedList<String> songList = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		Stack<String>  stack = new Stack<>();
 		music("hh",songList,set,stack);
		music("uu",songList,set,stack);
		music("us",songList,set,stack);
		music("wu",songList,set,stack);
		
		System.out.println(getHistory(stack));
		
		
	}
	
	public static String getHistory(Stack<String> history) {
		return history.peek();
	}
public static void music(String song,LinkedList<String> songList,Set<String> set,Stack<String> stack) {
	
	try {
		if(set.contains(song)) {
			throw new SongAlreadyExistsException("song exist");
		}
		else {
			set.add(song);
			songList.addFirst(song);
			stack.push(song);
		}
	}
	catch(SongAlreadyExistsException e){
		System.out.println(e);
	}
	
}
	
}