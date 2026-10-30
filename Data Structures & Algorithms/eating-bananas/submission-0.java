class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // We need to find the minimum eating speed (k) such that
        // Koko can finish all piles within h hours.
        //
        // The possible speed range is [1, maxPile], so we apply
        // Binary Search on the answer.
        //
        // If a speed 'mid' can finish all bananas within h hours,
        // we try a smaller speed (search left).
        //
        // If a speed 'mid' cannot finish within h hours,
        // we need a larger speed (search right).
        //
        // When the search ends:
        // - r points to the last invalid speed.
        // - l points to the first valid speed.
        // Therefore, l is the minimum eating speed that works,
        // so we return l.

        // Calculate total hours required to finish all piles
        // at the given eating speed.
        //
        // (pile + speed - 1) / speed is equivalent to
        // ceil(pile / speed), i.e., the hours needed to
        // finish one pile.
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int l = 1;
        int r = max;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isAbleToEat(piles, h, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean isAbleToEat(int[] piles, int h, int speed) {

        long time = 0;

        for (int pile : piles) {
//            time += (pile + speed - 1) / speed;
            time += (int) Math.ceil((double) pile / speed);
        }

        return time <= h;
    }
}
