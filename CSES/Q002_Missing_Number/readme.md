# CSES Problem: Missing Number

This repository contains the solution for the "Missing Number" problem from the [CSES Problem Set](https://cses.fi/problemset/task/1083).

## Problem Description
You are given a range of numbers between $1$ and $n$, but one number is missing. Your task is to identify that missing number given the $n-1$ numbers present in the input.

### Constraints
* $2 \le n \le 2 \cdot 10^5$

### Example
**Input:**
5
2 3 1 5

**Output:**
4


## Solution Approach
The solution uses the **XOR operation** to find the missing number efficiently.

* **Logic:** The XOR property $A \oplus A = 0$ and $A \oplus 0 = A$ is utilized. By XORing all numbers from $1$ to $n$ and then XORing that result with all the numbers provided in the input, the duplicate numbers cancel each other out, leaving only the missing number.
* **Complexity:** This approach has a time complexity of $O(n)$ and a space complexity of $O(1)$, making it extremely efficient for the given constraints.

## Code Implementation (Java)
```java
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        // Start XOR with n, then XOR with all numbers from 1 to n-1
        // and all input numbers provided.
        int xor = n;

        for (int i = 1; i < n; i++) {
            xor ^= i ^ sc.nextInt();
        }

        System.out.println(xor);
    }
}
```
---
# ---------------------------ALL THE BEST---------------------------