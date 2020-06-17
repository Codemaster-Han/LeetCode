import java.util.Scanner;

/*
数学推导总体分为两步：① 当所有绳段长度相等时，乘积最大。② 最优的绳段长度为 3 。
绳子段切分的越多，乘积越大，且3做因数比2更优。
不断剪去 长度3 并用sum累乘
把绳子切为多个长度为 3 的片段，则留下的最后一段绳子的长度可能为 0,1,2 三种情况。
 */
public class 剪绳子_14 {
    //解法1
    public static int cuttingRope(int n) {
      int sum=1;
      if(n<=3){
          return n-1;
      }
      while (n>4){
          sum*=3;
          n=n-3;
      }
      return  sum*n;//此时n是循环结束后剩下的长度
    }

    //解法2---动态规划
    public static int cuttingRope2(int n) {
        //1.创建数组-设置对应的含义,dp[n]为长度为 n 时候，最大的乘积 我们只需求出dp[n]
        int[] dp = new int[n+7];
        //3.确定初始值
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        dp[3]=2;
        dp[4]=4;
        dp[5]=6;
        dp[6]=9;
        if(n<=6){return dp[n];}
        //2.找到递推关系
        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i-3]*3;
        }
        return dp[n];

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            System.out.println(cuttingRope(n));
            System.out.println(cuttingRope2(n));
        }
    }
}


/*
第一步：定义dp[n]的值的含义为：数字n的乘积最大值
n=2:  1+1  -->1*1=1;   				dp[2]=1;
n=3:  2+1  -->2*1=2;   				dp[3]=2;
n=4:  2+2  -->2*2=4;   				dp[4]=4;
n=5:  3+2  -->3*2=6;   				dp[5]=6;
貌似看不出规律，别急再多写几个
n=6:  3+3  -->3*3=9;                 dp[6]=9;
n=7:  4+3  -->4*3=12;-->dp[4]*3=12   dp[7]=12;
n=8:  5+3  -->6*3=12;-->dp[5]*3=18   dp[8]=18;
n=9:  6+3  -->9*3=12;-->dp[6]*3=27   dp[9]=27;
n=10: 7+3  -->12*3=36;-->dp[7]*3=12   dp[10]=36;


第二步：找到递推的规律：
通过上述分析，规律明显在n=7以后为
if(n>=7)
	dp[n] = dp[n-3]*3;


第三步：找初始值：
初始值在第二步找规律已经找到了
n=2:  1+1  -->1*1=1;   				dp[2]=1;
n=3:  2+1  -->2*1=2;   				dp[3]=2;
n=4:  2+2  -->2*2=4;   				dp[4]=4;
n=5:  3+2  -->3*2=6;   				dp[5]=6;
n=6:  3+3  -->3*3=4;                dp[6]=9;
通过以上分析，就直接可以写代码了：
 */