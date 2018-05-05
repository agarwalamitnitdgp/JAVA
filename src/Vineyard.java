/**
 * 
 */
package Wine;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author AmitKumarAgarwal
 *
 */
/**
 * Main Class Vineyard having main method
 * */
public class Vineyard {
		
	public static void main(String[] args) {
	
		 HashMap<String,ArrayList<String>> wineWishlist = new HashMap<>();  //Variable for Mapping for Wine and the persons who enjoyed it
	     Set<String> wineList = new HashSet<>();  //Variable for Total list of wines available
	     int totalWineSold = 0;  //Variable for counting of total wine sold
	     HashMap<String,ArrayList<String>> distinctWineList = new HashMap<>(); //Variable for Final map of wines and the 3 persons who enjoyed it 
	     
	     File file = new File("D:/person_wine_3.txt"); // Input file
	     
	     VineYardHelper vineYard = new VineYardHelper();
	     vineYard.createWineWishList(wineWishlist, wineList, file); // call function to create wine wishlist
	     totalWineSold = vineYard.createSoldWineList(wineWishlist, wineList, totalWineSold, distinctWineList); // call function to create final list of sold wines and person name
		 vineYard.outputFile(totalWineSold, distinctWineList); // print output file
	     
	}
}

