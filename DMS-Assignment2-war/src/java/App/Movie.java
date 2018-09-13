/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author nickyhe
 */
public class Movie {
    
    private String name;
    private String year;
    private String type;
    private String directors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }
   
    public String toString()
    {
        String description = name+" ("+year+"), ";
        description += "Genre: "+type+", ";
        description += "Directors: "+directors;
        
        return description;
    }
}
