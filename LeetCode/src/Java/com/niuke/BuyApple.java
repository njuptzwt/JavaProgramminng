package com.niuke;

import java.util.Scanner;

/**
 * 买苹果
 * Created by 18362 on 2017/11/24.
 */
public class BuyApple {
    public static int buy(int x) {
        if (x == 0)
            return 0;
        if (x < 6)
            return 1000;
        return Math.min(buy(x - 6), buy(x - 8)) + 1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        while (sc.hasNext()) {
            int count = sc.nextInt();
            res = buy(count);
            if (res >= 1000)
                System.out.println(-1);
            else
                System.out.println(res);
        }

    }
}
