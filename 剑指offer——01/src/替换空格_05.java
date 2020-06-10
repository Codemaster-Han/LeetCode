/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

输入：s = "We are happy."
输出："We%20are%20happy.
 */
import java.util.Scanner;

public class 替换空格_05 {
    /*
   忽略了“    ”----“%20%20%20”  这种情况
    public static String replaceSpace(String s) {
        String[] ss=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ss.length;i++){
            sb.append(ss[i]);
            if(i<ss.length-1){
                sb.append("%20");
            }
        }
        return  sb.toString();
    }
    */
    public static String replaceSpace(String s) {
       String st= s.replaceAll(" ","%20");
       return st;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String st=scanner.nextLine();
        System.out.println(replaceSpace(st));
    }
}
