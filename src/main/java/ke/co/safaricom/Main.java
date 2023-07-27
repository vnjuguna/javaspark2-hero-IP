package ke.co.safaricom;


import ke.co.safaricom.dao.HeroDao;
import ke.co.safaricom.dao.StrengthDao;
import ke.co.safaricom.models.Hero;
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

        get("/heroes/add", (request, response) -> {
            return SharedUtils.render(new HashMap<>(), "create-heroes.hbs");
        });

        post("/create-heroes", (request, response) -> {
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            int squad_id = Integer.parseInt(request.queryParams("squad_id"));
            int strength_id = Integer.parseInt(request.queryParams("strength_id"));
            int weakness_id = Integer.parseInt(request.queryParams("weakness_id"));

            Hero hero = new Hero();
            hero.setName(name);
            hero.setAge(age);
            hero.setSquad_id(squad_id);
            hero.setStrength_id(strength_id);
            hero.setWeakness_id(weakness_id);

            // Assuming there is a valid HeroDao class with a create() method to save the hero object
            HeroDao.create(hero);

            response.redirect("/");
            return null;
        });

    }
}
