//考点——动态规划
public class test12_矩阵中的路径{
    //leetcode官方解答    采用深度优先搜索（DFS)---动态规划
    public static boolean exist2(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) { //二维数组行
            for(int j = 0; j < board[0].length; j++) {//二维数组列
                if(dfs(board, words, i, j, 0)) return true;//深度优先搜索，搜索到了，则返回真
            }
        }
        return false;
    }
    static boolean dfs(char[][] board, char[] word, int i, int j, int k) {    //深度优先搜索算法
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
        {
            return false;
        }
        if(k == word.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                       dfs(board, word, i - 1, j, k + 1) ||
                       dfs(board, word, i, j + 1, k + 1) ||
                       dfs(board, word, i , j - 1, k + 1);   //向左向右向上向下操作
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board={{'a','b'},{'c','d'}};
        String word="abcd";
        System.out.println(exist2(board,word));
    }
}

/**
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 */