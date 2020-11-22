//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1416 👎 0

package Week_03;

import java.util.ArrayList;
import java.util.List;

//java:括号生成
public class P22GenerateParentheses{
    public static void main(String[] args){
        Solution solution = new P22GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
    /**
     * @author apple
     */ //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
/*
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            generateAll(new char[2 * n], 0, res);
            return res;
        }

        private void generateAll(char[] cur, int pos, List<String> result) {
            if (cur.length == pos) {
                if (valid(cur)) {
                    result.add(new String(cur));
                }
            } else {
                cur[pos] = '(';
                generateAll(cur, pos + 1, result);
                cur[pos] = ')';
                generateAll(cur, pos + 1, result);
            }
        }

        private boolean valid(char[] cur) {
            int balance = 0;
            for (char c : cur) {
                if (c == '(') {
                    balance++;
                } else {
                    balance--;
                }
                if (balance < 0) {
                    return false;
                }
            }
            //if balance = 0, return true, else return false.
            return balance == 0;
        }
*/
        /*//自下向上
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            generate(0, 0, n, "", res);
            return res;
        }

        public void generate(int left, int right, int n, String s, List<String> res) {
            //terminator
            if (left == n && right == n) {
                res.add(s);
                return;
            }
            //process
            //drill down
            //任何时候都可以加左括号， 只要不大于n
            if (left < n)
            generate(left + 1, right, n, s + '(', res);
            //只有左括号存在时才能加右括号，且左括号的个数要大于右括号
            if (right < left)
            generate(left, right + 1, n, s + ')', res);
        }*/

        //自顶向下
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            generate(res, n, n, "");
            return res;
        }

        private void generate(List<String> res, int left, int right, String s) {
            if (left == 0 && right == 0) {
                res.add(s);
                return;
            }
            if (left > 0) {
                generate(res, left - 1, right, s + '(');
            }
            if (right > left) {
                generate(res, left, right - 1, s + ')');
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}