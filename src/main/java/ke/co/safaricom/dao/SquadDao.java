package ke.co.safaricom.dao;

import ke.co.safaricom.config.DatabaseConfig;
import ke.co.safaricom.dto.SquadInfo;
import ke.co.safaricom.models.Hero;
import ke.co.safaricom.models.Squad;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class SquadDao {
    private static final Sql2o sql2o = DatabaseConfig.getDatabase();

    public static void create(Squad squad){
        try(Connection connection = sql2o.open()) {
            String query = "INSERT INTO squads (name, max_size, cause) VALUES (:name, :max_size, :cause);";
            connection.createQuery(query)
                    .addParameter("name", squad.getName())
                    .addParameter("max_size", squad.getMax_size())
                    .addParameter("cause", squad.getCause())
                    .executeUpdate();
        } catch(Exception exception){
            System.out.println(exception.getMessage());
        }

    } }
