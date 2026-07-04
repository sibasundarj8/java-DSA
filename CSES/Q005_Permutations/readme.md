# CSES Problem: Permutations

This repository contains the solution for the **"Permutations"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1070).

## Problem Description

A permutation of integers **1, 2, ..., n** is called **beautiful** if the absolute difference between every pair of adjacent elements is **not equal to 1**.

Given an integer **n**, construct any beautiful permutation if one exists. If it is impossible, print **"NO SOLUTION"**.

### Constraints

* $1 \le n \le 10^6$

### Examples

**Example 1**

**Input:**
```text
5
```

**Output:**
```text
4 2 5 3 1
```

**Example 2**

**Input:**
```text
3
```

**Output:**
```text
NO SOLUTION
```

## Solution Approach

The solution uses a **greedy construction** based on separating **even** and **odd** numbers.

* **Logic:**
    * For `n = 1`, the only permutation is `1`.
    * For `n = 2` and `n = 3`, it is impossible to arrange the numbers without having adjacent elements differ by `1`, so print **"NO SOLUTION"**.
    * For `n ≥ 4`:
        * Print all **even** numbers in increasing order.
        * Then print all **odd** numbers in increasing order.
    * This arrangement ensures that adjacent numbers never differ by `1`, producing a valid beautiful permutation.

Since each number is printed exactly once, the algorithm is both simple and efficient.

### Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (for the output string)

## Code Implementation (Java)

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        if (n == 2 || n == 3) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i += 2)
            sb.append(i).append(" ");

        for (int i = 1; i <= n; i += 2)
            sb.append(i).append(" ");

        System.out.println(sb);
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------