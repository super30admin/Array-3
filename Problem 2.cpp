//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    //bucket sort method
    int hIndex(vector<int>& citations) {
        
        /*int bucket_size = citations.size()+1;
        int bucket_arr[citations.size()+1];
        
        //fill the bucket with existing citations
        for(int i=0; i<citations.size(); i++){
            if(citations[i]>=citations.size()){
                bucket_arr[bucket_size]+=1;
            }
            else{
                bucket_arr[citations[i]]+=1;
            }
        }
        
        return 0;*/
        
        int bucket_size = citations.size()+1;
        vector<int> bucket_arr;
        //fill the bucket_arr with 0's
        for(int i=0; i<bucket_size; i++){
            bucket_arr.push_back(0);
        }
        //fill the bucket with existing citations
        for(int i=0; i<citations.size(); i++){
            if(citations[i]>=citations.size()){
                bucket_arr[bucket_arr.size()-1]++;
            }
            else{
                bucket_arr[citations[i]]++;
            }
        }
        
        //check for the numbers crossing each other
        int sum =0;
        for(int i=bucket_arr.size()-1; i>=0; i--){
            sum += bucket_arr[i];
            if(sum>=i)
                return i;  
        }
        
        return -1;
    }
};