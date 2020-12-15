public class HighestProductOfThree {
    public int highestProductOfThree(int[] array) {

        if (array.length < 3) {
            throw new IllegalArgumentException("Array must have at least 3 integers");
        }

        int highestProductOf3 = Integer.MIN_VALUE;
        int highestProductOf2 = array[0] * array[1];
        int lowestProductOf2 = array[0] * array[1];
        int highest = Math.max(array[0], array[1]);
        int lowest = Math.min(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {

            highestProductOf3 = Math.max(highestProductOf3,
                    Math.max(array[i] * highestProductOf2, array[i] * lowestProductOf2));

            highestProductOf2 = Math.max(highestProductOf2, Math.max(array[i] * highest
                    , array[i] * lowest));

            lowestProductOf2 = Math.min(lowestProductOf2, Math.min(array[i] * highest,
                    array[i] * lowest));

            highest = Math.max(highest, array[i]);
            lowest = Math.min(lowest, array[i]);
        }

        return highestProductOf3;
    }
}
