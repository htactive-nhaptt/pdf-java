package com.audit.export.App.dao;

import java.util.ArrayList;
import java.util.List;

public class TestDao {
    public   List<String[]> getFacts() {
        List<String[]> facts = new ArrayList<String[]>();
        facts.add(new String[] { "Oil Painting was invented by the Belgian van Eyck brothers Oil Painting was invented by the Belgian van Eyck brothers Oil Painting was invented by the Belgian van Eyck brothersOil Painting was invented by the Belgian van Eyck brothersOil Painting was invented by the Belgian van Eyck brothersOil Painting was invented by the Belgian van Eyck brothersOil Painting was invented by the Belgian van Eyck brothersOil Painting was invented by the Belgian van Eyck brothers", "art", "inventions",
                "science" });
        facts.add(new String[] { "The Belgian Adolphe Sax invented the Saxophone", "inventions", "music", "" });
        facts.add(new String[] { "11 sites in Belgium are on the UNESCO World Heritage List", "art", "history", "" });
        facts.add(new String[] { "Belgium was the second country in the world to legalize same-sex marriage","politics", "", "" });
        facts.add(new String[] { "In the seventies, schools served light beer during lunch", "health", "school",
                "beer" });
        facts.add(new String[] { "Belgium has the sixth fastest domestic internet connection in the world", "science",
                "technology", "" });
        facts.add(new String[] { "Belgium hosts the World's Largest Sand Sculpture Festival", "art", "festivals",
                "world championship" });
        facts.add(
                new String[] { "Belgium has compulsary education between the ages of 6 and 18", "education", "", "" });
        facts.add(new String[] {
                "Belgium also has more comic makers per square kilometer than any other country in the world", "art",
                "social", "world championship" });
        facts.add(new String[] {
                "Belgium has one of the lowest proportion of McDonald's restaurants per inhabitant in the developed world",
                "food", "health", "" });
        facts.add(new String[] { "Belgium has approximately 178 beer breweries", "beer", "food", "" });
        facts.add(new String[] { "Gotye was born in Bruges, Belgium", "music", "celebrities", "" });
        facts.add(new String[] { "The Belgian Coast Tram is the longest tram line in the world", "technology",
                "world championship", "" });
        facts.add(new String[] { "Stefan Everts is the only motocross racer with 10 World Championship titles.",
                "celebrities", "sports", "world champions" });
        facts.add(new String[] { "Tintin was conceived by Belgian artist Hergé", "art", "celebrities", "inventions" });
        facts.add(new String[] { "Brussels Airport is the world's biggest selling point of chocolate", "food",
                "world champions", "" });
        facts.add(new String[] { "Tomorrowland is the biggest electronic dance music festival in the world",
                "festivals", "music", "world champion" });
        facts.add(new String[] { "French Fries are actually from Belgium", "food", "inventions", "image:300dpi.png" });
        facts.add(new String[] { "Herman Van Rompy is the first full-time president of the European Council",
                "politics", "", "" });
        facts.add(new String[] { "Belgians are the fourth most money saving people in the world", "economy", "social",
                "" });
        facts.add(new String[] {
                "The Belgian highway system is the only man-made structure visible from the moon at night",
                "technology", "world champions", "" });
        facts.add(new String[] { "Andreas Vesalius, the founder of modern human anatomy, is from Belgium",
                "celebrities", "education", "history" });
        facts.add(
                new String[] { "Napoleon was defeated in Waterloo, Belgium", "celebrities", "history", "politicians" });
        facts.add(new String[] {
                "The first natural color picture in National Geographic was of a flower garden in Gent, Belgium in 1914",
                "art", "history", "science" });
        facts.add(new String[] { "Rock Werchter is the Best Festival in the World", "festivals", "music",
                "world champions" });

        // Make the table a bit bigger
        facts.addAll(facts);
        return facts;
    }
}
