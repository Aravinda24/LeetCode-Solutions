class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
       if (source == target) return 0;
 
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();

        Set<Integer> visitedRoutes = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);

        int busesTaken = 0;

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            busesTaken++;
            
            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                List<Integer> routesForCurrentStop = stopToRoutes.get(currentStop);
                
                if (routesForCurrentStop == null) continue;
                
                for (int route : routesForCurrentStop) {
                    if (visitedRoutes.contains(route)) continue;
                    
                    visitedRoutes.add(route);
                    
                    for (int nextStop : routes[route]) {
                        if (nextStop == target) return busesTaken;
                        
                        queue.offer(nextStop);
                    }
                }
            }
        }
        
        return -1; 
    }
}