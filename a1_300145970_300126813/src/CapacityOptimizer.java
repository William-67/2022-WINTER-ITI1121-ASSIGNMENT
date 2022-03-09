public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {
		ParkingLot lot = new ParkingLot(1);
		while (true){

			System.out.println("==== Setting lot capacity to: "+lot.getCapacity()+" ====");
			int total = 0;
			for (int i =1;i<NUM_RUNS+1;i++){
				int incomingQueueSize =0;
				long start = System.currentTimeMillis();

				int capacity = lot.getCapacity();
				lot = new ParkingLot(capacity);
				Simulator simulator = new Simulator(lot,hourlyRate,Simulator.SIMULATION_DURATION);
				simulator.simulate();

				incomingQueueSize = simulator.getIncomingQueueSize();

				total += incomingQueueSize;
				long end = System.currentTimeMillis();
				System.out.println("Simulation run "+i+" ("+(end - start)+"ms); Queue length at the end of simulation run: "+ incomingQueueSize);
			}
			System.out.println(" ");

			double average = (double)total/10;
			if (average<=THRESHOLD){
				break;
			}else{
				int capacity = lot.getCapacity();
				lot = new ParkingLot(capacity+1);
			}
		}
		return lot.getCapacity();
	}

	public static void main(String args[]) {

		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}