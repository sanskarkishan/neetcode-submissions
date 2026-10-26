class Solution {
    // Find the time for all cars to reach to the target and save this to duoble arr position and time.
        // Sort the arr with respect to dec order.
        // Now traverse to the arr and if prvTime < currTime, count++ and set prevTime = currTime.
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));
        int count = 0;
        double prevTime = 0;
        for (double[] set : cars){
            if (set[1] > prevTime){
                count++;
                prevTime = set[1];
            }
        }
        return count;
    }
}
