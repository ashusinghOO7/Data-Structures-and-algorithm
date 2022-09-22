class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> al = new ArrayList<>();
        int left = 0,right=matrix[0].length-1,up=0,down=matrix.length-1;
        int cnt = matrix.length*matrix[0].length;
        while(cnt>0 && left<=right && up<=down){
            for(int i=left;i<=right && cnt>0;i++){
                al.add(matrix[up][i]);cnt--;
            }
            up++;
            for(int i=up;i<=down && cnt>0;i++){
                al.add(matrix[i][right]);cnt--;
            }
            right--;
            for(int i=right;i>=left && cnt>0;i--){
                al.add(matrix[down][i]);cnt--;
            }
            down--;
            for(int i=down;i>=up && cnt>0;i--){
                al.add(matrix[i][left]);cnt--;
            }
            left++;
        }
        return al;
    }
}