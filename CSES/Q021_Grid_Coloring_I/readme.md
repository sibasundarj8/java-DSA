# CSES Problem: Grid Coloring I

This repository contains the solution for the **"Grid Coloring I"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/3311).

## Problem Description

You are given an $n \times m$ grid where each cell contains one character `A`, `B`, `C`, or `D`.

For each cell, you must change the character to `A`, `B`, `C`, or `D`. The new character must be different from the old one.

Your task is to change the characters in every cell such that no two adjacent cells have the same character.

### Constraints

- $1 \le n, m \le 500$

## Example

**Input:**

```text
3 4
AAAA
BBBB
CCDD
```

**Output:**

```text
CDCD
DCDC
ABAB
```

## Solution Approach

We need to assign a character from $\{'A', 'B', 'C', 'D'\}$ to each cell $(i, j)$ such that:
1. The assigned character is different from the original character at $(i, j)$.
2. The assigned character is different from adjacent cells (specifically the top neighbor $(i-1, j)$ and left neighbor $(i, j-1)$).

Since we have 4 colors available and at most 3 restrictions per cell (the original character, the cell above, and the cell to the left), by the Pigeonhole Principle there will always be at least one valid color available ($4 - 3 \ge 1$). Thus, a greedy approach processing row by row from top to bottom and left to right is guaranteed to find a valid configuration without backtracking.

### Logic

1. Process the grid row by row.
2. Maintain an array `prev` of size $m$ to store the characters placed in the previous row for each column index, and update it in-place as we transition.
3. For cell $(i, j)$ with original character `cur`:
    - Iterate through characters `'A'` through `'D'`.
    - Skip `ch` if `ch == cur` (must change character).
    - Skip `ch` if `ch == prev[j]` (must differ from the top cell).
    - Skip `ch` if `j > 0` and `ch == prev[j - 1]` (must differ from the left cell).
    - Select the first character that satisfies all conditions, write it to the output, and update `prev[j] = ch`.

## Complexity

### Time Complexity

$$O(n \times m)$$

For each of the $n \times m$ cells, we check at most 4 characters with $O(1)$ condition evaluations.

### Space Complexity

$$O(m)$$

Only a 1D array `prev` of length $m$ is maintained to track the preceding row's state.

## Code Implementation (Java)

```java
import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    /// Solution
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[] prev = new char[m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();

            for (int j = 0; j < m; j++) {
                char cur = row.charAt(j);

                for (char ch = 'A'; ch <= 'D'; ch++) {
                    if (cur == ch) continue;
                    if (prev[j] == ch) continue;
                    if (j > 0 && prev[j - 1] == ch) continue;

                    bw.write(ch);
                    prev[j] = ch;
                    break;
                }

            }
            bw.newLine();
        }

        bw.flush();
    }
}
```

---

# ---------------------------- THANK YOU ----------------------------