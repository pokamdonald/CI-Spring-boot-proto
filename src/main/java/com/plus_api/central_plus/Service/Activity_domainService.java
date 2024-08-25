package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.Activity_domainModel;
import com.plus_api.central_plus.Repository.Activity_domainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Activity_domainService {

    @Autowired
    private Activity_domainRepository activityDomainRepository;

    // Get all activities
    public List<Activity_domainModel> getAllActivities() {
        return activityDomainRepository.findAll();
    }

    // Get a single Activity by ID
    public Activity_domainModel getActivityById(Long id) {
        return activityDomainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
    }

    // Create a new Activity
    public Activity_domainModel createActivity(Activity_domainModel activity) {
        return activityDomainRepository.save(activity);
    }

    // Update an existing Activity
    public Activity_domainModel updateActivity(Long id, Activity_domainModel activityDetails) {
        Activity_domainModel activity = activityDomainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        activity.setName(activityDetails.getName());
        return activityDomainRepository.save(activity);
    }

    // Delete an Activity
    public void deleteActivity(Long id) {
        Activity_domainModel activity = activityDomainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        activityDomainRepository.delete(activity);
    }
}
