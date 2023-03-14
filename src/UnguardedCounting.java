public class UnguardedCounting {
	public static void main(String[] args) {
	int m = 4;
	int n = 6;
	int[][] guards = {{0,0},{1,1},{2,3}};
	int[][] walls =	{{0,1},{2,2},{1,4}};
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    char[][] grid= new char[m][n];
    int count = m*n - guards.length - walls.length;
    for(int[] wall : walls)
    {
        int x = wall[0], y = wall[1];					//get those wall locations. wall[o] is the x location of wall
        grid[x][y] = 'W';
    }
    
    for(int[] guard : guards)
    {
        int x = guard[0], y = guard[1];
        grid[x][y] = 'G';
    }
for(int i = 0; i <m;i++) {
	for(int j = 0;j<n;j++) {
		System.out.print(grid[i][j]);
		
	}
	System.out.println();
}
for(int[] location : guards) {
	for(int [] direction: dirs) {
		int x = location[0]+direction[0];
		int y = location[1]+direction[1];
		while(!(x<0 || y<0 || x>=m || y>=n || grid[x][y]=='G' || grid[x][y]=='W')) {	//the most important part in this one is how to set limitation to it to detect the spot is guarded
			if(grid[x][y]!='p') {
				count--;
			}
			grid[x][y] = 'p';
			x += direction[0];
			y += direction[1];
		}
	}
}

/*
    for(int[] point : guards)
    {
        for(int dir[] : dirs)
        {
            int x = point[0] + dir[0];
            int y = point[1] + dir[1];
            while(!(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 'G' || grid[x][y] == 'W'))
            {
                if(grid[x][y] != 'P')
                    count--;
                grid[x][y] = 'P';
                x += dir[0];
                y += dir[1];
            }
        }
    }*/
    System.out.print(count);
}
	}
