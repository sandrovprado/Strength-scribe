package com.strengthScribe.workout;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("list")
public class WorkoutListDataAccessService implements WorkoutDao {

    private static List<Workout> workoutList;

    static {
        workoutList = new ArrayList<>();
        Workout squat = new Workout(1L,"Squat","Day 1",3,5,"RPE 6","Focus on form",false);
        Workout bench = new Workout(2L,"Bench","Day 3",5,4,"RPE 6","dont sink",false);
        Workout deadlift = new Workout(3L,"Deadlift","Day 1",3,3,"RPE 6","press the floor",false);
        workoutList.add(squat);
        workoutList.add(bench);
        workoutList.add(deadlift);
    }

    @Override
    public List<Workout> selectAllWorkouts() {
        return workoutList;
    }

    @Override
    public Optional<Workout> selectWorkoutById(Long id) {
        return workoutList.stream()
                .filter(workout -> workout.getId().equals(id))
                .findFirst();
    }

    @Override
    public void createWorkout(Workout workout) {
        workoutList.add(workout);
    }

    @Override
    public boolean existWorkoutWithId(Long id) {
        return workoutList.stream()
                .anyMatch(workout -> workout.getId().equals(id));
    }

    @Override
    public void deleteWorkoutById(Long workoutId) {
        workoutList.stream()
                .filter(workout -> workout.getId().equals(workoutId))
                .findFirst()
                .ifPresent(workoutList::remove);
    }

    @Override
    public void updateWorkoutById(Workout update) {
        workoutList.add(update);
    }


}
