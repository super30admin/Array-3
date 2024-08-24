def hIndex(citations):
    n = len(citations)
    counts = [0] * (n + 1)
    
    # Fill the counts array
    for citation in citations:
        if citation >= n:
            counts[n] += 1
        else:
            counts[citation] += 1
    print(counts)
    
    # Calculate h-index
    total = 0
    for i in range(n, -1, -1):
        total += counts[i]
        if total >= i:
            return i
    
    return 0

citations = [3,0,6,1,5]
print(hIndex(citations))

#time = O(n)