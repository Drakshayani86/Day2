class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //check for initial character of the word
                if(board[i][j] == word.charAt(0) && searchWord(i, j, 0, m, n, board, visited, word))
                    return true;
            }
        }
        return false;
    }
    public boolean searchWord(int i, int j, int index, int m, int n, char[][] board, boolean[][] visited, String word){
        //if the word is found 
        if(index == word.length())
            return true;
        //if index out of bounds or character at specific index doesn't match with character on the board
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || board[i][j]!=word.charAt(index))
            return false;
        
        //mark current position as visited
        visited[i][j] = true;
        //move in all possible directions
        if(searchWord(i+1, j, index+1, m, n, board, visited, word) ||
          searchWord(i, j+1, index+1, m, n, board, visited, word) ||
          searchWord(i-1, j, index+1, m, n, board, visited, word) ||
          searchWord(i, j-1, index+1, m, n, board, visited, word))
            return true;
        visited[i][j] = false;
        return false;
    }
}