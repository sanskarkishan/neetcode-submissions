class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //Approach 2
        //Make A 2d arr and add the pair of position[i] and speed[i]. 
        // Sort the arr with respect to position in dec order.
        // Now traverse to the arr and if prvFinishTime < currFinishTime, count++ and set prevFinishTime = currFinishTime.

        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        double prevTTA = 0;
        Stack<Double> stack = new Stack<>();
        for (int[] car : cars) {
            double TTA = (double) (target - car[0]) / car[1];
            if (prevTTA < TTA) {
                stack.push(TTA);
                prevTTA = TTA;
            }
        }
        return stack.size();
    }
}
