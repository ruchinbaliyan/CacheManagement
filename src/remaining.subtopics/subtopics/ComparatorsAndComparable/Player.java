package remaining.subtopics.ComparatorsAndComparable;

public class Player  implements Comparable<Player>{
        private int ranking;
        private String name;
        private int age;

        // constructor, getters, setters

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Player p) {

        if(this.getRanking()!=p.getRanking())
        return Integer.compare(getRanking(), p.getRanking());
        else
            return Integer.compare(this.getAge(),p.getAge());

    }

    @Override
    public String toString() {
        return "Player{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
