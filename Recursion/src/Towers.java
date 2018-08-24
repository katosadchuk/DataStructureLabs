import java.util.ArrayList;

public class Towers {
	int rings;
	
	public Towers(int n){
		this.rings = n;
	}
	
	public void solve(int n, String from, String middle, String to){
		if(n == 1){
			System.out.println("Move disc " + n + " from " + from + " to " + to);
		} else {
			solve(n - 1, from, to, middle);
			System.out.println("Move disc " + n + " from " + from + " to " + to);
			solve(n - 1, middle, from, to);
			
		}
	}

	public static void main(String args[]){
		Towers t = new Towers(3);
		t.solve(3, "A", "B", "C");
	}
}

/*
n = 3
A = from, B = middle, C = to

loop for n - 1 = 2 (first):
solve(2, A, C, B) so C = middle, B = to
solve(1, A, B, C) > moves 1 from A to C
prints "move 2 from A to B" -- goes back to solve(2, A, C, B)
solve(1, C, A, B) > moves disk 1 from C to B

Print: move disk 3 from A to C

Loop for n - 1 = 2 (final):
solve(2, B, A, C) so B = from, A = middle, C = to
solve(1, B, C, A) - moves A from B to A
prints "move 2 from B to C"
solve(1, A, B, C) > moves disk 1 from A to C

Done


*/