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
                workoutRequest.notes()
        );
        workoutDao.createWorkout(workout);

    }

    public void deleteWorkoutById(Long workoutId){
        if(!workoutDao.existWorkoutWithId(workoutId)){
            throw new RuntimeException("Workout not found");
        }
        workoutDao.deleteWorkoutById(workoutId);
    }

    public void updateWorkout(Long workoutId, WorkoutUpdateRequest workoutUpdateRequest){
        Workout workout = getWorkout(workoutId);

        boolean changes = false;

        if(workoutUpdateRequest.name()!=null&& !workoutUpdateRequest.name().equals(workout.getName())){
            workout.setName(workoutUpdateRequest.name());
            changes = true;
        }

        if(workoutUpdateRequest.day()!=null&& !workoutUpdateRequest.day().equals(workout.getDay())){
            workout.setDay(workoutUpdateRequest.day());
            changes = true;
        }

        if(workoutUpdateRequest.sets()!=null&& !workoutUpdateRequest.sets().equals(workout.getSets())){
            workout.setSets(workoutUpdateRequest.sets());
            changes = true;
        }

        if(workoutUpdateRequest.reps()!=null&& !workoutUpdateRequest.reps().equals(workout.getReps())){
            workout.setReps(workoutUpdateRequest.reps());
            changes = true;
        }

        if(workoutUpdateRequest.weight()!=null&& !workoutUpdateRequest.weight().equals(workout.getWeight())){
            workout.setWeight(workoutUpdateRequest.weight());
            changes = true;
        }

        if(workoutUpdateRequest.notes()!=null&& !workoutUpdateRequest.notes().equals(workout.getNotes())){
            workout.setNotes(workoutUpdateRequest.notes());
            changes = true;
        }

        if(!changes){
            workoutDao.updateWorkout(workout);
        }
    }

}
