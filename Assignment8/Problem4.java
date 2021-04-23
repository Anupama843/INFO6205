package Assignment8;
/*
4. https://leetcode.com/problems/number-of-islands/
 */

public class Problem4 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }
    private void callBFS(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        callBFS(grid, i+1, j);
        callBFS(grid, i-1, j);
        callBFS(grid, i, j+1);
        callBFS(grid, i, j-1);

    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'},
                {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        Problem4 p = new Problem4();
        System.out.println(p.numIslands(grid));

    }
}
