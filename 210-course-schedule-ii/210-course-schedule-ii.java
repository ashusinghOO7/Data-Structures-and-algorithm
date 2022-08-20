class Solution {
    public int[] findOrder(int n, int[][] arr) {
        int degree[] = new int[n+1];
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int e[] : arr){
            graph[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        int[] res = new int[n];
        int l = 0;
        
        while(!q.isEmpty()){
            int u = q.poll();
            res[l++] = u;
            for(int x:graph[u]){
                degree[x]--;
                if(degree[x]==0){
                    q.add(x);
                }
            }
        }
        return (l==n)?res: new int[0];
    }
}