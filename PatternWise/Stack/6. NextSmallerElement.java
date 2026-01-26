// https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        ArrayList<Integer> ls = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            int v = st.isEmpty() ? -1 : arr[st.peek()];
            ls.add(v);
            st.push(i);
        }
        Collections.reverse(ls);
        return ls;
    }
}

// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> ls = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]) st.pop();
            int v = st.isEmpty() ? -1 : arr[st.peek()];
            ls.add(v);
            st.push(i);
        }
        Collections.reverse(ls);
        return ls;
    }
}