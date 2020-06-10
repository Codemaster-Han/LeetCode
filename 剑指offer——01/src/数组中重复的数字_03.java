/*
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
import java.util.*;
public class 数组中重复的数字_03 {

    //先排序，后比较，算法实时性高
    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    //算法会超时
    /*
    public static int findRepeatNumber(int[] nums) {
      int len=nums.length;
      for(int i=0;i<len;i++){
          int cnt=0;
         for(int j=len-1;j>=0;j--){
             if(nums[i]==nums[j]){
                 cnt++;
             }
         }
          if(cnt>1){
              return nums[i];
          }
      }
      return 0;
    }
    */

    public static void main(String[] args) {
     int[] nums={2, 3, 1, 0, 2, 5, 3};
     System.out.println(findRepeatNumber(nums));//输出：2 或 3
    }

}
