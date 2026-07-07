# CSES Problem: Two Knights

This repository contains the solution for the **"Two Knights"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1072).

## Problem Description

Given an integer **n**, for every board size **k × k** where **1 ≤ k ≤ n**, determine the number of ways to place **two knights** on the chessboard such that they **do not attack each other**.

_**Note:** there are two possibilities,_ 
* _position_A = **black** knight, position_B = **white** knight_
* _position_A = **white** knight, position_B = **black** knight_
* _it should be counted as **one knight placement** not two._

Two knights attack each other if one can reach the other using a standard knight's move in chess.

### Constraints

* $1 \le n \le 10000$

### Example

**Input:**
```text
8
```

**Output:**
```text
0
6
28
96
252
550
1056
1848
```

## Solution Approach

The solution is based on a **mathematical formula** rather than simulating knight placements.

**Simulation approach:** [➦[**Link**]](https://github.com/sibasundarj8/java-DSA/blob/main/Math_/Math_Non_Attacking_Black_and_White_Knights.java)

**Mathematical approach:**
* **Logic:**
    * For a `k × k` board, the total number of ways to place two knights is:
        * $\binom{k^2}{2} = \frac{k^2(k^2-1)}{2}$
    * Some of these placements are invalid because the knights attack each other.
    * Every `2 × 3` or `3 × 2` rectangle contributes **2 unique attacking placements**.
    * The total number of attacking placements is:
        * $2 \times (k-1) \times (k-2)$
    * Therefore, the required answer is:
        * $\frac{k^2(k^2-1)}{2} - 2(k-1)(k-2)$

The program computes this value independently for every board size from `1` to `n`.

### Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

## Code Implementation (Java)

```java
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());

        for (long i = 1; i <= n; i++) {
            long total_cells = i * i;
            long total_ways = (total_cells * (total_cells - 1)) / 2;
            long red_zone = (i >= 3) ? ((i - 2) * (i - 1) * 2) * 2 : 0;

            bw.write((total_ways - red_zone) + "\n");
        }

        bw.flush();
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------
