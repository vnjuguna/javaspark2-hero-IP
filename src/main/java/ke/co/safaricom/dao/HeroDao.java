package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import ke.co.safaricom.models.Hero;
import ke.co.safaricom.models.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.List;

public class HeroDao {
    private static final Sql2o sql2o = DatabaseConfig.getDatabase();

    public static void create(Hero hero) {
        // Implementation for creating a hero
    }

    public static List<Hero> findAllHeroesBySquadId(int squadId) {
        try (Connection connection = sql2o.open()) {
            String queryHeroes = "SELECT * FROM heroes WHERE NOT deleted AND squad_id = :squadId;";
            return connection.createQuery(queryHeroes)
                    .addParameter("squadId", squadId)
                    .executeAndFetch(Hero.class);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static void assignHeroToSquad(int heroId, int squadId) {
        try (Connection connection = sql2o.open()) {
            String queryHeroes = "UPDATE heroes SET squad_id = :squadId WHERE id = :heroId;";
            connection.createQuery(queryHeroes)
                    .addParameter("squadId", squadId)
                    .addParameter("heroId", heroId)
                    .executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
