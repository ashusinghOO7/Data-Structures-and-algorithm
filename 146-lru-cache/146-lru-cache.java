class LRUCache {

    int cap;
    LinkedHashMap<Integer,Integer> hm;
    public LRUCache(int capacity) {
        cap=capacity;
        hm = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        int curr = hm.getOrDefault(key,-1);
        if(curr!=-1){
            hm.remove(key);
            hm.put(key,curr);}
        return curr;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            hm.remove(key);
            hm.put(key,value);
        }
        else{
            if(hm.size()<cap){
                hm.put(key,value);
            }
            else{
                Iterator<Integer> it = hm.keySet().iterator();
                hm.remove(it.next());
                hm.put(key,value);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */