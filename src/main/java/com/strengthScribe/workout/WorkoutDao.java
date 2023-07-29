package com.strengthScribe.workout;

import java.util.List;
import java.util.Optional;

public interface WorkoutDao {

    List<Workout> selectAllWorkouts();
    Optional<Workout> selectWorkoutById(Long id);
    void createWorkout(Workout workout);
    void deleteWorkoutById(Long id);
    void updateWorkoutById(Workout update);
    boolean existWorkoutWithId(Long id);
}
