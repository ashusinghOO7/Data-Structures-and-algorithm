class Pair{
    int x,y;
    Pair(int a,int b){
        x=a;y=b;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a,Pair b)->{
            if(a.y==b.y)
                return a.x-b.x;
            return a.y-b.y;
            });
        for(int i:arr){
            pq.add(new Pair(i,Math.abs(i-x)));
        }
        List<Integer> al = new ArrayList<>();
        while(k-->0){
            al.add(pq.poll().x);
        }
        Collections.sort(al);
        return al;
    }
}