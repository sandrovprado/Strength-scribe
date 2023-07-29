package com.strengthScribe.workout;


import java.util.Objects;



public class Workout {

    private Long id;
    private String name;
    private String day;
    private int sets;
    private int reps;
    private String weight;
    private String notes;
    private boolean checkmark;

    //private Block block


    public Workout() {
    }


    public Workout(String name, String day, int sets, int reps, String weight, String notes, boolean checkmark) {
        this.name = name;
        this.day = day;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.notes = notes;
        this.checkmark = checkmark;
    }

    public Workout(Long id, String name, String day, int sets, int reps, String weight, String notes, boolean checkmark) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.notes = notes;
        this.checkmark = checkmark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isCheckmark() {
        return checkmark;
    }

    public void setCheckmark(boolean checkmark) {
        this.checkmark = checkmark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return sets == workout.sets && reps == workout.reps && checkmark == workout.checkmark && Objects.equals(id, workout.id) && Objects.equals(name, workout.name) && Objects.equals(day, workout.day) && Objects.equals(weight, workout.weight) && Objects.equals(notes, workout.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, day, sets, reps, weight, notes, checkmark);
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day='" + day + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight='" + weight + '\'' +
                ", notes='" + notes + '\'' +
                ", checkmark=" + checkmark +
                '}';
    }
}
