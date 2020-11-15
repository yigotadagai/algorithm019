//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2740 👎 0

package Week_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:三数之和
public class P15ThreeSum{
    public static void main(String[] args){
        Solution solution = new P15ThreeSum().new Solution();
        int[] arr = new int[]{1, 4, -3, 9, -7, 6, 3};
        List<List<Integer>> lists = solution.threeSum(arr);
        System.out.println(lists.toString());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null) return null;
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[0] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int a = i + 1, b = nums.length - 1;
                int c = -nums[i];
                while (a < b) {
                    if (nums[a] + nums[b] == c) {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[i]));
                        a++; b--;
                        while (a < b && nums[a] == nums[a - 1]) a++;
                        while (a < b && nums[b] == nums[b + 1]) b--;
                    } else if (nums[a] + nums[b] < c) {
                        a++;
                    } else {
                        b--;
                    }
                }
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}