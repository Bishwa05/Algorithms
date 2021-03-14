package dp;

public class NthFibonacciNumber
{
    public int fib (int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * memoization
     */
    public int fibMemo (int n)
    {
        if (n < 2)
            return n;
        // Create cache and initialize to -1
        int[] cache = new int[n + 1];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        // Fill initial values in cache
        cache[0] = 0;
        cache[1] = 1;
        return fib(n, cache);
    }

    // Overloaded private method
    private int fib (int n, int[] cache)
    {
        // If value is set in cache, return
        if (cache[n] >= 0)
            return cache[n];
        // Compute and add to cache before returning
        cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
        return cache[n];
    }

    public int fibBottomUp (int n)
    {
        if (n == 0)
            return 0;
        // Initialize cache
        int[] cache = new int[n + 1];
        cache[1] = 1;

        // Fill cache iteratively
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public static void main (String arg[])
    {
        int n = 10;
        NthFibonacciNumber f = new NthFibonacciNumber();
        System.out.println(f.fib(10));
        System.out.println(f.fibMemo(10));
        System.out.println(f.fibBottomUp(10));
    }

}
