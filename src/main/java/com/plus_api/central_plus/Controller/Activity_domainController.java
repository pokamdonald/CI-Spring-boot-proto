package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.Activity_domainModel;
import com.plus_api.central_plus.Service.Activity_domainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class Activity_domainController {

    @Autowired
    private Activity_domainService activityDomainService;

    // Get all activities
    @GetMapping
    public List<Activity_domainModel> getAllActivities() {
        return activityDomainService.getAllActivities();
    }

    // Get a single activity by ID
    @GetMapping("/{id}")
    public Activity_domainModel getActivityById(@PathVariable Long id) {
        return activityDomainService.getActivityById(id);
    }

    // Create a new activity
    @PostMapping
    public Activity_domainModel createActivity(@RequestBody Activity_domainModel activity) {
        return activityDomainService.createActivity(activity);
    }

    // Update an existing activity
    @PutMapping("/{id}")
    public Activity_domainModel updateActivity(@PathVariable Long id, @RequestBody Activity_domainModel activityDetails) {
        return activityDomainService.updateActivity(id, activityDetails);
    }

    // Delete an activity
    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityDomainService.deleteActivity(id);
    }
}
