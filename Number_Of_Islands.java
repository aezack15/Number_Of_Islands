import java.util.*;

public class Number_Of_Islands{

	public cell[][] board;
	HashMap<String, ArrayList<cell>> land = new HashMap<String, ArrayList<cell>>();

	private class cell{
		public int val;
		public String loc;
		public boolean visited;
		
		public cell(int val, int i, int j){
			this.val = val;
			this.loc = String.valueOf(i) + String.valueOf(j);
			this.visited = false;
		}
	}
	
	public static void main(String[] args){
		Number_Of_Islands noi = new Number_Of_Islands();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter height > ");
		int h= in.nextInt();
		System.out.print("Enter width > ");
		int w = in.nextInt();
		noi.makeBoard(h,w);
		noi.print(h,w);
		noi.findIslands(h, w);
	}
	
	private void makeBoard(int h, int w){
		board = new cell[h][w];
		Random rand = new Random();
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				board[i][j] = new cell(rand.nextInt(2), i, j);
			}
		}
	}
	
	private void print(int h, int w){
		printBoard(h,w);
	}
	
	private void printBoard(int h, int w){
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				System.out.print(board[i][j].val + " " );
			}
			System.out.println();
		}
	}
	
	private void findIslands(int h, int w){
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				ArrayList<cell> foundLand = new ArrayList<cell>();
				findIslandsR(h, w, board[i][j].loc, i, j, foundLand);
			}
		}
		System.out.println();
		System.out.println("There are " + land.size() + " islands on this map");
	}
	
	private void findIslandsR(int h, int w, String key, int i, int j, ArrayList<cell> foundLand){
		if(i < h && i >= 0 && j < w && j >= 0){
			if(board[i][j].visited == false && board[i][j].val == 1){
				board[i][j].visited = true;
				foundLand.add(board[i][j]);
				findIslandsR(h, w, key, i+1, j, foundLand);
				findIslandsR(h, w, key, i-1, j, foundLand);
				findIslandsR(h, w, key, i, j+1, foundLand);
				findIslandsR(h, w, key, i, j-1, foundLand);
				land.put(key, foundLand);
			}
		}
	}
}
