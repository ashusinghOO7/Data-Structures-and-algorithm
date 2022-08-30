class Solution {
    public void rotate(int[][] matrix) {
        int temp=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                temp=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
        int low=0,high=matrix.length-1;
        while(low<high){
            for(int i=0;i<matrix.length;i++){
                temp=matrix[i][low];
                matrix[i][low]=matrix[i][high];
                matrix[i][high] = temp;
            }
            low++;
            high--;
        }
    }
}