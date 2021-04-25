# Carotenemia
You are given an Array of boxes A, where each box consists of oranges. You really love oranges, and you want to eat atleast B oranges. You start from the 0th index of the array, and keep eating oranges until you eat B oranges. If oranges from a box at ith index get depleted, you start eating from the (i+1)th box.

Determine index of the box where you finish eating B number of oranges. If you don't eat B oranges even after eating from all the boxes, return -1.

### Input:

A: Array of integers.
B: Integer
### Output:

Integer
### Constraints:

1 <= size(A) <= 10^5
1 <= Integers in A <= 10^4
1 <= B <= 10^9
### Example:

### Input

A: [1, 3, 2, 4]
B: 5
### Output

2

You eat 1 orange from box 0.
You eat 3 oranges from box 1, hence a total of 4 oranges.
You eat 1 orange from box 2, hence a total of 5 oranges, and you stop.
### Input

A: [1, 1, 1, 4]
B: 10
### Output

-1

You eat 1 orange from box 0.
You eat 1 orange from box 1, hence a total of 2 oranges.
You eat 1 orange from box 2, hence a total of 3 oranges.
You eat 4 oranges from box 3, hence a total of 7 oranges.
As you never complete 10 oranges, return -1.
