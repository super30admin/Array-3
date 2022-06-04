//Brute Force
class Solution {

    //Time Complexity: 0(nlogn) where n is the no of citations
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief, explain your approach

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        Arrays.sort(citations); //we are sorting the citations so as to match it with the no of papers per citations and get the difference
        int n = citations.length ;
        for(int i = 0; i < n; i++){ //running a loop through citations array
            int diff = n-i; //calculating the h-index between the papers and the citations
            if(diff <= citations[i]){   //when the h-index is equal or less to the citations, we return
                return diff;
            }
        }
        return 0;
    }
}

//Using count sort

class Solution {

    //Time Complexity: 0(n) where n is the no of citations
    //Space Complexity: 0(n)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief, explain your approach

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int n = citations.length;
        int [] bucket = new int [n + 1];    //creating a bucket array to do count sort and taking length as +1 because we need to account for citations which are more than the the length of the citations array
        for(int i = 0; i < n; i++){ //Doing count sort and increasing the value of bucket's index when the value is encountered in citations array
            if(citations[i] > n){
                bucket[n]++;    //if the element in citations is more than the length, then just increasing the last elements count in bucket array
            }
            else{
                bucket[citations[i]]++;
            }
        }
        int rsum = 0;   //taking a rsum to find total papers
        for(int i = n; i >=0; i--){ //running a loop from the last index of bucket
            rsum = rsum + bucket[i];    //taking rsum
            if(rsum >= i){  //if the rsum is equal or greater than the h-index, then returning the h index
                return i;
            }
        }
        return 0;
    }
}