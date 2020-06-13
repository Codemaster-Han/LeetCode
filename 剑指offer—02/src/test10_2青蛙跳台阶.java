import java.util.Scanner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class test10_2青蛙跳台阶 {
    //递归
    public static int numWays(int n) {
        if(n<=2){
            return n;
        }
        return numWays(n-1)+numWays(n-2);
    }
    //动态规划
    public static int numWays2(int n) {
        if(n<=1){
            return 1;
        }
        int[] fn=new int[n+1];
        fn[0]=1;
        fn[1]=1;//初始值
        for(int i=2;i<n+1;i++){
            fn[i]=(fn[i-1]+fn[i-2])%1000000007;//状态转移方程

        }
        return fn[n];
    }

    //动态规划2
    public static int numWays3(int n) {
        if(n<=1){
            return 1;
        }
        int x=1,y=1;//初始两个值
        int fn=0;
        int i=2;
        while (i<=n){
            fn=(x+y)%1000000007;
            x=y;
            y=fn;
            i++;
        }
        return fn;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println("递归--"+numWays(n));
            System.out.println("动态规划--"+numWays2(n));
            System.out.println("动态规划2--"+numWays3(n));
        }
    }
}
