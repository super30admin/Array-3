class Solution {
    public int hIndex(int[] citations) {

        int[] balti = new int[citations.length+1];

        for(int citation : citations){
            balti[Math.min(citation, citations.length)]++;
        }

        int sofar = 0;

        for(int i = balti.length-1; i > 0; i--){
            sofar += balti[i];
            if(sofar >= i) return i;
        }

        return 0;
        
    }
}
