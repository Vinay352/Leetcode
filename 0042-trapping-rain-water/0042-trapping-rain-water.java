class Solution {
    public int trap(int[] height) {
        int n = height.length;
    int[] left = new int[n], right = new int[n];
    left[0] = height[0];
    right[n-1] = height[n-1];
    for(int i = 1; i < n; i++) {
        left[i] = Math.max(left[i-1], height[i]);
        int j = n - i - 1;
        right[j] = Math.max(right[j+1], height[j]);
    }
    int trappedWater = 0;
    for(int i = 0; i < n; i++) {
        trappedWater += Math.min(left[i], right[i]) - height[i]; // Subtract the height of the bar
    }
    return trappedWater;
    }
}