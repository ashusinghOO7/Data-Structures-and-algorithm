class Pair{
    int frst,scnd;
    Pair(int a,int b){
        frst = a;
        scnd = b;
    }
}
class Solution {
    public boolean isValid(int i,int j,int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int cnt=0;
        int di[] = {-1,1,0,0};
        int dj[] = {0,0,1,-1};
        while(!q.isEmpty()){
            int k = q.size();
            cnt++;
            while(k-->0){
                Pair curr = q.poll();
                for(int i=0;i<4;i++){
                    int xi = di[i]+curr.frst;
                    int xj = dj[i]+curr.scnd;
                    if(isValid(xi,xj,grid) && grid[xi][xj]==1){
                        grid[xi][xj]=2;
                        q.add(new Pair(xi,xj));
                        fresh--;
                    }else
                        continue;

                }
            }
        }
        return (fresh==0)?cnt-1:-1;
    }
}