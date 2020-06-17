import java.util.Scanner;

public class 剪绳子II_14 {
    //方法  1
    public static int cuttingRope(int n) {
       //int[] dp=new int[n+7];  //此时再用int型就不能满足数据了，改为Long型就好了
        long[] dp=new long[n+7];
       dp[0]=0;
       dp[1]=0;
       dp[2]=1;
       dp[3]=2;
       dp[4]=4;
       dp[5]=6;
       dp[6]=9;
       if(n<=6){
           return  (int)dp[n];
       }
       for(int i=7;i<=n;i++){
           dp[i]=(dp[i-3]*3)%1000000007;
       }
       return  (int)dp[n];
    }

    //方法  2
    public static int cuttingRope2(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    //方法  3
    public static int cuttingRope3(int n) {
        return n <= 3 ? n-1 : (int)process(n);
    }
    public static long process(long n){
        return n > 4 ? (process(n-3)*3)%1000000007 : n;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            System.out.println(cuttingRope(n));
            System.out.println(cuttingRope2(n));
            System.out.println(cuttingRope3(n));
        }
    }
}
