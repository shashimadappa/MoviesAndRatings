package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class movies {
    @Id
    private String tconst;

    private String titleType;

    private  String  primaryTitle;

    private long runtimeMinutes;
    private String geners;


    public movies() {

    }

        public movies( String tconst,  String titleType, String primaryTitle, long runtimeMinutes , String geners ) {
        this.titleType = titleType;
        this.tconst = tconst;
        this.primaryTitle = primaryTitle;
        this.runtimeMinutes = runtimeMinutes;
        this.geners = geners;

    }


    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public long getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(long runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getGeners() {
        return geners;
    }

    public void setGeners(String geners) {
        this.geners = geners;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    @Override
    public String toString() {
        return "Tutorial [runtimeMinutes= " + runtimeMinutes + " ,genres=" + geners + " ,primaryTitle= " + primaryTitle + ",tconst=" + tconst + ", titletype=" + titleType + "]";
    }


}
