/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n 是一个整数
 * 要么 x 不为零，要么 n > 0 。
 * -104 <= xn <= 104
 */
public class Solution {
    public double myPow(double x, int n) {
       return n < 0 ? pow(x, -n) :pow(x,n);
    }
    
    public static double pow(double x, int n){
        if(n == 0) {
            return 1;
        }
        double tmp = pow(x, n/2);
        return n/2 == 0 ? tmp*tmp : tmp * tmp * x;
        
    }
}
