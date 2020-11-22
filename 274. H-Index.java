class Solution {// Time of O(n) and space of O(n)
    // done using counting sort approach
    public int hIndex(int[] citations) {
        int numPapers = citations.length;
        int[] papers = new int[numPapers + 1];
        
        //Clipping the citations to the no. of papers
        //Papers contaains citations frequency
        for(int c:citations){
            papers[(Math.min(numPapers,c))]++;
        }
        //Calculate the H-index
        int citation = numPapers ;
        for(int freq = papers[numPapers] ; citation > freq ; freq += papers[citation])
            citation--;
        return citation;
    }
}