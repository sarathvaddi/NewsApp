package com.example.sarathreddyvaddhi.newsapp;

import java.io.Serializable;

/**
 * Created by sarathreddyvaddhi on 9/1/15.
 */
public class GetResultsSet implements Serializable {
    private String section ;
    private String subsection ;
    private String title ;
    private String abst ;
    private String url;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getAbst() {

        return abst;
    }

    public void setAbst(String abst) {

        this.abst = abst;

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
