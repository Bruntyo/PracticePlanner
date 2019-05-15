package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getFavoriteActivityName() {
        List<Plan> planList = new ArrayList<>();
        Plan plan1 = new Plan();
        Plan plan2 = new Plan();

        planList.add(plan1);
        planList.add(plan2);
        Activity activity1 = new Activity();
        Activity activity2 = new Activity();
        Activity activity3 = new Activity();
        activity1.setName("First");
        activity2.setName("Second");
        activity3.setName("Third");
        activity1.setHoursCompleted(100);
        activity2.setHoursCompleted(0);
        activity3.setHoursCompleted(-100);
        plan2.addActivity(activity1);
        plan1.addActivity(activity2);
        plan2.addActivity(activity3);

        User user = new User("Test User");
        user.loadPlans(planList);
        assertEquals("Check correct activity name","First", user.getFavoriteActivityName());
    }
}