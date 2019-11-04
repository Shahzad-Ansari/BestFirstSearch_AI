import java.util.LinkedList;


public class node {
	
	LinkedList<node> children = new LinkedList<node>();
	node parent;
	
	int[] puzzle = new int[9];
	int x = 0; 
	int col = 3;
	int row = 3;
	int depth ;
	public int heuristic;
	public int Fcost;
	
	
	////////////////////////////////////////////////////
	public node(int[] p) {
		setPuzzle(p);
	}
	
	////////////////////////////////////////////////////
	
	public node() {
		// TODO Auto-generated constructor stub
	}

	public void setPuzzle(int[] p) {
		for(int i = 0 ; i < puzzle.length; i++ ) {
			this.puzzle[i] = p[i];
		}
	}
	
	////////////////////////////////////////////////////
	
	public boolean goalTest() {
		boolean isGoal = true;
		int m = puzzle[0];
		for(int i = 1 ; i < puzzle.length; i++) {
			if( m > puzzle[i]) {
				isGoal = false;
			}
			m = puzzle[i];
		}
		return isGoal;
	}
	
	////////////////////////////////////////////////////
	
	private void moveRight(int[] p , int i) {
 			if(i % col < col - 1) {
			int [] pc = new int[9];
			copyPuzzle(pc , p );
			int temp = pc[i+1];
			pc[i+1] = pc[i];
			pc[i] = temp;
			

			node child = new node(pc);
			children.add(child);
			
			child.parent = this;
//			System.out.println("");
//
//			System.out.println("moveRight");
//			child.printPuzzle();		
//			
		}
	}
	
	private void moveLeft(int[] p , int i) {
 
		
			if(i % col > 0) {
				int [] pc = new int[9];
				copyPuzzle(pc , p );
				int temp = pc[i-1];
				pc[i-1] = pc[i];
				pc[i] = temp;
				
				node child = new node(pc);
				
				
				children.add(child);
				
				child.parent = this;
//				System.out.println("");
//
//				System.out.println("moveLeft");
//				child.printPuzzle();
//				
				
			}
	}
		
	private void moveUp(int[] p , int i) {
		
		if(i - col >= 0	) {
			int [] pc = new int[9];
			copyPuzzle(pc , p );
			int temp = pc[i-3];
			pc[i-3] = pc[i];
			pc[i] = temp;
			
			node child = new node(pc);
			children.add(child);
			child.parent = this;
//			System.out.println("");
//			System.out.println("moveUp");
//			child.printPuzzle();

			
			
			
		}
		
		

	}
	
	private void moveDown(int[] p , int i) {
		if(i + col < puzzle.length) {
			int [] pc = new int[9];
			copyPuzzle(pc , p );
			int temp = pc[i+3];
			pc[i+3] = pc[i];
			pc[i] = temp;
			
			node child = new node(pc);
			children.add(child);
			child.parent = this;
//			System.out.println("");
//
//			System.out.println("moveDown");
//			child.printPuzzle();
			
		}
	}
	
	/////////////////////////////////////////
	public void copyPuzzle(int[] a , int[] b) {
		for (int i = 0 ; i < b.length; i++ ) {
			a[i] = b[i];
		}
	}
	/////////////////////////////////////////
	public void printPuzzle() {

		int m = 0;
		for (int i = 0; i < col; i++) {
			System.out.println("");
			for(int j = 0 ; j < col; j++) {
				System.out.print(puzzle[m] + " ");
				m++;
			}
		}
		System.out.println("\n-----");

	}
	/////////////////////////////////////////
	public boolean isSamePuzzle(int[] p) {
		boolean samePuzzle = true;
		for(int i = 0; i < p.length; i++) {
			{
				if(puzzle[i] != p[i]) {
					samePuzzle = false;
				}
			}
			
		}
		return samePuzzle;
	}
	/////////////////////////////////////////
	public void ExpandMove() {
		for(int i = 0; i < puzzle.length; i++) {
			if(puzzle[i] == 0)
				x = i;
		}
		children = new LinkedList<node>();
		moveRight(puzzle , x);
		moveLeft(puzzle , x );
		moveUp(puzzle , x );
		moveDown(puzzle , x);
//		System.out.println("");
//		System.out.println("----------------------");
	}
	
	public int accessPuzzle(int[] p , int i) {
		
		return p[i];
	}
	
	public void setDepth(int d) {
		depth = d;
		System.out.println("d is " + depth);
		
	}
	
}
