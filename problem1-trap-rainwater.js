// https://leetcode.com/problems/trapping-rain-water/
// runtime: O(n)
// storage: O(1)
// passing leetcode?: yes
// obstacles: conceptual steps, still not sure how
//    comparing the far left height and far right height helps
//
// explanation:
//
//  start pointers at left and right side, call them L and R
//  keep a left wall and a right wall signifying the enclosing barriers on left and right
//    call them LW, RW respectively
//
//  loop
//  picking the lower height between L and R, dir = Min(L, R)
//    if [dir]W < height[dir] then set wall to height[dir]
//    else you have an enclosure for water so...
//       ...add to your total the water volume at that point which is
//       ...height[dir] - [dir]W
//
//  return total

var trap = (height) => {
  if (!height || !height.length) return 0

  let [L, R, LW, RW, total] = [0, height.length - 1, 0, 0, 0]

  while (L <= R) {
    if (LW < RW) {
      if (LW < height[L]) {
        LW = height[L]
      } else {
        total += LW - height[L]
      }
      L += 1
    } else {
      if (RW < height[R]) {
        RW = height[R]
      } else {
        total += RW - height[R]
      }
      R -= 1
    }
  }

  return total
}

// trap([])
