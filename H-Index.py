

#Space and Time complaexity are O(N) AND O(N)
def hIndex(self, citations):
    n = len(citations)
    #number of papers with i citations.
    papers = [0] * (n + 1)  
    #if citations less than n increment count else treat it as n
    for c in citations:
        papers[min(n, c)] += 1  
    h = n
    s = papers[n]  
    while h > s:
        h -= 1
        s += papers[h]
    return h