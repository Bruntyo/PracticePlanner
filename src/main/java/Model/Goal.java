package model;

import myUtils.myIdGenerator;

public class Goal {

    int id;
    String name;
    String description;
    boolean complete;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getComplete(){
        return complete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Goal(String name, String description){
        this.id = myIdGenerator.getNextId();
        this.name = name;
        this.description = description;
        this.complete = false;
    }
    public Goal(){}
}
