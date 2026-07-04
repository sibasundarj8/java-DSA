# CSES Problem: Increasing Array

This repository contains the solution for the **"Increasing Array"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1094).

## Problem Description

You are given an array of integers. Your task is to modify the array so that it becomes **non-decreasing**, meaning every element is at least as large as the previous one.

In one move, you may increase the value of any element by **1**. Determine the **minimum number of moves** required to make the entire array non-decreasing.

### Constraints

* $1 \le n \le 2 \cdot 10^5$
* $1 \le x_i \le 10^9$

### Example

**Input:**
```text
5
3 2 5 1 7
```

**Output:**
```text
5
```

## Solution Approach

The solution uses a **greedy approach** with a single traversal of the array.

* **Logic:**
    * Read the first element and treat it as the current maximum (`prev`).
    * Traverse the remaining elements one by one.
    * If the current element is smaller than `prev`, it must be increased to match `prev`.
        * Add the difference (`prev - curr`) to the total number of moves.
    * Otherwise, update `prev` to the current element since it already maintains the non-decreasing order.
* Since increasing an element to exactly match the previous element is always optimal, this greedy strategy guarantees the minimum number of moves.

### Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

## Code Implementation (Java)

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long moves = 0;
        int prev = sc.nextInt();
        int curr;

        for (int i = 1; i < n; i++) {
            curr = sc.nextInt();

            if (curr < prev)
                moves += prev - curr;
            else
                prev = curr;
        }

        System.out.println(moves);
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------