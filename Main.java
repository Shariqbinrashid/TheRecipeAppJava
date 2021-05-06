import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.List;

public class Main {

	
	
	List<Recipe> recipes = new ArrayList<Recipe>();
	List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public void readIngredients() {
		try {
			
            File f = new File("D:\\SWEDEN\\harris\\assignment4\\ingredients.txt");
            Scanner sc = new Scanner(f);


            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] details = line.split(",");
                String unit = details[0];
                String name = details[1];
                int price = Integer.parseInt(details[2]);
                Ingredient p = new Ingredient(name, unit, price);
                ingredients.add(p);
            }
           
        } catch (FileNotFoundException e) {         
            e.printStackTrace();
        }
	}
	
	public void readrecipes() {

		try {
            File f = new File("D:\\SWEDEN\\harris\\assignment4\\recipes.txt");
            Scanner sc = new Scanner(f);

outer:
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] details = line.split(",");
                String name = details[0];
                String portion = details[1];
                String comments = details[3];
                String ingredient = details[2];
                
                List<Ingredient> reciepeIngredients = new ArrayList<Ingredient>();
                List amount = new ArrayList();
                
                
                String[] ing =ingredient.split(";");
               
                for(String p: ing) {
                	String[] ing2=p.split(":");
                	int am=Integer.parseInt(ing2[0]);
                	String ingname=ing2[1];
                
                	for (Ingredient temp : ingredients) {
                		
                        if(ingname.equals(temp.getName())) {
                        	reciepeIngredients.add(temp);
                        	amount.add(am);
                        }
                    }
                	
                }

                
                Recipe p = new Recipe(name, portion, comments,reciepeIngredients,amount);
                recipes.add(p);      
            }
           
        /* getting ingredients
            for(Recipe p: recipes){
            	for(Ingredient i:p.getRecipeIngredients()) {
            		System.out.println(""+i.getUnit()+i.getName()+p.getAmountList().get(p.getAmount(i)));
            	}
            }         */
            
        } catch (FileNotFoundException e) {         
            e.printStackTrace();
        }
	}

public void updateRecipes() {
	File fold=new File("D:\\SWEDEN\\harris\\assignment4\\recipes.txt");
	fold.delete();
	File fnew=new File("D:\\SWEDEN\\harris\\assignment4\\recipes.txt");


	try {
	    FileWriter f2 = new FileWriter(fnew, false);
	    
	    int count=0;
	    String ing="";
	    for (Recipe p: recipes) {
	    	
	    	for (Ingredient i : p.getRecipeIngredients()) {
	    		   
    				ing=ing.concat(""+p.getAmountList().get(p.getAmount(i))).concat(":").concat(i.getName());
    				
    				if(i!=p.getRecipeIngredients().get(p.getRecipeIngredients().size()-1)) {
    					ing.concat(";");
    				}
    				 
    			
		    }
	    	f2.write(p.getName()+","+p.getNoOfPortion()+","+ing+","+p.getComments()+"\n");
	    }
	    
	    f2.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}    
}

public void updateIng()
{
	File fold=new File("D:\\SWEDEN\\harris\\assignment4\\ingredients.txt");
	fold.delete();
	File fnew=new File("D:\\SWEDEN\\harris\\assignment4\\ingredients.txt");


	try {
	    FileWriter f2 = new FileWriter(fnew, false);
	    
	    
	   
	    	
	    	for (Ingredient i :ingredients) {
	    		f2.write(i.getUnit()+","+i.getName()+","+i.getInprice()+"\n");
		
		    }
  
	    
	    
	    f2.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}    
}
public void serachStrategy(searchStrategy s) {
		s.search(recipes);
		
	}

public void case1() {
	Scanner s = new Scanner(System.in);
	System.out.println(" All recipes ");
	int count=1;
	for(Recipe p: recipes){
		System.out.println(count+"- "+p.getName());
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
		count++;
    }    
	
	
}

public void case2() {
	Scanner aaa = new Scanner(System.in);
	
	System.out.println(" Adding recipes ");
	System.out.println(" Enter  name: ");
	String nam=aaa.nextLine();
	System.out.println(" Enter  portion: ");
	String porr=aaa.nextLine();
	System.out.println(" Enter  indgredients in format : exapmle(1:flour;2:cream;1:cinnamon) ");
	String inggg=aaa.nextLine();
	System.out.println(" Enter  comments in format  : exapmle(Mix everything;Wait one day;Make figures) ");
	String comm=aaa.nextLine();
	
	String[] in =inggg.split(";");
	
	List<Ingredient> ingredientsadd = new ArrayList<Ingredient>();
	 List amount = new ArrayList();
	for(String pp: in) {
    	String[] ing2=pp.split(":");
    	int am=Integer.parseInt(ing2[0]);
    	String ingname=ing2[1];
    
    	for (Ingredient temp : ingredients) {
    		
            if(ingname.equals(temp.getName())) {
            	ingredientsadd.add(temp);
            	amount.add(am);
            }
        }
    	
    }
	Recipe pp=new Recipe(nam,porr,comm,ingredientsadd,amount);
	recipes.add(pp);
	System.out.println(pp.getName()+" - Recipe added");
}

public void case3() {
	Scanner aaaa = new Scanner(System.in);
	
	System.out.println(" Deleting recipes ");
	System.out.println(" Enter  name: ");
	String nammm=aaaa.nextLine();
	Recipe chf=null;
	boolean chee=false;
	for(Recipe p:recipes) {
		if(p.getName().equals(nammm)) {
			System.out.println(p.getName()+" - Recipe deleted");
			chf=p;
			chee=true;
			
			
		}
			
	}
	
	if(chee)
	 recipes.remove(chf);
	else
		System.out.println("Recipe not exist");
}
	
public void case4() {
	System.out.println("Enter 1 to search by name and 2 to search by max price");
	Scanner kk = new Scanner(System.in);
	int hh = kk.nextInt();
	
	if(hh==1) {
		System.out.println("Enter recipie name");
		Scanner kkk = new Scanner(System.in);
		String nm= kkk.nextLine();
		serachStrategy(new nameStrategy(nm));
	}
	else {
		serachStrategy(new priceStretegy());
	}
}

public void case5() {
	System.out.println(" All Ingredients ");
	int count=1;
	for(Ingredient p: ingredients){
		System.out.println(count+"- "+p.getName());
		System.out.println("Unit: "+p.getUnit());
		System.out.println("Price: "+p.getInprice());
    	
    	System.out.println("***************");
		System.out.println("");
		count++;
    }  
}

public void case6() {
	System.out.println(" View particular Ingredient details ");
	System.out.println(" Enter Ingredient name ");
	Scanner sc = new Scanner(System.in);
	String ingg = sc.nextLine();
	
	boolean check=false;
	for(Ingredient p: ingredients){
		  if(p.getName().equals(ingg)){
			  System.out.println(""+p.getName());
				System.out.println("Unit: "+p.getUnit());
				System.out.println("Price: "+p.getInprice());
            	
            	System.out.println("***************");
        		System.out.println("");
        		check=true;
		  }
		  
    }    
	if (check==false) {
		System.out.println("Ingredient not found");
		System.out.println("***************");
		System.out.println("");
	}
}

public void case7() {
	Scanner haha = new Scanner(System.in);
	Scanner hahaa = new Scanner(System.in);
	
	System.out.println(" Adding ingredient ");
	System.out.println(" Enter  name: ");
	String ingname=haha.nextLine();
	System.out.println(" Enter  unit: ");
	String ingunit=haha.nextLine();
	System.out.println(" Enter price");
	int ingprice=hahaa.nextInt();
	
	Ingredient iadd=new Ingredient(ingname,ingunit,ingprice);
	
	ingredients.add(iadd);
	System.out.println(iadd.getName()+" -Ingredient added");
}

public void case8() {
	Scanner hahai = new Scanner(System.in);
	System.out.println(" Deleting ingredient ");
	System.out.println(" Enter  name: ");
	String ingdte=hahai.nextLine();
	Ingredient jkl=null;
	for(Ingredient i: ingredients) {
		if(i.getName().equals(ingdte))
			jkl=i;
	}
	if(jkl==null)
		System.out.println(" ingredient not found ");
	else
	{
		ingredients.remove(jkl);
		System.out.println(" ingredient deleted ");
		
	}
}

public void case9() {
	System.out.println(" Make specefic recipie according to portion needed ");
	System.out.println(" Enter Recipie name ");
	Scanner rr = new Scanner(System.in);
	String rrname = rr.nextLine();
	boolean ch=false;
	for(Recipe p: recipes){
		if(p.getName().equals(rrname)) {
			ch=true;
			System.out.println(" Basic potion for this recpie is  "+p.getNoOfPortion());
			 System.out.println(" Enter  portion needed");
			 int bb=rr.nextInt();
			 p.getSpecificRecipe(bb);	
		}
		
	}

	if(!ch)
		System.out.println("Reciepe dont exist in our database");
}

public void menu() {
		int n;
		System.out.println("****** Welcome to Recepie App *******");
outer:
				
		while(true) {
			System.out.println("Menu: ");
			System.out.println("press 1 to view all recipies");
			System.out.println("press 2 to add recipie");
			System.out.println("press 3 to delete recipie");
			System.out.println("press 4 to search recipie");
			System.out.println("press 5 to view all avaialable ingredients");
			System.out.println("press 6 to view particular ingredient details");
			System.out.println("press 7 to add ingredient");
			System.out.println("press 8 to delete ingredient");
			System.out.println("press 9 to Look at a particular recipe with specific portion");
			System.out.println("press 0 to exit");
			Scanner s = new Scanner(System.in);
	        n = s.nextInt();
	        if(n<0 || n>9) {
	        	System.out.println("Wrong input Enter again ");
	        	continue;
	        }
	        else if(n==0) {
	        	
	        	break;
	        	}
	        else {
	        	int j;
	        	int count=1;
	        	switch(n) {
	        	
				case 1:
					case1();
					
					System.out.println("Enter 0 to exit or any number to go back to main menu:");
					j = s.nextInt();
					
					if(j==0) {
						 break outer;
					}
					else
					{
						continue outer;
					}
					
				case 2:
					
					case2();
					System.out.println("Enter 0 to exit or any number to go back to main menu:");
					j = s.nextInt();
					
					if(j==0) {
						 break outer;
					}
					else
					{
						continue outer;
					}
					
				case 3:
					
				    case3();
					System.out.println("Enter 0 to exit or any number to go back to main menu:");
					j = s.nextInt();
					
					if(j==0) {
						 break outer;
					}
					else
					{
						continue outer;
					}
				case 4:
					
				case4();
					
					System.out.println("Enter 0 to exit or any number to go back to main menu:");
					j = s.nextInt();
					
					if(j==0) {
						 break outer;
					}
					else
					{
						continue outer;
					}
				case 5:
					  
				case5();
					System.out.println("Enter 0 to exit or any number to go back to main menu:");
					j = s.nextInt();
					
					if(j==0) {
						 break outer;
					}
					else
					{
						continue outer;
					}
					
				case 6:
				case6();
					System.out.println("Enter 0 to exit or any number to go back to main menu:");
					j = s.nextInt();
					
					if(j==0) {
						 break outer;
					}
					else
					{
						continue outer;
					}
					
				case 7:
					
				case7();
					System.out.println("Enter 0 to exit or any number to go back to main menu:");
					j = s.nextInt();
					
					if(j==0) {
						 break outer;
					}
					else
					{
						continue outer;
					}
				case 8:
					
				case8();
					System.out.println("Enter 0 to exit or any number to go back to main menu:");
					j = s.nextInt();
					
					if(j==0) {
						 break outer;
					}
					else
					{
						continue outer;
					}
				case 9:
				     case9();
					
					
					System.out.println("Enter 0 to exit or any number to go back to main menu:");
					j = s.nextInt();
					
					if(j==0) {
						 break outer;
					}
					else
					{
						continue outer;
					}
					
			}
	        
	        }        
	        
		}
		
		System.out.println("Thank you !!!");
		
	}
	
	public static void main(String[] args) {
		
		Main m=new Main();
		m.readIngredients();
		m.readrecipes();
		m.menu();
		//m.updateRecipes();
		m.updateIng();
	}

}
