package codes;

import java.util.Arrays;

public class h_index_solution {
    public static  int hIndex(int[] citations) {
//    	tc-O(n)
//    	spc-O(1)
        Arrays.sort(citations);
        
        int i=0;
        
        while(i<citations.length && citations[citations.length-1-i]>i){
            i++;
        }
        
        return i;
    }
    
    
    public static void main(String[] args) {
    	int [] citations = {3,0,6,1,5};
    	int result=hIndex(citations);
    	
    	System.out.println(result);
    	
	}
}
