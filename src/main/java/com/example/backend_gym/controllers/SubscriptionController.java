package com.example.backend_gym.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend_gym.services.SubscriptionService;
import com.example.backend_gym.models.Subscription;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    //add a subscription
    @PostMapping("/add")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    //update a subscription
    @PostMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscription);
    }

    //delete a subscription
    @PostMapping("/delete")
    public void deleteSubscription(@RequestBody Long subscriptionId) {
        subscriptionService.deleteSubscription(subscriptionId);
    }

    //get all subscriptions
    @GetMapping("/all")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    //get a subscription by id
    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }
}
