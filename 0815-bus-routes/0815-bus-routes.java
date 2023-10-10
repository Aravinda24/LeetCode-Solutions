class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
       if (source == target)
			return 0;

		HashMap<Integer, HashSet<Integer>> hashMap = new HashMap();

		for (int i = 0; i < routes.length; i++) {

			for (int j = 0; j < routes[i].length; j++) {

				if (hashMap.containsKey(routes[i][j])) {
					HashSet<Integer> buses = hashMap.get(routes[i][j]);
					buses.add(i);
					hashMap.put(routes[i][j], buses);
				} else {
					HashSet<Integer> buses = new HashSet<Integer>();
					buses.add(i);
					hashMap.put(routes[i][j], buses);
				}

			}
		}

		int noOfBusTaken = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		HashSet<Integer> checked = new HashSet<Integer>();

		while (!q.isEmpty()) {

			noOfBusTaken++;
			int qSize = q.size();

			for (int k = 0; k < qSize; k++) {
				int currentStop = q.poll();

				HashSet<Integer> buses = hashMap.get(currentStop);

				for (int bus : buses) {
					if (checked.contains(bus))
						continue;
					checked.add(bus);
					for (int busStops : routes[bus]) {

						if (target == busStops) {
							return noOfBusTaken;
						} else {
							q.add(busStops);
						}

					}
				}
			}

		}

		return -1;
    }
}