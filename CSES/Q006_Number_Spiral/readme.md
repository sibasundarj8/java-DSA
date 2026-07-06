# CSES Problem: Number Spiral

This repository contains the solution for the **"Number Spiral"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1071).

## Problem Description

A **number spiral** is an infinite square grid where numbers are arranged in a spiral pattern starting from the top-left corner with **1**.

For each query, you are given the coordinates **(y, x)** representing a row and a column. Your task is to determine the number located at that position in the spiral.

### Constraints

* $1 \le t \le 10^5$
* $1 \le y, x \le 10^9$

### Example

**Input:**
```text
3
2 3
1 1
4 2
```

**Output:**
```text
8
1
15
```

## Solution Approach

The solution uses **mathematical observations** to compute the answer directly without constructing the spiral.

* **Logic:**
    * Each coordinate belongs to a square **layer**, determined by `max(row, column)`.
    * For a layer `n`, the numbers range from:
        * **Starting value:** `n² + 1`
        * **Ending value:** `(n + 1)²`
    * The direction of numbering depends on whether the layer is **even** or **odd**.
    * Based on the larger of the row or column and the layer's parity, compute the required value using simple arithmetic.

Since each query is answered independently using a few calculations, the solution is extremely efficient.

### Complexity

* **Time Complexity:** `O(1)` per test case
* **Space Complexity:** `O(1)`

## Code Implementation (Java)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // number of test cases
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            long n = Math.max(r, c);
            long startingPoint = n * n + 1;
            long endingPoint = (n + 1) * (n + 1);
            boolean odd = (n & 1) == 1;

            if (r <= c) {
                if (odd) sb.append(startingPoint + r);
                else sb.append(endingPoint - r);
            } else {
                if (odd) sb.append(endingPoint - c);
                else sb.append(startingPoint + c);
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------