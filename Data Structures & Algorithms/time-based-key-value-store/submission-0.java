// Intuition:
// We need to design a Time-Based Key Value Store.
//
// For each key, multiple values can be stored at different timestamps.
// Since timestamps are added in increasing order, all timestamps for a key
// remain sorted automatically.
//
// Data Structure:
// HashMap<String, ArrayList<TimestampValue>>
//
// Key   -> String
// Value -> List of (timestamp, value) pairs
//
// Example:
// set("foo", "bar", 1)
// set("foo", "bar2", 4)
//
// Map:
// foo -> [(1, "bar"), (4, "bar2")]
//
// set():
// - If the key doesn't exist, create a new list.
// - Append the new (timestamp, value) pair to the list.
// - Time Complexity: O(1)
//
// get():
// We need to return the value associated with the largest timestamp
// that is less than or equal to the given timestamp.
//
// Example:
// [(1,"bar"), (4,"bar2")]
//
// get("foo", 4) -> "bar2"
// get("foo", 3) -> "bar"
// get("foo", 0) -> ""
//
// Since timestamps are sorted, we can use Binary Search.
//
// Binary Search Logic:
// 1. If current timestamp <= target timestamp,
//    it can be a valid answer.
//    Store its value and move right to find a later valid timestamp.
//
// 2. If current timestamp > target timestamp,
//    it cannot be used.
//    Move left.
//
// We continue until the search space is exhausted.
//
// The last stored answer will correspond to the latest timestamp
// not exceeding the given timestamp.
//
// Time Complexity:
// set() : O(1)
// get() : O(log n)
//
// Space Complexity:
// O(n) where n is the total number of stored timestamp-value pairs.

class TimestampValue {
    int time;
    String val;

    public TimestampValue(int time, String val) {
        this.time = time;
        this.val = val;
    }

}

class TimeMap {

    HashMap<String, ArrayList<TimestampValue>> TimeMap;

    public TimeMap() {
        TimeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!TimeMap.containsKey(key)){
            TimeMap.put(key, new ArrayList<>());
        }
        ArrayList<TimestampValue> timestampAndValue = TimeMap.get(key);
        timestampAndValue.add(new TimestampValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!TimeMap.containsKey(key)) {
            return "";
        }

        ArrayList<TimestampValue> list = TimeMap.get(key);

        int l = 0;
        int r = list.size() - 1;
        String ans = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid).time <= timestamp) {
                ans = list.get(mid).val; // possible answer
                l = mid + 1;             // try finding a later timestamp
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}
