package net.codejava;

public class Salesman {
	
public String name;
public int salesTotal;
	
	Salesman(String name, int salesTotal) {
		this.name = name;
		this.salesTotal = salesTotal;
	}
	
	public static Salesman[] topFive(Salesman list[])
    {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].salesTotal > list[j + 1].salesTotal) {
                    // swap list[j+1] and list[j]
                    Salesman temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        for(int i = list.length - 1; i > -1; i--) {
            System.out.print(list[i].name + " - ");
	        System.out.println(list[i].salesTotal);
        }
        return list;
    }
	
	/*public String toString() {
		return "nah who needs a tostring when you can print within the method";
	}*/
	
	public static void main(String[] args) {
		Salesman biffteen = new Salesman("Biffteen", 33);
		Salesman gatherer = new Salesman("Gatherer", 57);
		Salesman grantson = new Salesman("Grantson", 24);
		Salesman spamton = new Salesman("Spamton", 97);
		Salesman thomathy = new Salesman("Thomathy", 76);
		Salesman salesmanList[] = new Salesman[] {biffteen, gatherer, grantson, spamton, thomathy};
		topFive(salesmanList);
		//System.out.println(salesmanList);
	}
}