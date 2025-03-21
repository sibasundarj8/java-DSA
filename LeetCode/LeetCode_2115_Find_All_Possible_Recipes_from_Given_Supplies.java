package LeetCode;/*
 *
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 *
 * # 2115. Find All Possible Recipes from Given Supplies
 *
 *   Q. You have information about different recipes. You are given a string array recipes and a 2D
 *      string array ingredients. The ith recipe has the name recipes[i], and you can create it if
 *      you have all the necessary ingredients from ingredients[i]. A recipe can also be an ingredient
 *      for other recipes, i.e., ingredients[i] may contain a string that is in recipes.
 *
 *      You are also given a string array supplies containing all the ingredients that you initially
 *      have, and you have an infinite supply of all of them.
 *
 *      Return a list of all the recipes that you can create. You may return the answer in any order.
 *
 *      Note that two recipes may contain each other in their ingredients.
 *   Ex.
 *      Input : recipes = ["bread","sandwich","burger"]
 *              ingredients = [["yeast","flour"],
 *                             ["bread","meat"],
 *                             ["sandwich","meat","bread"]]
 *              supplies = ["yeast","flour","meat"]
 *      Output: ["bread","sandwich","burger"]
 *      Explanation:
 *          —• We can create "bread" since we have the ingredients "yeast" and "flour".
 *          —• We can create "sandwich" since we have the ingredient "meat" and can create the
 *             ingredient "bread".
 *          —• We can create "burger" since we have the ingredient "meat" and can create the
 *             ingredients "bread" and "sandwich".
 */
import java.util.*;

public class LeetCode_2115_Find_All_Possible_Recipes_from_Given_Supplies {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Required Foods: ");
        String[] foods = sc.nextLine().split(" ");

        List<List<String>> ingredients = new LinkedList<>();
        for (String food : foods) {
            System.out.println("Ingredients of: " + food);
            String temp = sc.nextLine();
            ingredients.add(Arrays.asList(temp.split(" ")));
        }

        System.out.println("Enter Supplies: ");
        String[]supplies = sc.nextLine().split(" ");

        System.out.println(findAllRecipes(foods, ingredients, supplies));
    }

    /// Solution
    static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        HashSet<String> set = new HashSet<>(Arrays.asList(supplies));
        List<String> ans = new LinkedList<>();

        for (String recipe : recipes) {
            if (set.contains(recipe)) continue;
            for (int j = 0; j < n; j++) {
                boolean isPos = true;
                for (String s : ingredients.get(j))
                    if (!set.contains(s)) {
                        isPos = false;
                        break;
                    }
                if (isPos) {
                    set.add(recipes[j]);
                    ans.add(recipes[j]);
                }
            }
        }

        return ans;
    }
}
