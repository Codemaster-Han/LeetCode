import java.util.Arrays;
import java.util.Scanner;

public class 数值中值出现一次的数字 {
    /*
    public static void findNumber(int n,int[] arr){
        Arrays.sort(arr);
        int cnt=0;
        int k=0;
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(arr[i]==arr[j]){
                   cnt++;
               }
           }
           if(cnt%2==0){
               cnt=0;
           }else{
               if(k==0){
                   System.out.print(arr[i]);
               }else {
                   System.out.print(" "+arr[i]);
               }
               k++;
               cnt=0;
           }
        }
    }
    */

    /*
    public static void findNumber2(int n,int[] arr){
        int a=0,b=0;
        int k=0;
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if(arr[i+1]!=arr[i]){
                if(k==0){
                    a=arr[i+1];
                    k++;
                }else {
                    b=arr[i+1];
                }
            }
        }
        if(a>b){
            System.out.println(b+" "+a);
        }else {
            System.out.println(a+" "+b);
        }
    }
    */

    //位运算
    public static void findNumber3(int n,int[] arr){

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            findNumber3(n,arr);
        }
    }
}
