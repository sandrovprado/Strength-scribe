package com.strengthScribe.workout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutDao workoutDao;

    public WorkoutService(WorkoutDao workoutDao) {
        this.workoutDao = workoutDao;
    }

    public List<Workout> getAllWorkouts(){
        return workoutDao.selectAllWorkouts();
    }

    public Workout getWorkout(Long id){
        return workoutDao.selectWorkoutById(id)
                .orElseThrow(
                        () -> new RuntimeException("Workout not found"));
    }

}
