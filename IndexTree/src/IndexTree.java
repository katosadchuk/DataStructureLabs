import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IndexTree {

	private static IndexNode root;
	private int size;
	
	public IndexTree() {
		
	}


	public void add(String word, int lineNumber){
		this.root = add(root, word, lineNumber);
		size++;
	}
	
	
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if(root == null){
			return new IndexNode(word, lineNumber);
		} else if(word.compareTo(root.word) == 0){
			root.occurences ++;
			root.list.add(lineNumber);
			return root;
		} else if(word.compareTo(root.word) < 0){
			root.left = add(root.left, word, lineNumber);
			return root;
		} else {
			root.right = add(root.right, word, lineNumber);
			return root;
		}
		
	}
	
	public boolean contains(String word) {
		return contains(this.root, word);
	}
	
	// returns true if the word is in the index
	public boolean contains(IndexNode root, String word){
		if (root == null){
			return false;
		} else if (word.compareTo(root.word) == 0){
			return true;
		} else if(word.compareTo(root.word) < 0) {
			return contains(root.left, word);
		} else {
			return contains(root.right, word);
		}

	}

	public void delete(String word){
		this.root = delete(root, word);
		size--;
		
	}

	private IndexNode delete(IndexNode root, String word){
		if(root == null){
			return root;
		} 
		if(word.compareTo(root.word) < 0){
			root.left = delete(root.left, word);
			return root;
		} else if(word.compareTo(root.word) > 0){
			root.right = delete(root.right, word);
			return root;
		} else {
			if(root.left == null){
				return root.right;
			} else if(root.right == null){
				return root.left;
			} else {
				if(root.left.right == null){
					root.word = root.left.word;
					root.left = root.left.left;
					return root;
				} else {
					root.word = findLargest(root.left);
					return root;
				}
			}
		}
	}
	
	
	
	private String findLargest(IndexNode parent) {
		if(parent.right.right == null){
			String retVal = parent.right.word;
			parent.right = parent.right.left;
			return retVal;
		} else {
			return findLargest(parent.right);
		}
	}


	public void printIndex(IndexNode root){
		 if (root == null){
			 return;
		 }
	           
	     printIndex(root.left);
	 
	     System.out.print(root.word + " " + root.occurences + " " + root.list);
	     System.out.println();
	 
	     printIndex(root.right);
		
	}

	
	public static void main(String[] args){
		IndexTree index = new IndexTree();
		String fileName = "pg100.txt";
		
		try {
			Scanner scanner = new Scanner(new File(fileName));
			int i = 1;
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] words = line.split("\\s+");
				for(String word : words){
					word = word.replaceAll("[\\W]", "");
					word = word.toLowerCase();
					index.add(word, i);
				}
				i++;
			}
			scanner.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		

		index.printIndex(root);
		
		index.delete("a");
		System.out.println(index.contains("a"));
		System.out.println(index.size);
		

		
	}
}
