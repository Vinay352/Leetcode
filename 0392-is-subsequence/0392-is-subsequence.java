class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;
        
        int targetLength = s.length();
        int counter = 0;
        
        while(sPointer < s.length() && tPointer < t.length()){
            if( s.charAt(sPointer) == t.charAt(tPointer) ){
                counter++;
                sPointer++;
            }
            tPointer++;
        }
        
        if(counter == targetLength){
            return true;
        }
        
        return false;
    }
}