class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k[] = new int[n+m];
        int id = 0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                k[id] = nums1[i];
                id++; 
                i++;
            }
            else{
                k[id] = nums2[j];
                j++;
                id++;
            }
        }
        while(j<n){
            k[id] = nums2[j];
            j++;
            id++;
        }
        while(i<m){
            k[id] = nums1[i];
            i++;
            id++;
        }
        for (int x = 0; x < m + n; x++) {
            nums1[x] = k[x];
}
    }
    
}