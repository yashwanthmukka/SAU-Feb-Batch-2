package com.assignment.Hibernate2.task3;

import java.util.*;

import javax.persistence.*;

@Entity
public class Screen {
	
	 @Id
	    private int screenno;
	    private String name;
	    private int showtime;

	    @OneToMany(mappedBy = "screen1")
	    private List<Audience> audiences = new ArrayList<>();


	    public List<Audience> getAudience() {
	        return audiences;
	    }

	    public void setaudience(List<Audience> audiences) {
	        this.audiences = audiences;
	    }


	    public int getScreenno() {
	        return screenno;
	    }

	    public void setScreenno(int screenno) {
	        this.screenno = screenno;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getShowtime() {
	        return showtime;
	    }

	    public void setShowtime(int showtime) {
	        this.showtime = showtime;
	    }

}
