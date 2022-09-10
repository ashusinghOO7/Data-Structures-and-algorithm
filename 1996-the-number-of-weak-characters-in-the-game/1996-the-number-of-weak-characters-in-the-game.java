class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a,b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) :         Integer.compare(a[0], b[0]));
        int weak = 0;
        int n = properties.length;
        int max = properties[n-1][1];
        for(int i =n-2; i>=0 ;i--) {
            if(properties[i][1] < max) {
                weak++;
            } else {
                max = properties[i][1];
            }
        }
        return weak;
    }
}