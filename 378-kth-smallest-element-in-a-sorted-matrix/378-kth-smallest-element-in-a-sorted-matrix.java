
class Tuple{
    int val,i,j;
    Tuple(int val,int i,int j){
        this.val = val;
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(k>matrix.length*matrix[0].length){
            return -1;
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<matrix.length;i++){
            pq.add(new Tuple(matrix[i][0],i,0));
        }
        while(k-->0){
            Tuple curr = pq.poll();
            if(k==0){
                return curr.val;
            }
            if(curr.j<matrix[0].length-1){
                pq.add(new Tuple(matrix[curr.i][curr.j+1],curr.i,curr.j+1));
            }
            
        }
        return -1;
    }
}