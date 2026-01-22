
import java.util.*;

public class WordFrequencyCounter {

	public static Map<String, Integer> countWords(String text) {
		text = text.toLowerCase().replaceAll("\\W+", " ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : text.split(" ")) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		return map;
	}

	public static void main(String[] args) {
		
		String text = "Hello world, hello Java!";
		System.out.println(countWords(text));
	}

}
