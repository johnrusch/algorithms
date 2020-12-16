import java.util.Random;

public class InPlaceShuffle {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] array) {

        if (array.length <= 1) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {

            int randomChoiceIdx = getRandom(i, array.length - 1);

            if (randomChoiceIdx != i) {
                int temp = array[i];
                array[i] = array[randomChoiceIdx];
                array[randomChoiceIdx] = temp;
            }
        }
    }

}
