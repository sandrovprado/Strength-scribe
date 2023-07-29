package com.strengthScribe.workout;

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

    public void addWorkout(WorkoutAddRequest workoutRequest){
        Workout workout = new Workout(
                workoutRequest.name(),
                workoutRequest.day(),
                workoutRequest.sets(),
                workoutRequest.reps(),
                workoutRequest.weight(),
                workoutRequest.notes(),
                workoutRequest.checkmark()
        );
        workoutDao.createWorkout(workout);

    }

    public void deleteWorkoutById(Long workoutId){
        if(!workoutDao.existWorkoutWithId(workoutId)){
            throw new RuntimeException("Workout not found");
        }
        workoutDao.deleteWorkoutById(workoutId);
    }

}
