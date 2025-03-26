function pivotIndex(nums: number[]): number {
  let leftSum = 0;
  let rightSum = 0;
  let left = 0;
  let right = nums.length - 1;

  while (left <= right) {
    if (leftSum < rightSum) {
      leftSum += nums[left];
      left++;
    } else {
      rightSum += nums[right];
      right--;
    }
    if (leftSum == rightSum) {
      if (right - left == 2) return left + 1;
      else if (left == right) return left;
    }
  }

  return -1;
}

describe("724. Find Pivot Index", () => {
  it("Happy Path - 01", () => {
    expect(pivotIndex([1, 7, 3, 6, 5, 6])).toStrictEqual(3);
  });

  it("Happy Path - 01", () => {
    expect(pivotIndex([1, 2, 3, 3, 5, 1])).toStrictEqual(3);
  });

  it("Happy Path - 01", () => {
    expect(pivotIndex([1, 2, 3])).toStrictEqual(-1);
  });

  it("Happy Path - 01", () => {
    expect(pivotIndex([2, 1, -1])).toStrictEqual(0);
  });

  it("Happy Path - 01", () => {
    expect(pivotIndex([-1, -1, -1, -1, -1, 0])).toStrictEqual(0);
  });
});
