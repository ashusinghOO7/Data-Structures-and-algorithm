class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n<=0){
            return res;
        }
        if(n==1){
            res.add(0);
            return res;
        }
        int indegree[] = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==1)
                q.add(i);
        }
        while(n>2){
            int size = q.size();
            n -= size;
            while(size-->0){
                int curr = q.poll();
                for(int j:graph.get(curr)){
                    indegree[j]--;
                    if(indegree[j]==1){
                        q.add(j);
                    }
                }
            }
        }
        res.addAll(q);
        return res;
    }
}