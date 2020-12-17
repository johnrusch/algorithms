public class FindRotationPoint {
    public static int findRotationPoint(String[] words) {
        final String firstWord = words[0];
        int floorIdx = 0;
        int ceilingIdx = words.length - 1;

        while (floorIdx < ceilingIdx) {

            int guessIdx = floorIdx + ((ceilingIdx - floorIdx) / 2);

            int compare = words[guessIdx].compareTo(firstWord);
            if (compare >= 0) {
                floorIdx = guessIdx;
            } else {
                ceilingIdx = guessIdx;
            }

            if (floorIdx + 1 == ceilingIdx) {
                break;
            }
        }
        return ceilingIdx;
    }
}
