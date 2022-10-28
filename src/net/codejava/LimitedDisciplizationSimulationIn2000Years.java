package net.codejava;
import java.util.ArrayList;
import java.util.List;

public class LimitedDisciplizationSimulationIn2000Years {
		
	LimitedDisciplizationSimulationIn2000Years() {
		
	}
	
	static int HowManyYearsBeforeTotalConversion() {
		double disciples = 13;
		int totalYears = 0;
		int yearCount = 1;
		int genCount = 0;
		double[] generation = new double[1000];
		while(disciples < 2300000000L) {
			//erasing perished disciple generations from the total count
			if(totalYears % 72 == 0) {
				disciples = disciples - generation[genCount];
			}
			//incrementing the generation count by one when 30 years passes and a new gen is born
			if(totalYears % 30 == 0) {
				genCount++;
				//System.out.println("bababooey");
				generation[genCount] = disciples - 1;
			}
			//find whether three years of training have passed and the first generation's years have exceeded 17, allowing them to disciplize others
			if(yearCount > 2 && totalYears >= 18) {
				disciples = disciples * 1.0781;
				//System.out.println(disciples);
				yearCount = 0;
			}
			//disciples = disciples * 3;
			yearCount++;
			totalYears++;
		}
		/*for(int i = 0; i < generation.length; i++) {
			System.out.println(generation[i]);
		}*/
		//System.out.println(generation);
		return totalYears;
	}

	public static void main(String[] args) {
		System.out.println("In this more accurate simulation, it should take " + HowManyYearsBeforeTotalConversion() + " years before the entire world has been disciplized.");
	}
}

