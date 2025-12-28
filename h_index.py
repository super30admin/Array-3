class Solution:
    def hIndex(self, citations: List[int]) -> int:


        citations.sort()
        tuplelist = []
        counter = 1
        for i in range(len(citations)-1, -1, -1):
            tuplelist.append((citations[i], counter))
            counter += 1
        print(tuplelist)

        res = 0
        for key, val in tuplelist:
            if key >= val:
                res = max(res,val)
        return res

                
        """0 1 3 5 6
        0 1 2 4 6 7 7 9 10
        c. h
        1: 8
        2: 7
        4: 6 
        6: 5 
        7: 4
        9: 2
        10: 1 
        """
"""
        1 1 3

        1: 3
        3: 1
        """
