public class test13_机器人的运动范围 {
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];//初始化都是false
        return dfs(0, 0, m, n, k, visited);
    }

    private static int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {  //ij代表实时移动到的坐标位置，m n代表棋盘方格，k代表输入的条件，visitde 代表是否有障碍物
        //当超出边界移动到方格外面，或者每个数的每一位之和>k时，或者visisted为false时，此方格都可看做是障碍物
        if (i < 0 || i >= m || j < 0 || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) +
                dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited) + 1;//递归--每次向左、右、上、下移动一格   坐标（0.0）肯定是满足条件得，所以最后加了一个1；
    }

    public static void main(String[] args) {
        int m=2,n=3,k=1;
        System.out.println(movingCount(m, n, k));  //3
    }
}


//深度优先搜索DFS
//深度优先搜索一般使用栈来实现。本题使用递归可以更轻松实现，我们定义一个递归函数 dfs()，如果坐标不满足条件，结束递归状态，否则将下一步满足条件的坐标代入递归函数。
/*
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */