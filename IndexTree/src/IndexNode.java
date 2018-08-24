import java.util.ArrayList;
import java.util.List;
public class IndexNode {

		//entry (word)
		String word;
		// The number of occurrences
		int occurences;
		// A list of line numbers for this word.
		List<Integer> list; 
		
		
		
		IndexNode left;
		IndexNode right;
		
		
		public IndexNode(String word, int line){
			this.word = word;
			list = new ArrayList<Integer>();
			list.add(line);
			occurences = 1;
		}
		
		
		
		public String toString() {
			return toString(word);
		}
		
		public String toString(String word) {
			if(word == null) {
				return "";
			} else {
				String times = "";
				for(int i = 0; i < list.size(); i++){	
					times = times + Integer.toString(list.get(i)) + " ";
				}
				return word + " occured " + Integer.toString(occurences) + " times on lines " + times;
			}
		
		}
	
}


