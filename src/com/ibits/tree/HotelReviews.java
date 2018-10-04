package com.ibits.tree;

/*
 * https://www.interviewbit.com/problems/hotel-reviews/
 * Efficient Approach: Use Trie
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Reviews {
	int index, goodWordCount;

	public Reviews(int index, int goodWordCount) {
		this.index = index;
		this.goodWordCount = goodWordCount;
	}
}

public class HotelReviews {

	public static void main(String[] args) {
		ArrayList<String> reviews = new ArrayList<String>();
		reviews.add("water_is_cool");
		reviews.add("cold_ice_drink");
		reviews.add("cool_wifi_speed");
		String goodWords = "cool_ice_wifi";
		System.out.println(getGoodWordCount(goodWords, reviews));
	}

	public static ArrayList<Integer> getGoodWordCount(String goodWords, ArrayList<String> reviews) {
		HashMap<String, Integer> map = new HashMap<>();
		String goodWordsArr[] = goodWords.split("_");
		for (String word : goodWordsArr) {
			if (map.get(word) == null)
				map.put(word, 1);
			else
				map.put(word, map.get(word) + 1);
		}
		//System.out.println(map);
		
		int n = reviews.size();
		ArrayList<Reviews> sortedList = new ArrayList<>();
		for(int i=0;i<n;i++) {
			HashMap<String, Integer> reviewMap = new HashMap<>();
			String wordsInReview[] = reviews.get(i).split("_");
			for (String word : wordsInReview) {
				if (map.get(word) != null) {
					if(reviewMap.get(word)==null)
						reviewMap.put(word, 1);
					else
						reviewMap.put(word, reviewMap.get(word) + 1);
				}
			}
			//System.out.println(reviewMap);
			int countOfGoodWords = compareMaps(reviewMap, map);
			//System.out.println(countOfGoodWords);
			sortedList.add(new Reviews(i,countOfGoodWords));			
		}
		Collections.sort(sortedList, new Comparator<Reviews>() {
			@Override
			public int compare(Reviews o1, Reviews o2) {
				return o2.goodWordCount - o1.goodWordCount;
			}
		});
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(Reviews hotel : sortedList) {
			//System.out.println(hotel.goodWordCount + " " + hotel.index);
			result.add(hotel.index);
		}
		return result;
	}
	
	public static int compareMaps(HashMap<String, Integer> review, HashMap<String, Integer> goodWord) {
		int goodWordCount = 0;
		for(String good : goodWord.keySet()) {
			if(review.get(good)!=null)
				goodWordCount += review.get(good);
		}
		return goodWordCount;
	}

}
