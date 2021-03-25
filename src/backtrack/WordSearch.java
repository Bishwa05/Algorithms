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
}

