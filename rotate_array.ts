/**
 Do not return anything, modify nums in-place instead.
 */
function rotate(nums: number[], k: number): number[] {
  function reverse(from: number, to: number) {
    let left = from;
    let right = to;
    while (left < right) {
      swap(left, right);
      left++;
      right--;
    }
  }

  function swap(i: number, j: number) {
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  k = k % nums.length

  // Reverse last k element
  reverse(nums.length - k, nums.length - 1);
  // Reverse all elements before k
  reverse(0, nums.length - 1 - k);
  // reverse all element
  reverse(0, nums.length - 1);

  return [...nums];
}

describe("189. Rotate Array", () => {
  it("Happy Path - 01", () => {
    expect(rotate([1, 2, 3, 4, 5, 6, 7], 24)).toStrictEqual([
      5, 6, 7, 1, 2, 3, 4,
    ]);
  });
});
