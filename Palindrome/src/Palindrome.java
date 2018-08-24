import java.util.*;

public class Palindrome {
	
	public static void main(String args[]){
		Scanner kb = new Scanner(System.in);
		Queue<Character> q = new Queue<Character>();
		Queue<Boolean> truthValues = new Queue<Boolean>();
		Stack<String> allPals = new Stack<String>();
		Stack<Character> s = new Stack<Character>();
		boolean isPal = false;
		
		System.out.println("Enter a word or quit to exit: ");
		String input = kb.nextLine();
		
		
		while(!input.equalsIgnoreCase("quit")){
			input = input.replaceAll("[\\W]", " ");
			input = input.replaceAll(" ", "");
			input = input.toLowerCase();
			for(int i = 0; i < input.length(); i ++){
				q.offer(input.charAt(i));
				s.push(input.charAt(i));
			}
			
			
			
			while(!s.empty() && !q.empty()){
				if(q.poll().equals(s.pop())){
					isPal = true;
					truthValues.offer(isPal);
				}else {
					isPal = false;
					truthValues.offer(isPal);
				}
			}
			
			while(!truthValues.empty()){
				Boolean entry = truthValues.poll();
				if(!entry){
					isPal = false;
				}
			}
			
			if(isPal){
				System.out.println("This is a palindrome.");
				allPals.push(input);
			} else {
				System.out.println("This is not a palindrome.");
			}
			
			input = kb.nextLine();
			
			
		}
		
		while(!allPals.empty()){
			System.out.println(allPals.pop());
		}
				
	}
}
