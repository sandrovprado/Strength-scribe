package com.strengthScribe.workout;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<Workout> getWorkouts(){
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{workoutId}")
    public Workout getWorkout(@PathVariable("workoutId") Long workoutId){
        return workoutService.getWorkout(workoutId);
    }

    @PostMapping()
    public void addWorkout(@RequestBody WorkoutAddRequest workoutRequest){
        workoutService.addWorkout(workoutRequest);
    }

    @DeleteMapping("{workoutId}")
    public void deleteWorkoutById(@PathVariable("workoutId") Long workoutId){
        workoutService.deleteWorkoutById(workoutId);
    }

    @PutMapping("{workoutId}")
    public void updateCustomer(@PathVariable("workoutId") Long workoutId,@RequestBody WorkoutUpdateRequest workoutUpdateRequest){
        workoutService.updateWorkout(workoutId,workoutUpdateRequest);

    }

}
