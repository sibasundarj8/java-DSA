# CSES Problem: Trailing Zeros

This repository contains the solution for the **"Trailing Zeros"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1618).

## Problem Description

Given an integer **n**, your task is to determine the number of **trailing zeros** in **n!** (n factorial).

A trailing zero is formed by a factor of **10**, which is the product of **2 × 5**. Since factorials contain far more factors of `2` than `5`, the number of trailing zeros is determined by the total number of factors of `5` present in `n!`.

### Constraints

* $1 \le n \le 10^9$

### Example

**Input:**
```text
20
```

**Output:**
```text
4
```

## Solution Approach

The solution counts the total number of factors of **5** in the factorial.

### Logic

* Every multiple of `5` contributes at least one factor of `5`.
* Multiples of `25` contribute an **additional** factor of `5`.
* Multiples of `125`, `625`, and so on contribute even more factors.
* Therefore, the total number of trailing zeros is calculated as:

$$
\left\lfloor\frac{n}{5}\right\rfloor +
\left\lfloor\frac{n}{25}\right\rfloor +
\left\lfloor\frac{n}{125}\right\rfloor + \cdots
$$

* Continue dividing by increasing powers of `5` until the power exceeds `n`.

This avoids computing the factorial directly, making the solution extremely efficient even for the largest input values.

### Complexity

* **Time Complexity:** `O(log₅ n)`
* **Space Complexity:** `O(1)`

## Code Implementation (Java)

```java
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        long count = 0;
        long base = 5;

        while (n >= base) {
            count += n / base;
            base *= 5;
        }

        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------