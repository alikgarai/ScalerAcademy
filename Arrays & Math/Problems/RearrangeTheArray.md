# Rearrange the array
    Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].

    Rearrange the array such that A[i] = j is changed to A[j] = i for all i and j form 0 to N-1.

    Note: Try solving this with O(1) extra space.


### Input Format

    The only argument given is the integer array A.
### Output Format

    Return the rearranged array A.
### Constraints

1 <= N <= 100000
    0 <= A[i] < N
### For Example

### Input 1:
    A = [1, 2, 3, 4, 0]
### Output 1:
    [4, 0, 1, 2, 3]

### Input 2:
    A = [2, 0, 1, 3]
### Output 2:
    [1, 2, 0, 3]
