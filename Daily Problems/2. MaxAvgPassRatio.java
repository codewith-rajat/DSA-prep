// https://leetcode.com/problems/maximum-average-pass-ratio/description/  1-sep-25

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>( (a,b) -> Double.compare(b[0],a[0]));
        for(int i=0;i<classes.length;i++){
            double pass = classes[i][0];
            double total = classes[i][1];
            double inc = (pass+1.0)/(total+1.0) - pass/total;
            pq.add(new double []{inc,pass,total});
        }
        while(extraStudents-->0){
            double top[] = pq.poll();
            double pass = top[1]+1;
            double total = top[2]+1;
            double inc = (pass+1.0)/(total+1.0) - pass/total;
            pq.add(new double[]{inc,pass,total});
        }
        double sum = 0.0;
        while(pq.size()>0){
            double top[] = pq.poll();
            double pass = top[1];
            double total = top[2];
            sum += pass/total;
        }
        return sum/classes.length;
    }
}