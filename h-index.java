class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cp = new int[n+1];
        for(int elem: citations){
            if(elem >= n){
                cp[n]++;
            }
            else{
                cp[elem]++;
            }
        }
        int papers = 0;
        for(int x = n; x>=0; x--){
            papers +=cp[x];
            if(papers>=x){
                return x;
            }
        }
        //System.out.println(cp);
        return 0;
    }
}
