# tc O(n), sc O(n).
paper_counts = [0] * (len(citations) + 1)

for citation_cnt in citations:
    paper_counts[min(citation_cnt, len(citations))] += 1

h = len(citations)
papers_cnt = paper_counts[-1]

while h > papers_cnt:
    h -= 1
    papers_cnt += paper_counts[h]

return h