package com.strengthScribe.workout;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
