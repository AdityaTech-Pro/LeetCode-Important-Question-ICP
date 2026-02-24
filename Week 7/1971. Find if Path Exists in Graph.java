import java.util.*;

class Solution {

    public boolean check(Map<Integer, List<Integer>> map,
                         int S, int D, boolean[] visited) {

        if (S == D) {
            return true;
        }

        if (visited[S]) {
            return false;
        }

        visited[S] = true;

        for (int neighbor : map.getOrDefault(S, new ArrayList<>())) {
            if (check(map, neighbor, D, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges,
                             int source, int destination) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];

        return check(map, source, destination, visited);
    }
}
