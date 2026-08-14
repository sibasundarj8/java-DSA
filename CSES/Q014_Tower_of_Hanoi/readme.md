# CSES Problem: Tower of Hanoi

This repository contains the solution for the **"Tower of Hanoi"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/2165).

## Problem Description

The **Tower of Hanoi** consists of three stacks and `n` disks of different sizes. Initially, all disks are placed on the left stack in increasing order of size from top to bottom.

The goal is to move all the disks from the **left stack** to the **right stack** using the **middle stack**.

In each move:

* Only the uppermost disk of a stack can be moved.
* A larger disk cannot be placed on top of a smaller disk.
* The task is to find a sequence of moves that uses the **minimum possible number of moves**.

### Constraints

* $1 \le n \le 16$

### Example

**Input:**
```text
2
```

**Output:**
```text
3
1 2
1 3
2 3
```

## Solution Approach

The solution uses **recursion** based on the classic **Tower of Hanoi** algorithm.

### Logic

To move `n` disks from the source stack to the target stack:

1. Move the top `n - 1` disks from the source to the middle stack.
2. Move the largest disk from the source to the target stack.
3. Move the `n - 1` disks from the middle stack to the target stack.

This process is repeated recursively until there are no disks left to move.

The minimum number of moves required to transfer `n` disks is: $2^n - 1$

The recursive function uses three parameters representing the **source**, **middle**, and **target** stacks.

### Complexity

* **Time Complexity:** `O(2^n)` — exactly `2^n - 1` moves are printed.
* **Space Complexity:** `O(n)` — due to the recursive call stack.

## Code Implementation (Java)

```java
import java.io.*;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());

        bw.write((1 << n) - 1 + "\n");

        solve(1, 2, 3, n);

        bw.flush();
    }

    private static void solve(int s, int m, int t, int n) throws IOException {
        // Base case
        if (n == 0) return;

        // Move n - 1 disks from source to middle
        solve(s, t, m, n - 1);

        // Move the largest disk from source to target
        bw.write(s + " " + t + "\n");

        // Move n - 1 disks from middle to target
        solve(m, s, t, n - 1);
    }
}
```

---
# ---------------------------- THANK YOU ----------------------------