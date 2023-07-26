package ke.co.safaricom;

import ke.co.safaricom.dao.StrengthDao;
import ke.co.safaricom.models.Strength;

public class Main {
    public static void main(String[] args) {
        Strength strength = new Strength();
        strength.setName("SAMPLE");
        strength.setScore(5);
        StrengthDao.create(strength);

    }
}