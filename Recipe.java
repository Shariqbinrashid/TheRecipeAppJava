import java.util.ArrayList;
import java.util.List;

public class Recipe {
	String name;
	String noOfPortion;
	String comments;
	List<Ingredient> recipeIngredients = new ArrayList<Ingredient>();
	List amount= new ArrayList ();;
	int price;
	
	
	
	
	public Recipe(String name, String noOfPortion, String comments, List<Ingredient> recipeIngredients, List amount) {
		super();
		this.name = name;
		this.noOfPortion = noOfPortion;
		this.comments = comments;
		this.recipeIngredients = recipeIngredients;
		this.amount = amount;
	}
	//getter and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNoOfPortion() {
		return noOfPortion;
	}
	public void setNoOfPortion(String noOfPortion) {
		this.noOfPortion = noOfPortion;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getPrice() {
		price=0;
		for(int i = 0; i< recipeIngredients.size(); i++){
			  Ingredient str1 = recipeIngredients.get(i);
			  int str2 = (int) amount.get(i);
			
			  price+=str1.getInprice()*str2;
		
			}
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Ingredient> getRecipeIngredients() {
		return recipeIngredients;
	}
	public void setRecipeIngredients(List<Ingredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
	public List getAmountList() {
		return amount;
	}
	
	public int getAmount(Ingredient i) {
		return recipeIngredients.indexOf(i);
		
	}
	public void setAmount(List amount) {
		this.amount = amount;
	}

	/*getting ingredients of recipe
    for(Recipe p: recipes){
    	for(Ingredient i:p.getRecipeIngredients()) {
    		System.out.println(""+i.getName()+p.getAmountList().get(p.getAmount(i)));
    	}
    }      */    
	
	public void getSpecificRecipe(int por) {
		int basicpor;
		
		String b=noOfPortion.replaceAll("[^0-9]", "");
		basicpor=Integer.parseInt(b);
		if (por==basicpor) {
			System.out.println(" "+getName());
			System.out.println("Portion "+getNoOfPortion());
    		System.out.println("Ingredients: ");
        	for(Ingredient i:recipeIngredients) {
        		
        		System.out.println(i.getName()+" "+getAmountList().get(getAmount(i))+" "+i.getUnit()+" Price: (per "+i.getUnit()+" "+i.getInprice()+")");
        		
        	}
        	System.out.println("Comments: ");
        	String []com=getComments().split(";");
        	for(String i: com) {
        		System.out.println("- "+i);
        	}
        	System.out.println("Price: "+getPrice());
        	System.out.println("***************");
    		System.out.println("");
		}
		else
		{
			
			System.out.println(" "+getName());
			System.out.println("Portion "+por);
    		System.out.println("Ingredients: ");
        	for(Ingredient i:recipeIngredients) {
        		int p=(Integer) getAmountList().get(getAmount(i));
        		System.out.println(i.getName()+" "+p*por+" "+i.getUnit()+"  Price: (per "+i.getUnit()+" "+i.getInprice()+")");
        		
        	}
        	System.out.println("Comments: ");
        	String []com=getComments().split(";");
        	for(String i: com) {
        		System.out.println("- "+i);
        	}
        	System.out.println("Price: "+getPrice()*por);
        	
			
			System.out.println("***************");
			System.out.println("");
		}
	}

}
