# CSES Problem: Coin Piles

This repository contains the solution for the **"Coin Piles"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1754).

## Problem Description

You are given two coin piles containing **a** and **b** coins.

In one move, you may perform **one** of the following operations:

* Remove **1** coin from the first pile and **2** coins from the second pile.
* Remove **2** coins from the first pile and **1** coin from the second pile.

Your task is to determine whether it is possible to **empty both piles exactly**.

### Constraints

* $1 \le t \le 10^5$
* $0 \le a, b \le 10^9$

### Example

**Input:**
```text
3
2 1
2 2
3 3
```

**Output:**
```text
YES
NO
YES
```

## Solution Approach

The solution is based on two mathematical observations.

### Logic

* Each move removes exactly **3 coins** in total.
    * Therefore, the total number of coins (`a + b`) must be divisible by **3**.
* Also, one pile cannot contain more than **twice** as many coins as the other.
    * Otherwise, the smaller pile would become empty before the larger one, making it impossible to remove all coins.
    * This condition can be written as:

    * `max(a, b) ≤ 2 × min(a, b)`

If **both** conditions are satisfied, it is possible to empty both piles; otherwise, it is not.

### Complexity

* **Time Complexity:** `O(1)` per test case
* **Space Complexity:** `O(1)`

## Code Implementation (Java)

```java
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long min = Math.min(a, b);
            b = Math.max(a, b);
            a = min;

            if (((a + b) % 3 == 0) && (a << 1) >= b)
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        bw.flush();
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------