class Solution {
    public String largestNumber(int[] nums) {
        String arr[] = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = String.valueOf(nums[i]);
        }
        //System.out.println(Arrays.asList(arr));
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
        String res = "";
        //System.out.println(Arrays.asList(arr));
        for(int i=0;i<arr.length;i++){
            res= res + arr[i];
        }
        int i = 0;
        while(i<res.length()  && res.charAt(i)=='0'){
            i++;
        }
        return (i==res.length())?res.substring(i-1):res.substring(i);
    }
}