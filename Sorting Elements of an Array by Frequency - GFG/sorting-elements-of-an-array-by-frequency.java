/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int ele,cnt;
    Pair(int x,int y){
        ele = x;
        cnt = y;
    }
}
class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    HashMap<Integer,Integer> hm = new HashMap<>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
		    }
		    Pair[] x = new Pair[hm.size()];
		    int j=0;
		    for(Map.Entry<Integer,Integer> e:hm.entrySet()){
		        x[j++] = new Pair(e.getKey(),e.getValue());
		    }
		    Arrays.sort(x,(a,b)->(a.cnt==b.cnt)?a.ele-b.ele:b.cnt-a.cnt);
		    j=0;
		    for(Pair k:x){
		        int el = k.ele;
		        int cn = k.cnt;
		        while(cn-->0){
		            System.out.print(el + " ");
		        }
		    }
		    System.out.println();
		}
	}
}