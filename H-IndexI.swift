//
//  H-IndexI.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/27/26.
//

class HIndexI {
    
    //with unsorted array
    /*
     [15, 0, 3, 2, 14]
     there is no point in sorting the elements which are greater than 5. Means 14, 15 doesn't need to be sorted.
     The range of HIndex is 5. We can sort the elemtns upto 5 using Bucket sort.
     If we have a prticular range of elements, to be sorted - we can use bucket sort.
     Have bucket items upto 5. [0, 1, 2, 3,4, 5] - 6 buckets.
     Anything which is 5 or greater are same to me. No need to sort
     15 is greater than 5, so put it in 5th bucket only/
     14 is greater than 5, so put it in 5th bucket only/
     If we start from end, there are 2 papers which are greater than or equal to 5 citations.
     0 + 2 = 2 papers 
     */

    func hIndexUsingSortedarray(_ citations: [Int]) -> Int {
        let sortedArray = citations.sorted(by: <)
        
        let n = citations.count
        for i in 0..<sortedArray.count {
            let papersLeft = n - i
            if (sortedArray[i] >= papersLeft) {
                return papersLeft
            }
        }
        return 0
    }
    
    func hIndexUsingBucketSort(_ citations: [Int]) -> Int {
        let n = citations.count
        var buckets = [Int](repeating: 0, count: n + 1)

        for i in 0..<citations.count {
            if (citations[i] >= n) {
                buckets[n] += 1
            } else {
                buckets[citations[i]] += 1
            }
        }

        //now loop from the back and find the hIndex
        var papersLeft = 0
        for i in stride(from: n, through: 0, by: -1) {
            papersLeft += buckets[i]
            //i is nothing but the citations in the form of buckets
            if (papersLeft >= i) {
                return i
            }
        }
        return 0
    }
}
