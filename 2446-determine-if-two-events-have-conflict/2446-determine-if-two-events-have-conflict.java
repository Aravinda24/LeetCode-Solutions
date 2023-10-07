class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
        String event1StartTime = event1[0];
		event1StartTime = event1StartTime.replace(':', '.');
		Float event1StartTimeF = Float.parseFloat(event1StartTime);
		
		String event1EndTime = event1[1];
		event1EndTime = event1EndTime.replace(':', '.');
		Float event1EndTimeF = Float.parseFloat(event1EndTime);
		
		String event2StartTime = event2[0];
		event2StartTime = event2StartTime.replace(':', '.');
		Float event2StartTimeF = Float.parseFloat(event2StartTime);
		
		String event2EndTime = event2[1];
		event2EndTime = event2EndTime.replace(':', '.');
		Float event2EndTimeF = Float.parseFloat(event2EndTime);
		
		
		
		

		if (event1StartTimeF < event2StartTimeF) {

			if (event1EndTimeF < event2StartTimeF) {

				return false;
			}
		}

		else if (event2StartTimeF < event1StartTimeF) {

			if (event2EndTimeF < event1StartTimeF) {

				return false;
			}
		}

		return true;

    }
}