# CSES Problem: Weird Algorithm

This repository contains the solution for the "Weird Algorithm" problem from the [CSES Problem Set](https://cses.fi/problemset/task/1068).

## Problem Description
Consider an algorithm that takes as input a positive integer $n$. If $n$ is even, the algorithm divides it by two, and if $n$ is odd, the algorithm multiplies it by three and adds one. The algorithm repeats this, until $n$ is one.

### Constraints
* $1 \le n \le 10^6$

### Example
**Input:**
3

**Output:**
3 10 5 16 8 4 2 1


## Solution Approach
The solution implements the simulation directly using a `while` loop that continues until $n$ reaches 1.

* **Data Type:** `long` is used for $n$ because intermediate values in the sequence (specifically when multiplying by 3) can exceed the range of a 32-bit integer.
* **Optimization:** Bitwise operators are used for efficiency:
    * `n & 1` checks if $n$ is odd.
    * `n >> 1` is equivalent to $n / 2$.

## Code Implementation (Java)
```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Use long to prevent integer overflow during the calculation
        long n = sc.nextLong();

        while (n != 1) {
            System.out.print(n + " ");
            if ((n & 1) == 1) { // Check if odd
                n = n * 3L + 1;
            } else { // Even
                n = n >> 1; // Equivalent to n / 2
            }
        }

        System.out.println(1);
    }
}
```
---
# ---------------------------ALL THE BEST---------------------------
