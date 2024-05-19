package exercise.generics.etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> sportsStars = new ArrayList<>();

        sportsStars.add("kim yeon koung");
        sportsStars.add("nana");
        sportsStars.add("mya");
        sportsStars.add("hel");
        sportsStars.add("ho");

        for (int i = 0; i < sportsStars.size(); i++) {
            System.out.println(sportsStars.get(i));
        }

        Iterator<String> sportsStarIterator = sportsStars.iterator();

        while (sportsStarIterator.hasNext()) {
            System.out.println(sportsStarIterator.next());
        }

        for (String sportsStar : sportsStars){
            System.out.println(sportsStar);
            if (sportsStar == "ho") {
                sportsStars.remove(sportsStar);
            }
        }

        Map<Integer, String> fruits = new HashMap<>();

        fruits.put(0, "귤");
        fruits.put(1, "딸기");
        fruits.put(2, "복숭아");

        for(int i = 0 ;i<fruits.size();i++){
            System.out.println(fruits.get(i));
        }

        Iterator<String> fruitsIterator = fruits.values().iterator();

        while(fruitsIterator.hasNext()){
            System.out.println(fruitsIterator.next());
        }

        for(int key : fruits.keySet()){
            System.out.println(fruits.get(key));
        }

        for (String fruit: fruits.values()){
            System.out.println(fruit);
        }

    }
}
