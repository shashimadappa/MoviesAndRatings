package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
public class ratings  {
    @Id
    private  String tconst;
    private double avgRating;

    private  long numVotes;



    public ratings(String tconst, double avgRating, long numVotes) {
        this.tconst = tconst;
        this.avgRating = avgRating;
        this.numVotes = numVotes;
    }

    public long getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(long numVotes) {
        this.numVotes = numVotes;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public ratings(){

    }
    @Override
    public String toString() {
        return "Tutorial [numVotes= " + numVotes + ",averageRating= " + avgRating + ", tconst=" + tconst + "]";
    }
}



