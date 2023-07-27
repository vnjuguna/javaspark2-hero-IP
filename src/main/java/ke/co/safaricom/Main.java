package ke.co.safaricom;


import ke.co.safaricom.dao.StrengthDao;
import ke.co.safaricom.models.Strength;
import ke.co.safaricom.utils.SharedUtils;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/", (request, response) -> {
            return SharedUtils.render(new HashMap<>(), "index.hbs");
        });
        get("/strength/add", (request, response) -> {
            return SharedUtils.render(new HashMap<>(), "create-strength.hbs");
        });
        post("/create-strength", (request, response) -> {
            String name = request.queryParams("name");
            int score = Integer.parseInt(request.queryParams("score"));

            Strength strength = new Strength();
            strength.setScore(score);
            strength.setName(name);

            StrengthDao.create(strength);

            response.redirect("/");
            return null;
        });
    }
}
