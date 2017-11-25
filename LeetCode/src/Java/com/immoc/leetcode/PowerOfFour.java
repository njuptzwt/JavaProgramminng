package com.immoc.leetcode;

/**通配符的使用！！！！
 * 使用通配符的方式实现求解是否是2的幂次方或者4的幂次方，8的幂次方！！
 * 以此类推都可以！3,5的幂次方这些方法额外讨论
 * 4的幂次方！
 * Created by 18362 on 2017/11/25.
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return Integer.toBinaryString(num).matches("1(00)*");
    }
}
