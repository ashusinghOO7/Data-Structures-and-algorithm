class RandomizedSet {

    /*HashSet<Integer> h;
    ArrayList<Integer> al;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        h = new HashSet<>();
        al = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(h.add(val)){
            al.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(h.contains(val)){
            al.remove(val);
        }
        return h.remove(val);
    }
    
    public int getRandom() {
        return al.get(rand.nextInt(al.size()));
    }
    */
        HashMap<Integer,Integer>map;
    ArrayList<Integer>arr;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        map=new HashMap<>();
        arr=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int size=map.get(val);
        if(arr.size()>1){
            arr.set(size,arr.get(arr.size()-1));
            map.put(arr.get(size),size);
        }
        arr.remove(arr.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
         return arr.get( rand.nextInt(arr.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */