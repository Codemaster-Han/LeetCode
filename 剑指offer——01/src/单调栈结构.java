import java.util.Scanner;

public class 单调栈结构 {

    public static void stacksignl(int n,int[] arr){
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    left[i]=-1;
                }else {
                    if(arr[j]<arr[i]){
                        left[i]=i;
                        break;
                    }
                    if(i==(n-1)){
                        right[i]=-1;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(left[i]+" "+right[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        stacksignl(n,arr);
    }
}
