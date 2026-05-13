package backtrack;

public class WordSearch
{
    public boolean exist (char[][] board, String word)
    {
        if(board ==null || board.length ==0 || board[0].length ==0 || word == null) return false;

        if(word.length() ==0) return true;

        int m = board.length;
        int n = board[0].length;

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, i, j, word, 0)){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int i, int j, String word, int pos){
        if(pos == word.length()) return true;
        int m = board.length;
        int n = board[0].length;

        if(i<0 || i>m || j<0 || j>n || board[i][j] != word.charAt(pos)) return false;

        board[i][j] ='*';

        boolean res = backtrack(board, i+1, j, word, pos+1)||
            backtrack(board, i-1, j, word, pos+1) ||
            backtrack(board, i, j+1, word, pos+1) ||
            backtrack(board, i, j-1, word, pos+1);

        board[i][j] = word.charAt(pos);

        return res;

    }

    // Another variant of backtrack
/*
    public boolean backtrack2(int row, int col, String word, int index){
        if(index >= word.length()){
            return true;
        }

        if(row < 0 || row >= rows || col < 0 || col >= cols || this.board[row][col] != word.charAt(index)){
            return false;
        }

        int [] rowdir = {0,1,0,-1};
        int[] coldir = {1,0,-1,0};
        this.board[row][col] = '#';

        boolean ret = false;
        for(int d = 0; d<4; d++){
            ret = backtrack(row + rowdir[d], col + coldir[d], word, index+1);
            if(ret){
                break;
            }
        }
        board[row][col] = word.charAt(index);
        return ret;

    }

 */
}

