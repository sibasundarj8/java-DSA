# CSES Problem: Gray Code

This repository contains the solution for the **"Gray Code"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/2205).

## Problem Description

A **Gray code** is a sequence of all **2ⁿ** binary strings of length **n** such that every pair of consecutive strings differs in **exactly one bit** (i.e., their Hamming distance is one).

Given an integer **n**, your task is to generate any valid Gray code sequence of length **n**.

### Constraints

* $1 \le n \le 16$

### Example

**Input:**
```text
2
```

**Output:**
```text
00
01
11
10
```

> **Note:** There can be multiple valid Gray code sequences. Any correct sequence is accepted.

## Solution Approach

The solution uses the **Binary Reflected Gray Code** formula to generate the sequence directly.

### Logic

* Iterate through all integers from `0` to `2ⁿ - 1`.
* For each integer `i`, compute its Gray code using the formula:

    * `gray = i ^ (i >> 1)`

* Convert the resulting number into its `n`-bit binary representation by checking each bit from the most significant bit to the least significant bit.
* Print each generated binary string.

This method guarantees that every pair of consecutive Gray codes differs by exactly one bit.

### Complexity

* **Time Complexity:** `O(n × 2ⁿ)`
* **Space Complexity:** `O(1)`

## Code Implementation (Java)

```java
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        br.close();

        int n = Integer.parseInt(st.nextToken());
        int m = 1 << n;

        for (int i = 0; i < n; i++) {
            int gray = i ^ (i >> 1);

            for (int j = n - 1; j >= 0; j--) {
                bw.write(((gray >> j) & 1) == 1 ? '1' : '0');
            }

            bw.newLine();
        }

        bw.flush();
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------