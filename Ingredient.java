
public class Ingredient {
	String name;
	String unit;
	int inprice;
	
	
	public Ingredient(String name, String unit, int inprice) {
		this.name = name;
		this.unit = unit;
		this.inprice = inprice;
	}
	
	//setter getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getInprice() {
		return inprice;
	}
	public void setInprice(int inprice) {
		this.inprice = inprice;
	}
	
}
