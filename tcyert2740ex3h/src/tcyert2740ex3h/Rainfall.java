package tcyert2740ex3h;

public class Rainfall {
	private double [] rainfall; //reference obj
	
	public Rainfall(double[] r) {
		rainfall = new double[r.length];
		
		for(int index = 0; index < r.length; index++){
			this.rainfall[index] = r[index];		
		}
	}
	public Rainfall(String[] r) {
		rainfall = new double[r.length];
		
		for(int index = 0; index < r.length; index++){
			this.rainfall[index] = Double.parseDouble(r[index]);	
		}
	}
	public double getTotal() {
	      double total = 0.0;
	      // Add up all the values
	      for (double value : rainfall){
	    	  total += value; 
	      }
	      return total;
	}
	public double getAverage() {
		//calculate average and return value
		return this.getTotal() / rainfall.length;
	}
	public double getHighest() {
	    double high = rainfall[0];
	    //loop to find highest value
	    for (int index = 1; index < rainfall.length; index++){
	       if (rainfall[index] > high)
	          high = rainfall[index];
	    }
	    return high;
	}
	public double getLowest() {
	    double low = rainfall[0];
	    //loop to find lowest value
	    for (int index = 1; index < rainfall.length; index++){
	       if (rainfall[index] < low)
	          low = rainfall[index];
	    }
		return low;
	}
}
