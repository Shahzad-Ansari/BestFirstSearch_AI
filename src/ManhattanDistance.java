
public class ManhattanDistance {

	public ManhattanDistance( ) {
		
		
	}
	
	public int CalculateHeuristic(node n) {
		
		//int test =  n.puzzle[1];
		
		int []solvedBoard = new int[]{0,1,2,3,4,5,6,7,8}; 
		//int []board1 = new int[] {7,2,4,5,0,6,8,3,1};
		int heuristic = 0;
		
		for(int i = 0 ; i < 9 ; i++) {
			if(n.puzzle[i] == solvedBoard[i]) {
				
				heuristic += 0;
				
			}
			else {
						boolean found = false;
						while(!found) {
							for(int j = 0 ; j < 9 ; j++) {
								if(n.puzzle[j] == i) {

									//System.out.println("solved value is" + n.puzzle[j]);
									//System.out.println("board value is " + i);
									
									int distance = Math.abs(j - i);
									int verticleStep =  Math.floorDiv(distance, 3);
									int horizontalStep = distance - verticleStep*3;
									
									//System.out.println("Distance is " + distance + " V is "+ verticleStep+" h is" + horizontalStep);

									heuristic += verticleStep + horizontalStep;
									
									//System.out.println("h value is " + heuristic);
									//System.out.println("--------------");

									found = true;
								}
							}
						}
							 
				}
			
		}
		
		
		
		int ManhattanDistance = heuristic;
		
	//	System.out.println("Heuristic" + ManhattanDistance);
		
		return ManhattanDistance;
		
	}
	
}
