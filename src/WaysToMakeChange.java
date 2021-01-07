public class WaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = int[n + 1];
        ways[0] = 1;
        for (int denom : denoms) {
            for (int amt = denom; amt < ways.length; amt++) {
                int remainder = denom - amt;
                ways[amt] += ways[remainder];
            }
        }
        return ways[n];
    }
}
