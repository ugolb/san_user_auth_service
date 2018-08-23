package com.san;

import com.san.auth.entities.User;
import com.san.auth.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private UserRepository repository;


    @Test
    public void test() {

        User user = new User("dimas", "dimas@gmail.com", "&*TGh8jho6g45vbdufnghmjkij8hkby", LocalDateTime.now());

//        repository.save(user);

//        List<User> byEmail = repository.findByEmail("dasha@gmail.com");

//        System.out.println(byEmail.get(0).getRegistrationDateTime());
    }
}
