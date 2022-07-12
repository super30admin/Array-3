SC - O(N)
TC - O(N)
 
const hIndex = function (citations) {
  const len = citations.length;
  const arr = new Array(len + 1).fill(0);

  for (const item of citations) {
    if (item >= len) {
      arr[len] += 1;
    } else {
      arr[item] += 1;
    }
  }

  let count = 0;
  for (let i = len; i >= 0; i -= 1) {
    count += arr[i];
    if (count >= i) {
      return i;
    }
  }

  return 0;
};