# CSES Problem: Mex Grid Construction

This repository contains the solution for the **"Mex Grid Construction"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/3419).

## Problem Description

Your task is to construct an $n \times n$ grid where each square contains the smallest non-negative integer ($\text{mex}$) that does not appear to the left on the same row or above on the same column.

### Constraints

- $1 \le n \le 100$

## Example

**Input:**

```text
5
```

**Output:**

```text
0 1 2 3 4
1 0 3 2 5
2 3 0 1 6
3 2 1 0 7
4 5 6 7 0
```

## Solution Approach

The value placed at cell $(i, j)$ (using 0-based indexing) is defined as:

$$
A[i][j] = \text{mex}\Big(\{A[i][k] \mid 0 \le k < j\} \cup \{A[k][j] \mid 0 \le k < i\}\Big)
$$

This recurrence is identical to the definition of **nim-addition** (bitwise XOR) in combinatorial game theory (specifically Sprague-Grundy theorem on 2-pile Nim):

$$
A[i][j] = i \oplus j
$$

### Mathematical Property

- By induction, the set of values strictly to the left in row $i$ is $\{i \oplus k \mid 0 \le k < j\}$ and strictly above in column $j$ is $\{k \oplus j \mid 0 \le k < i\}$.
- The smallest non-negative integer not present in these sets for cell $(i, j)$ is mathematically equal to $i \oplus j$.
- Therefore, each cell value can be computed in $O(1)$ directly using the bitwise XOR operator `i ^ j`.

## Complexity

### Time Complexity

$$
O(n^2)
$$

We compute the bitwise XOR for every cell in the $n \times n$ matrix in $O(1)$ time.

### Space Complexity

$$
O(1)
$$

No extra memory or grid storage is needed; results are printed directly using buffered I/O.

## Code Implementation (Java)

```java
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write((i ^ j) + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}
```

---

# ---------------------------- THANK YOU ----------------------------