class Solution {
    public int maxProduct(String[] words) {
        //비트마스크
        int[] bitmap = new int[words.length];
        for(int i=0; i<words.length;i++){
            for(int j=0; j<words[i].length();j++){
                bitmap[i] |= 1<< (words[i].charAt(j) - 'a');
            }
        }

        int maxLength =0;
        for(int i=0; i<bitmap.length;i++){
            for(int j=i+1; j<bitmap.length;j++){
                if( (bitmap[i] & bitmap[j]) ==0 && words[i].length()* words[j].length() > maxLength){
                    maxLength = words[i].length()* words[j].length();
                }
            }
        }
        return maxLength;
    }
}