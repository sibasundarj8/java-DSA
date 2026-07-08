# CSES Problem: Bit Strings

This repository contains the solution for the **"Bit Strings"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1617).

## Problem Description

A **bit string** is a string consisting only of the characters **0** and **1**.

Given an integer **n**, determine the total number of bit strings of length **n**. Since the answer can be very large, print it modulo **10<sup>9</sup> + 7**.

### Constraints

* $1 \le n \le 10^6$

### Example

**Input:**
```text
3
```

**Output:**
```text
8
```

## Solution Approach

The solution uses **Binary Exponentiation (Fast Exponentiation)** to efficiently compute:

\[
2^n \bmod (10^9 + 7)
\]

### Logic

* Every position in a bit string has **2 possible choices** (`0` or `1`).
* Therefore, the total number of bit strings of length `n` is:

    * $2^n$
* Since `n` can be as large as $10^6$, directly computing `2^n` is inefficient.
* Instead, Binary Exponentiation recursively computes the answer in logarithmic time:
    * Compute $2^(ⁿ/²)$.
    * Square the result.
    * If `n` is odd, multiply by `2`.
    * Apply modulo $10^9 + 7$ after every multiplication to prevent overflow.

This approach is significantly faster than multiplying `2` repeatedly.

### Complexity

* **Time Complexity:** `O(log n)`
* **Space Complexity:** `O(log n)` (due to recursion)

## Code Implementation (Java)

```java
import java.util.Scanner;

public class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();

        System.out.println(twoPow(n));
    }

    private static long twoPow(long n) {
        if (n < 63)
            return (1L << n) % MOD;

        long x = twoPow(n >> 1);
        x = (x * x) % MOD;

        return ((n & 1) == 1) ? (x << 1) % MOD : x;
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------