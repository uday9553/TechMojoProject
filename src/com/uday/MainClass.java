package com.uday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.uday.model.*;

public class MainClass {
	// sample input as parameter
//	#sachin  #sachin  #sachin #virat #virat #virat #virat #dhoni
//	#dhoni #dhoni #dhoni #dhoni #sachin #virat #uday #uday #aaa
//	#bb #sachin  #sachin  #sachin #virat #virat #virat #virat #dhoni
//	#dhoni #dhoni #dhoni #dhoni #sachin #virat #uday #uday #aaa #bb 
//	#sachin  #sachin  #sachin #virat #virat #virat #virat #dhoni #dhoni
//	#dhoni #dhoni #dhoni #sachin #virat #uday #uday #aaa #bb #dhoni
//	#dhoni #sachin  #sachin  #sachin #virat #virat #virat #virat 
//	#dhoni #dhoni #dhoni #dhoni #dhoni #sachin #virat #uday #uday #aaa
//	#bb #sachin  #sachin  #sachin #virat #virat #virat #virat #dhoni
//	#dhoni #dhoni #dhoni #dhoni #sachin #virat #uday #uday #aaa #bb 
//	#sachin  #sachin  #sachin #virat #virat #virat #virat #dhoni #dhoni
//	#dhoni #dhoni #dhoni #sachin #virat #uday #uday #aaa #bb #dhoni #dhoni

	// map to maintain the hastag names and count
	static Map<String, Integer> setOfHashtags = null;
	// list used for the names and count of each name
	static List<HashTag> listOfHashtags = null;

	public static void main(String[] args) {
		setOfHashtags = new HashMap<>();
		// checking first whether we got values or not
		if (args.length > 0) {
			// iterating over the passed arguments
			for (int i = 0; i < args.length; i++) {
				// checking for hashtags
				if (args[i].charAt(0) == '#') {
					// checking whether it is already there in map or not
					if (setOfHashtags.containsKey(args[i])) {
						setOfHashtags.put(args[i], setOfHashtags.get(args[i]) + 1);
					} else {
						// if not present in map push and give one count
						setOfHashtags.put(args[i], 1);
					}
				}
			}
			// pusing all values to object that is HashTag class
			listOfHashtags = new ArrayList<>();
			for (Map.Entry<String, Integer> entry : setOfHashtags.entrySet()) {
				System.out.println(entry.getKey() + "  #" + entry.getValue());
				listOfHashtags.add(new HashTag(entry.getKey(), entry.getValue()));
			}

			// sorting based on the counts in reverse order
			Collections.sort(listOfHashtags);

			// after sorting if length is >=10 print top most 10 vaules
			if (listOfHashtags.size() >= 10) {
				for (int i = 0; i < 10; i++) {
					System.out.println(
							"name is " + listOfHashtags.get(i).getName() + " ### " + listOfHashtags.get(i).getCount());
				}
			} else {
				// else print all the values
				listOfHashtags.forEach(res -> {
					System.out.println("name is  " + res.getName() + "  ### " + res.getCount());
				});
			}

		}

	}

}