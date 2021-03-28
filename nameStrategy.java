import java.util.ArrayList;
import java.util.List;
public class nameStrategy implements searchStrategy {
	private String name;
	
	
	public nameStrategy(String name) {
		this.name = name;
	}


	@Override
	public void search(List <Recipe> recipe) {
		boolean ch=false;
		for(Recipe p: recipe){
			if(p.getName().equals(name)) {
				ch=true;
				System.out.println("- "+p.getName());
				System.out.println("Portion "+p.getNoOfPortion());
        		System.out.println("Ingredients: ");
            	for(Ingredient i:p.getRecipeIngredients()) {
            		
            		System.out.println(i.getName()+" "+p.getAmountList().get(p.getAmount(i))+" "+i.getUnit()+" Price: (per "+i.getUnit()+" "+i.getInprice()+")");
            		
            	}
            	System.out.println("Comments: ");
            	String []com=p.getComments().split(";");
            	for(String i: com) {
            		System.out.println("- "+i);
            	}
            	System.out.println("Price: "+p.getPrice());
            	System.out.println("***************");
        		System.out.println("");
			}
		}
		if(ch==false) {
			System.out.println("Recipe not found");
	    	System.out.println("***************");
			System.out.println("");
		}
			
	}
}
