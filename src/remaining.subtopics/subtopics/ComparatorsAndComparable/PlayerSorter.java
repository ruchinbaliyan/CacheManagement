package remaining.subtopics.ComparatorsAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PlayerAgeC implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return Integer.compare(p1.getAge(),p2.getAge());
    }
}

public class PlayerSorter {

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(59, "Roger", 19);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);


        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam);

//        Collections.sort(footballTeam, new Comparator<Player>() {
//            @Override
//            public int compare(Player p1, Player p2) {
//                return Integer.compare(p1.getAge(),p2.getAge());
//            }
//        });

      //  Collections.sort(footballTeam,new PlayerRankingComparator());
        System.out.println("After Sorting : " + footballTeam);
    }

}
