import java.util.*;

class Solution {

    class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    int[][] arr;
    int n;
    int[] next;
    State[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        // left, right, weight, original index
        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by left endpoint
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        // Find next non-overlapping interval
        next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(i);
        }

        // dp[i][k]
        dp = new State[n + 1][5];

        State answer = solve(0, 4);

        int[] result = new int[answer.indices.size()];

        for (int i = 0; i < answer.indices.size(); i++) {
            int position = answer.indices.get(i);

            // Convert sorted position to original index
            result[i] = arr[position][3];
        }

        // Lexicographical order
        Arrays.sort(result);

        return result;
    }

    private int findNext(int i) {

        int right = arr[i][1];

        int low = i + 1;
        int high = n;

        // Need left > right
        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][0] > right) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private State solve(int i, int remaining) {

        if (i == n || remaining == 0) {
            return new State(0, new ArrayList<>());
        }

        if (dp[i][remaining] != null) {
            return dp[i][remaining];
        }

        // Option 1: Don't take current interval
        State skip = solve(i + 1, remaining);

        // Option 2: Take current interval
        State nextState = solve(next[i], remaining - 1);

        List<Integer> takeList = new ArrayList<>();

        takeList.add(i);
        takeList.addAll(nextState.indices);

        State take = new State(
            arr[i][2] + nextState.score,
            takeList
        );

        State best;

        if (take.score > skip.score) {
            best = take;
        } 
        else if (take.score < skip.score) {
            best = skip;
        } 
        else {
            // Same score -> lexicographically smaller
            if (isLexicographicallySmaller(
                    take.indices,
                    skip.indices)) {

                best = take;

            } else {
                best = skip;
            }
        }

        dp[i][remaining] = best;

        return best;
    }

    private boolean isLexicographicallySmaller(
        List<Integer> a,
        List<Integer> b) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        // Convert sorted positions
        // into original indices
        for (int i : a) {
            x.add(arr[i][3]);
        }

        for (int i : b) {
            y.add(arr[i][3]);
        }

        Collections.sort(x);
        Collections.sort(y);

        int size = Math.min(x.size(), y.size());

        for (int i = 0; i < size; i++) {

            if (!x.get(i).equals(y.get(i))) {
                return x.get(i) < y.get(i);
            }
        }

        return x.size() < y.size();
    }
}