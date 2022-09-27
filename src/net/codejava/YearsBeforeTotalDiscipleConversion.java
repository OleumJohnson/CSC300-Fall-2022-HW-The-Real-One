package net.codejava;

public class YearsBeforeTotalDiscipleConversion {
	
	static int HowManyYearsBeforeTotalConversion() {
		long disciples = 13L;
		int totalYears = 0;
		//gotta throw an L at the end cause me not knowing I had to is an L moment
		while(disciples < 7700000000L) {
			disciples = disciples * 2;
			totalYears = totalYears + 3;
		}
		return totalYears;
	}
	
	static int HowManyTrainedForTotalConversionIn50Years() {
		long disciples = 13L;
		int totalYears = 0;
		int peakTraineesAmount = 0;
		
		//starting at 2 per disciple cause 0 and 1 would never work
		for(int traineesPerDisciple = 2; traineesPerDisciple < 10; traineesPerDisciple++) {
			while(disciples < 7700000000L) {
				if(totalYears > 50) {
					//System.out.println(traineesPerDisciple + " got to year 50");
					if(peakTraineesAmount < traineesPerDisciple) {
						peakTraineesAmount = traineesPerDisciple;
					}
					break;
				}
				disciples = disciples * traineesPerDisciple;
				//System.out.println("bababooey");
				totalYears = totalYears + 3;
			}
			//System.out.println(traineesPerDisciple + " trainees per disciple got to " + disciples + " before reaching 7.7 bil.");
			disciples = 13L;
			totalYears = 0;
		}
		return peakTraineesAmount;
		
		
		//int mindisciplestrained = 0;
		/*for(int disciplesTrainedPerDisciple = 2; disciplesTrainedPerDisciple < 10; disciplesTrainedPerDisciple++) {
			for(int years = 2; years < 10; years++) {
				while(disciples < 7700000000L) {
					if(totalYears == 50 && disciples == 7700000000L) {
						System.out.println("It should take " + years + " years per disciple, as well as the number of disciples trained.");
						return disciplesTrainedPerDisciple;
					}
					disciples = disciples * disciplesTrainedPerDisciple;
					totalYears = totalYears + years;
				}
			}
		}*/
		
	}

	public static void main(String[] args) {
		System.out.println("It should take " + HowManyYearsBeforeTotalConversion() + " years before the entire world has been disciplized.");
		System.out.println("In order for the whole world to be disciplized in 50 years, " + HowManyTrainedForTotalConversionIn50Years() + " disciples should be trained together at a time.");
	}

}
