import java.util.*;
import java.lang.*;
import java.io.*;

class DynamicProg { // Recursion with Cache

    // static -> do not need a instance for use. like a class method in python
    static int fibo(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;

        return fibo(i - 1) + fibo(i - 2);
    }

    // top-down approach -> memoization
    static int fibo_dynamic(int n) {
        return fibo_dynamic(n, new int[n + 1]);
    }

    static int fibo_dynamic(int n, int[] memo) {
        if (n == 0 || n == 1)
            return n;

        // ilk kez hesaplancak, memoda olsaydı direk asagida return etcekti
        if (memo[n] == 0) {
            memo[n] = fibo_dynamic(n - 1, memo) + fibo_dynamic(n - 2, memo);
        }

        return memo[n];
    }

    static int fibo_dynamic_bottomup(int n) {
        if (n == 0 || n == 1)
            return n;

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n - 1] + memo[n - 2];
    }

    // cocuk 1er,2şer veya 3er merdiven cıkıyo kac farklı yoldan cıkar, n -> stair
    // uzunluk
    static int stairways(int n) {
        if (n == 1)
            return 1; // there is 1 way, one step
        else if (n == 2)
            return 2; // there are 2 way, "11" or "2"
        else if (n == 3)
            return 4; // there are 4 ways, "1111", "21", "12", "3"

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for (int i = 4; i < n; i++)
            memo[i] = memo[i - 3] + memo[i - 2] + memo[i - 1];

        // return stairways(n - 3) + stairways(n - 2) + stairways(n - 1); // son adimi
        // 3,2,1 ise asagidan kac farkli yoldan
        // geldi

        return memo[n - 3] + memo[n - 2] + memo[n - 1];

    }

    static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }

    }

    public static void main(String[] args) {

        // System.out.println(fibo_dynamic_bottomup(1));
        System.out.println(stairways(6));
        System.out.println(countWays(6));

    }

}