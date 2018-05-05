/**
 * 
 */
package Wine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author AmitKumarAgarwal
 *
 */
/**
 * Helper class to Main Vineyard Class
 */
public class VineYardHelper {

	/*
	 * Method to wine wishlist with the respective persons who liked it from the input file
	 */
	public void createWineWishList(HashMap<String,ArrayList<String>> wineWishlist, Set<String> wineList,File file) {
		 
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			    String line;
			    while((line = br.readLine()) != null){
			        String[] personNameAndWine = line.split("\\s");
			        String personName = personNameAndWine[0];
			        String wine = personNameAndWine[1];
			        
			        if(!wineWishlist.containsKey(wine)){
			            wineWishlist.put(wine, new ArrayList<String>());
			            
			        }
			        wineWishlist.get(wine).add(personName);
			        wineList.add(wine);
			    }
			    br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method to create final list of wines sold and its respective owners
	 */
	public int createSoldWineList(HashMap<String,ArrayList<String>> wineWishlist, Set<String> wineList,
			int totalWineSold,HashMap<String,ArrayList<String>> distinctWineList) {
		
		  try {
			for(String wine : wineList){
			        int counter = 0;
			        while(counter < 10){
			            String person = wineWishlist.get(wine).get(0);
			            if(!distinctWineList.containsKey(person)){
			                distinctWineList.put(person, new ArrayList<String>());
			            }
			            if(distinctWineList.get(person).size() < 3){
			                distinctWineList.get(person).add(wine);
			                totalWineSold++;
			                break;
			            }
			            counter++;
			       }
			    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return totalWineSold;
	}
	
	/*
	 * Method to create output file having total list of wines sold and map of wine sold and its owner 
	 */
	public void outputFile(int totalWineSold,HashMap<String,ArrayList<String>> distinctWineList) {
		
		  try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/amiagarw/Downloads/output_Person_Wine_List.txt")));
			    bw.write(String.valueOf(totalWineSold));
			    bw.newLine();
			    for(String person: distinctWineList.keySet()){
			        for(String wines: distinctWineList.get(person)){
			            bw.write(person + " " + wines);
			            bw.newLine();
			        }
			    }
			    bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
