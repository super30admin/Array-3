// Brute force
// TC: O(n*k) since we perform the operation on the entire array(n) k times.
var rotate = function (nums, k) {
  while (k--) {
    let temp = nums[nums.length - 1];
    for (let i = 0; i < nums.length; i++) {
      let currentNum = nums[i];
      nums[i] = temp;
      temp = currentNum;
    }
  }
};

// Better than brute force attempt:
// as long as k is less than length of array: tc: o(n) sc: o(n)
var rotate = function (nums, k) {
  if (k >= nums.length) {
    while (k--) {
      let temp = nums[nums.length - 1];
      for (let i = 0; i < nums.length; i++) {
        let currentNum = nums[i];
        nums[i] = temp;
        temp = currentNum;
      }
    }
  } else {
    const resultsArr = [];

    let rotateUntilIndex = nums.length - k;

    for (let i = nums.length - k; i < nums.length; i++) {
      resultsArr.push(nums[i]);
    }

    for (let i = 0; i < rotateUntilIndex; i++) {
      resultsArr.push(nums[i]);
    }

    for (let i = 0; i < resultsArr.length; i++) {
      nums[i] = resultsArr[i];
    }
  }
};
