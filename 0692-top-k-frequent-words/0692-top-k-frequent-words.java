class Pair{
    String a;int b;
    Pair(String a,int b){
        this.a=a;this.b=b;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->(y.b==x.b)?x.a.compareTo(y.a):y.b-x.b);
        HashMap<String,Integer> hm = new HashMap<>();
        for(String str:words){
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String,Integer> e:hm.entrySet()){
            pq.add(new Pair(e.getKey(),e.getValue()));
        }
        List<String> res = new ArrayList<>();
        while(k-->0){
            res.add(pq.poll().a);
        }
        //Collections.sort(res);
        return res;
    }
}