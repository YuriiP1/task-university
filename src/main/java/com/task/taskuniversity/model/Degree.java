package com.task.taskuniversity.model;

public enum Degree {
    ASSISTANT("Assistant",200),
    ASSOCIATE_PROFESSOR("Associate_professor", 300),
    PROFESSOR("Professor", 500);

    private int salary;
    private String name;

    Degree(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

}
