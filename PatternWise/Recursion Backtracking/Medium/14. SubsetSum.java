// We have to print unique subsets whose sum is equal to target

import java.util.*;
class Main {
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,4};
        int target = 4;
        Arrays.sort(arr);
        List<List<Integer>> ls = new ArrayList<>();
        help(arr,target,0,ls,new ArrayList<>());
        for(List<Integer> i : ls){
            for(int j=0;j<i.size();j++){
                System.out.print(i.get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void help(int []arr, int sum, int idx, List<List<Integer>> ls, List<Integer> temp){
        if(sum==0) {
            ls.add(new ArrayList<>(temp));
            return;
        }
        if(idx==arr.length) return;
        if(sum<0) return;
        temp.add(arr[idx]);
        help(arr,sum-arr[idx],idx+1,ls,temp);
        temp.remove(temp.size()-1);
        int next = idx+1;
        while(next<arr.length && arr[next]==arr[idx]) next++;
        help(arr,sum,next,ls,temp);
    }
}