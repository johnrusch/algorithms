public class GetNthFib {

    public static int fib(int n) {

        //edge cases
        if (n < 0) {
            throw new IllegalArgumentException("Index must be 0 or greater.");
        } else if (n == 0 || n == 1) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;
        int current = 0;

        for (int i = 1; i < n; i++) {
            /* in order to save space and time complexity, we don't use a
            * recursive solution or memoization. We start from the bottom up
            * that way once we get to n we'll have the answer for the preceding
            * two digits. We start at 1 and go until i is less than n because
            * once we have the value at n - 2 and n - 1 we'll
            * have our solution. i is not used it's just to
            * count.*/

            /* add the two previous to get the current
            * set the one before the previous to previous
            * set previous to the current*/
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }
}
