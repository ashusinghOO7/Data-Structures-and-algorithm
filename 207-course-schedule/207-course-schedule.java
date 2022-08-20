class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        ArrayList<Integer> []graph = new ArrayList[numCourses];
        ArrayList<Integer> bfs = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for(int i=0;i<numCourses;i++){
            if(degree[i]==0){
                bfs.add(i);
            }
        }
        for (int i = 0; i < bfs.size(); ++i)
            for (int j: graph[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        return bfs.size() == numCourses;
        
    }
}