class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
     if(source == target)return 0;

		HashMap<Integer, List<Integer>> hashMap = new HashMap();

		for (int i = 0; i < routes.length; i++) {

			for (int j = 0; j < routes[i].length; j++) {

				if (hashMap.containsKey(routes[i][j])) {
					List<Integer> buses = hashMap.get(routes[i][j]);
					buses.add(i);
					hashMap.put(routes[i][j], buses);
				} else {
					List<Integer> buses = new ArrayList <Integer>();
					buses.add(i);
					hashMap.put(routes[i][j], buses);
				}
				

			}
		}

		int noOfBusTaken = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(source);
		HashSet<Integer> checked = new HashSet<Integer>();

		 while (!q.isEmpty()) {
	            int size = q.size();
	            noOfBusTaken++;
	            
	            for (int i = 0; i < size; i++) {
	                int currentStop = q.poll();
	                List<Integer> routesForCurrentStop = hashMap.get(currentStop);
	                
	                if (routesForCurrentStop == null) continue;
	                
	                for (int route : routesForCurrentStop) {
	                    if (checked.contains(route)) continue;
	                    
	                    checked.add(route);
	                    
	                    for (int nextStop : routes[route]) {
	                        if (nextStop == target) return noOfBusTaken;
	                        
	                        q.offer(nextStop);
	                    }
	                }
	            }
	        }
	        
	        return -1; 
    }
}