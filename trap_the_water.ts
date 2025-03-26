// TC: O(2n) SC: O(1)
function trap(height: number[]): number {
  let result: number = 0;

  let maxHeight = -1;
  let maxHeightIdx = -1;

  // TC: O(n)
  for (let i = 0; i < height.length; i++) {
    if (height[i] > maxHeight) {
      maxHeight = height[i];
      maxHeightIdx = i;
    }
  }

  let leftWall: number = 0;
  let left: number = 0;

  // TC: O(n) for both while loops
  while (left < maxHeightIdx) {
    if (height[left] < leftWall) {
      result += leftWall - height[left];
    } else {
      leftWall = height[left];
    }
    left++;
  }

  let rightWall = 0;
  let right = height.length - 1;

  while (right > maxHeightIdx) {
    if (height[right] < rightWall) {
      result += rightWall - height[right];
    } else {
      rightWall = height[right];
    }
    right--;
  }

  return result;
}

// TC: O(n) SC: O(1)
function trapSingleParse(height: number[]): number {
  let result: number = 0;

  let leftWall: number = 0;
  let left: number = 0;
  let right: number = height.length - 1;
  let rightWall: number = 0;

  // TC: O(n) for both while loops
  while (left <= right) {
    if (leftWall < rightWall) {
      if (height[left] < leftWall) {
        result += leftWall - height[left];
      } else {
        leftWall = height[left];
      }
      left++;
    } else {
      if (height[right] < rightWall) {
        result += rightWall - height[right];
      } else {
        rightWall = height[right];
      }
      right--;
    }
  }

  return result;
}

// TC: O(n) SC: O(1)
function trapThreeParse(height: number[]): number {
  let result: number = 0;

  let leftWalls: number[] = Array.from({ length: height.length });
  let rightWalls: number[] = Array.from({ length: height.length });

  for (let h = 0; h < height.length; h++) {
    if (h > 0) {
      leftWalls[h] = Math.max(leftWalls[h - 1], height[h]);
    } else {
      leftWalls[h] = height[h];
    }
  }

  for (let h = height.length - 1; h >= 0; h--) {
    if (h != height.length - 1) {
      rightWalls[h] = Math.max(rightWalls[h + 1], height[h]);
    } else {
      rightWalls[h] = height[h];
    }
  }

  for (let i = 0; i < height.length; i++) {
    let minHeight = Math.min(leftWalls[i], rightWalls[i]);
    let effectiveHeight = minHeight - height[i];
    result += effectiveHeight;
  }

  return result;
}

function trap_increasing_stack(height: number[]): number {
  let result: number = 0;
  let stack: number[] = []; // store the idx  space: O(n)

  for (let i = 0; i < height.length; i++) {
    // TC: O(n)
    // if stack is not empty and height at stack is less than current height
    // which means we found the right wall
    while (stack.length > 0 && height[i] > height[stack[stack.length - 1]]) {
      // TC: O(n)
      let popped = stack.pop()!;
      if (stack.length > 0) {
        // i == right wall
        // stack.peek == left wall
        let width = i - stack[stack.length - 1] - 1;
        // Min Between Left and Right Wall
        let minHeight = Math.min(height[i], height[stack[stack.length - 1]]);
        let effectiveHeight = minHeight - height[popped];
        result += width * effectiveHeight;
      }
    }

    stack.push(i);
  }

  return result;
}

describe("189. Rotate Array", () => {
  it("2 Pass Logic", () => {
    //           0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
    expect(trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])).toStrictEqual(6);
  });

  it("1 Pass Logic", () => {
    //           0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
    expect(trapSingleParse([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])).toStrictEqual(
      6
    );
  });

  it("3 Pass Logic", () => {
    //           0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
    expect(trapThreeParse([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])).toStrictEqual(
      6
    );
  });

  it("Increasing Stack Logic", () => {
    //           0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
    expect(
      trap_increasing_stack([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1])
    ).toStrictEqual(6);
  });
});
