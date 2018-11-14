package array;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int last = -1;
        int secondLast = -1;
        int lastCount = 0;
        int currMax = 0;
        int res = 0;
        for (int num: tree) {
            if (num == last || num == secondLast) {
                currMax++;
            } else {
                currMax = lastCount + 1;
            }
            if (num == last) {
                lastCount++;
            } else {
                secondLast = last;
                last = num;
                lastCount = 1;
            }
            res = Math.max(res, currMax);
        }
        return res;
    }
}
