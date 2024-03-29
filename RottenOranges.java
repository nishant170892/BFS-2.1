// Time Complexity : O(m*n)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/rotting-oranges/description/
// Any problem you faced while coding this : No


class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int []> queue = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]==2){
                    queue.add(new int[] {i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
          if(fresh==0) return 0;
          int time = 0;
          while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){ // This is for the level
            int[] element = queue.poll();
            for(int[] dir:dirs){
                int newRow = element[0]+dir[0];
                int newColumn = element[1]+dir[1];
                if(newRow>=0 && newColumn>=0 && newRow<row && newColumn<column && grid[newRow][newColumn]==1){
                    grid[newRow][newColumn]=2;
                    queue.add(new int[] {newRow,newColumn});
                    fresh--;
                }
            }
         }
           time++;
          }
          if(fresh!=0) return -1;
          return time-1;

    }
}
