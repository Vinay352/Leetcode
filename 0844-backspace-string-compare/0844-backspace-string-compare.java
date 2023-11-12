class Solution {
    public boolean backspaceCompare(String s, String t) {
        int firstLength = s.length();
        int secondLength = t.length();

        int firstPointer = firstLength - 1;
        int secondPointer = secondLength - 1;

        int countOfCharsToBackspaceString1 = 0;
        int countOfCharsToBackspaceString2 = 0;

        while(firstPointer >= 0 || secondPointer >= 0){
            while(firstPointer >= 0){
                char firstStringChar = s.charAt(firstPointer);
                if(firstStringChar == '#'){
                    countOfCharsToBackspaceString1++;
                    firstPointer--;
                }
                else if(countOfCharsToBackspaceString1 > 0){
                    countOfCharsToBackspaceString1--;
                    firstPointer--;
                }
                else{
                    break;
                }
            }

            while(secondPointer >= 0){
                char secondStringChar = t.charAt(secondPointer);
                if(secondStringChar == '#'){
                    countOfCharsToBackspaceString2++;
                    secondPointer--;
                }
                else if(countOfCharsToBackspaceString2 > 0){
                    countOfCharsToBackspaceString2--;
                    secondPointer--;
                }
                else{
                    break;
                }
            }

            if( (firstPointer >= 0 && secondPointer >= 0) && (s.charAt(firstPointer) != t.charAt(secondPointer)) ){
                return false;
            }
            if( (firstPointer >= 0) != (secondPointer >= 0)){
                return false;
            }
            firstPointer--;
            secondPointer--;
        }
        return true;
    }
}