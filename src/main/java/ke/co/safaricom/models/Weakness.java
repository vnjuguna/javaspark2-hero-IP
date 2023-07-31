package ke.co.safaricom.models;

public class Weakness {
    private int id;
    private String name;

    public Weakness(int id, String name, int score, boolean deleted) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.deleted = deleted;
    }

    public Weakness() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    private int score;
    private boolean deleted;

}
