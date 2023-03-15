public class Person {
    private String name;
    private int score;

    // Constructor
    public Person (String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Name getter method
    public String getName () {
        return this.name;
    }

    // Score getter method
    public int getScore () {
        return this.score;
    }

    // Name setter method
    public void setName (String name) {
        this.name = name;
    }

    // Score setter method
    public void setScore (int score) {
        this.score = score;
    }
}
