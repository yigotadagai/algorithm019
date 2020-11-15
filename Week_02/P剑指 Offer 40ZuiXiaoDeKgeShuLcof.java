//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 159 👎 0

package Week_02;

import java.util.Comparator;
import java.util.PriorityQueue;

//java:最小的k个数
/*public*/ class  /*P剑指*/ Offer_40ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args){
        Solution solution = new  Offer_40ZuiXiaoDeKgeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            //violence
            int[] vec = new int[k];
            if (k == 0) { // 排除 0 的情况
                return vec;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                //实现大根堆
                //将最大值放在队头
                public int compare(Integer num1, Integer num2) {
                    /*num1 < num2 return 负数
                    * num1 = num2 return 0
                    * num1 > num2 return 正数*/
                    return num2 - num1;
                }
            });
            for (int i = 0; i < k; ++i) {
                queue.offer(arr[i]);
            }
            for (int i = k; i < arr.length; ++i) {
                if (queue.peek() > arr[i]) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
            for (int i = 0; i < k; ++i) {
                vec[i] = queue.poll();
            }
            return vec;

/*
            //sort
            Arrays.sort(arr);
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}