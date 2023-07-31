package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import ke.co.safaricom.models.Weakness;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class WeaknessDao {

    private static final Sql2o sql2o = DatabaseConfig.getDatabase();

    /* Create Weakness
    List available strengths
    Update Weakness (name and score)
    Update Weakness details
    Delete Weakness
    */

    public static void create(Weakness weakness) {
        try (Connection connection = sql2o.open()) {
            String query = " insert into weakness (name, score) VALUES (:name,:score);";
            connection.createQuery(query)
                    .addParameter("name", weakness.getName())
                    .addParameter("score", weakness.getScore())
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
