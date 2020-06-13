import java.util.Scanner;

public class test10_斐波那些数列 {
    //用递归--时间复杂度太高
    public static int fib(int n) {
          if(n==0){
              return 0;
          }
          if(n==1||n==2){
              return 1;
          }
          return  fib(n-1)%1000000007+fib(n-2)%1000000007;
    }

    //用动态规划思想--效率高
    public static int fib2(int n) {
        int f0=0,f1=1,f2=1;
        int fn=0;
        if(n==0){
            return f0;
        }
        if(n==1||n==2){
            return f1;
        }
        for(int i=3;i<=n;i++){
            fn=(f1+f2)%1000000007;
            f1=f2%1000000007;
            f2=fn%1000000007;
        }
        return fn;

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            System.out.println(fib(n));
            System.out.println(fib2(n));
        }
    }
}
