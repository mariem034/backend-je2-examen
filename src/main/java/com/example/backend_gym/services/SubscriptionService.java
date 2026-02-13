package com.example.backend_gym.services;
import org.springframework.stereotype.Service;
import com.example.backend_gym.models.Subscription;
import com.example.backend_gym.models.Member;
import com.example.backend_gym.repositories.SubscriptionRepositories;
import com.example.backend_gym.services.MemberService;
import java.time.LocalDateTime;
import java.util.List;



@Service
public class SubscriptionService {

    final SubscriptionRepositories subscriptionRepositories;
    final MemberService memberService;

    public SubscriptionService(SubscriptionRepositories subscriptionRepositories, MemberService memberService) {
        this.subscriptionRepositories = subscriptionRepositories;
        this.memberService = memberService; 
    }
  
    //add subscription and activer les membres
    public Subscription addSubscription(Subscription subscription) {
        subscription.setCreatedAt(LocalDateTime.now());
        if (subscription.getMembers() != null) {
            for (Member m : subscription.getMembers()) {
                m.setMembershipStatus("ACTIVE");
                m.setSubscription(subscription);
                memberService.updateMember(m.getId(), m);
            }
        }
        return subscriptionRepositories.save(subscription);
    }

    //update a subscription
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepositories.findById(subscription.getId())
                .map(existingSubscription -> {
                    existingSubscription.setPrice(subscription.getPrice());
                    existingSubscription.setDuration(subscription.getDuration());
                    existingSubscription.setStatus(subscription.getStatus());
                    return subscriptionRepositories.save(existingSubscription);
                })
                .orElse(null);
    }

    //delete a subscription and desactiver les membres
    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepositories.findById(subscriptionId).ifPresent(subscription -> {
            if (subscription.getMembers() != null) {
                for (Member m : subscription.getMembers()) {
                    m.setMembershipStatus("INACTIVE");
                    m.setSubscription(null);
                    memberService.updateMember(m.getId(), m);
                }
            }
            subscriptionRepositories.deleteById(subscriptionId);
        });
    }

//get all subscriptions
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepositories.findAll();
    }

    //get a subscription by id
    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepositories.findById(id).orElse(null);
    }
    
}
