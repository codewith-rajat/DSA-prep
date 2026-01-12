// https://leetcode.com/problems/meeting-rooms-iii/description/

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int fr[] = new int[n], m = meetings.length;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<long[]> p2 =
            new PriorityQueue<>((a, b) ->
                a[1] == b[1] ? (int)(a[2] - b[2]) : Long.compare(a[1], b[1])
            );
        for (int i = 0; i < n; i++) p1.add(i);
        for (int i = 0; i < m; i++) {
            long start = meetings[i][0];
            long end = meetings[i][1];
            while (!p2.isEmpty() && p2.peek()[1] <= start) {
                p1.add((int) p2.poll()[2]);
            }
            if (!p1.isEmpty()) {
                int curr = p1.poll();
                p2.add(new long[]{start, end, curr});
                fr[curr]++;
            } else {
                long[] curr = p2.poll();
                long e = curr[1];
                int room = (int) curr[2];
                long duration = end - start;
                p2.add(new long[]{e, e + duration, room});
                fr[room]++;
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (fr[i] > fr[ans]) ans = i;
        }
        return ans;
    }
}