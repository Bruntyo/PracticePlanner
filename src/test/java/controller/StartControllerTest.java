package controller;

import com.google.gson.Gson;
import model.User;
import model.UserData;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class StartControllerTest {

    String UserFile = "userData/user.json";
    File file = new File(UserFile);
    User user;

    @Before
    public void setUp() throws Exception {
        file.delete();
        user = new User("BaseUser");
    }

    @After
    public void tearDown() throws Exception {
        file.delete();
    }

    @Test
    public void loadUserTestNoFile() {
        StartController startController = StartController.getInstance();

        assertFalse("Make sure file is not present", file.exists());
        startController.loadUser();
        assertTrue("Make sure the file was created", file.exists());
        assertEquals("Check user Name","New User",startController.getUser().getName());
        assertNull("Check favorite activity is null", startController.getUser().getFavoriteActivityName());
    }

    @Test
    public void loadUserTestWithFile() {
        StartController startController = StartController.getInstance();
        file = new File(UserFile);
        user = new User("Test User");
        UserData userData = new UserData(user.getName(), "TestActivity");

        Gson gson = new Gson();
        String data = gson.toJson(userData);
        try {
            FileUtils.writeStringToFile(file, data, StandardCharsets.UTF_8, false);
        } catch (Exception e) {}

        assertTrue("Make sure the file was created", file.exists());
        startController.loadUser();
        assertEquals("Check user Name","Test User",startController.getUser().getName());
        assertNotNull("Check favorite activity is not null", startController.getUser().getFavoriteActivityName());
        assertEquals("Check fav. activity name","TestActivity",startController.getUser().getFavoriteActivityName());
    }

}