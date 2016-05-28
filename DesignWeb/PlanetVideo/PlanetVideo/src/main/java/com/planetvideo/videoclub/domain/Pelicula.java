package com.planetvideo.videoclub.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pelicula
{
	@JsonProperty("Released")
    private String Released;

	@JsonProperty("Type")
    private String Type;

	@JsonProperty("imdbVotes")
    private String imdbVotes;

	@JsonProperty("Runtime")
    private String Runtime;

	@JsonProperty("Response")
    private String Response;

	@JsonProperty("Poster")
    private String Poster;

	@JsonProperty("imdbID")
    private String imdbID;

	@JsonProperty("Country")
    private String Country;

	@JsonProperty("Title")
    private String Title;

	@JsonProperty("imdbRating")
    private String imdbRating;

	@JsonProperty("Year")
    private String Year;

	@JsonProperty("Rated")
    private String Rated;

	@JsonProperty("Actors")
    private String Actors;

	@JsonProperty("Plot")
    private String Plot;

	@JsonProperty("Metascore")
    private String Metascore;

	@JsonProperty("Writer")
    private String Writer;

	@JsonProperty("Genre")
    private String Genre;

	@JsonProperty("Language")
    private String Language;

	@JsonProperty("Awards")
    private String Awards;

	@JsonProperty("Director")
    private String Director;

	public Pelicula (){
		
	}
	
    public String getReleased ()
    {
		
        return Released;
    }

    public void setReleased (String Released)
    {
        this.Released = Released;
    }

    public String getType ()
    {
        return Type;
    }

    public void setType (String Type)
    {
        this.Type = Type;
    }

    public String getImdbVotes ()
    {
        return imdbVotes;
    }

    public void setImdbVotes (String imdbVotes)
    {
        this.imdbVotes = imdbVotes;
    }

    public String getRuntime ()
    {
        return Runtime;
    }

    public void setRuntime (String Runtime)
    {
        this.Runtime = Runtime;
    }

    public String getResponse ()
    {
        return Response;
    }

    public void setResponse (String Response)
    {
        this.Response = Response;
    }

    public String getPoster ()
    {
        return Poster;
    }

    public void setPoster (String Poster)
    {
        this.Poster = Poster;
    }

    public String getImdbID ()
    {
        return imdbID;
    }

    public void setImdbID (String imdbID)
    {
        this.imdbID = imdbID;
    }

    public String getCountry ()
    {
        return Country;
    }

    public void setCountry (String Country)
    {
        this.Country = Country;
    }

    public String getTitle ()
    {
        return Title;
    }

    public void setTitle (String Title)
    {
        this.Title = Title;
    }

    public String getImdbRating ()
    {
        return imdbRating;
    }

    public void setImdbRating (String imdbRating)
    {
        this.imdbRating = imdbRating;
    }

    public String getYear ()
    {
        return Year;
    }

    public void setYear (String Year)
    {
        this.Year = Year;
    }

    public String getRated ()
    {
        return Rated;
    }

    public void setRated (String Rated)
    {
        this.Rated = Rated;
    }

    public String getActors ()
    {
        return Actors;
    }

    public void setActors (String Actors)
    {
        this.Actors = Actors;
    }

    public String getPlot ()
    {
        return Plot;
    }

    public void setPlot (String Plot)
    {
        this.Plot = Plot;
    }

    public String getMetascore ()
    {
        return Metascore;
    }

    public void setMetascore (String Metascore)
    {
        this.Metascore = Metascore;
    }

    public String getWriter ()
    {
        return Writer;
    }

    public void setWriter (String Writer)
    {
        this.Writer = Writer;
    }

    public String getGenre ()
    {
        return Genre;
    }

    public void setGenre (String Genre)
    {
        this.Genre = Genre;
    }

    public String getLanguage ()
    {
        return Language;
    }

    public void setLanguage (String Language)
    {
        this.Language = Language;
    }

    public String getAwards ()
    {
        return Awards;
    }

    public void setAwards (String Awards)
    {
        this.Awards = Awards;
    }

    public String getDirector ()
    {
        return Director;
    }

    public void setDirector (String Director)
    {
        this.Director = Director;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Released = "+Released+", Type = "+Type+", imdbVotes = "+imdbVotes+", Runtime = "+Runtime+", Response = "+Response+", Poster = "+Poster+", imdbID = "+imdbID+", Country = "+Country+", Title = "+Title+", imdbRating = "+imdbRating+", Year = "+Year+", Rated = "+Rated+", Actors = "+Actors+", Plot = "+Plot+", Metascore = "+Metascore+", Writer = "+Writer+", Genre = "+Genre+", Language = "+Language+", Awards = "+Awards+", Director = "+Director+"]";
    }
}