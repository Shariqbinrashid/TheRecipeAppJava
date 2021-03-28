import java.util.ArrayList;
import java.util.List;

public class priceStretegy implements searchStrategy {

	@Override
	public void search(List <Recipe> recipe) {
		
		int price=0;
		int max=0;
		Recipe j = null;
		for(Recipe p: recipe){
				
			
				max=p.getPrice();
				if(price<max) {
					price=max;
					j=p;
				}

		}
		System.out.println("- "+j.getName());
		System.out.println("Portion "+j.getNoOfPortion());
		System.out.println("Ingredients: ");
    	for(Ingredient i:j.getRecipeIngredients()) {
    		
    		System.out.println(i.getName()+" "+j.getAmountList().get(j.getAmount(i))+" "+i.getUnit()+" Price: (per "+i.getUnit()+" "+i.getInprice()+")");
    		
    	}
    	System.out.println("Comments: ");
    	String []com=j.getComments().split(";");
    	for(String i: com) {
    		System.out.println("- "+i);
    	}
    	System.out.println("Price: "+j.getPrice());
    	System.out.println("***************");
		System.out.println("");
		
	}


}
