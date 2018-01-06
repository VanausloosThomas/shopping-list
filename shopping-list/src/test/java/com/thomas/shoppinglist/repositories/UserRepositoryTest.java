package com.thomas.shoppinglist.repositories;

import com.thomas.shoppinglist.ShoppingListApplication;
import com.thomas.shoppinglist.users.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.thomas.shoppinglist.users.User.UserBuilder.userBuilder;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingListApplication.class, webEnvironment = RANDOM_PORT)
public class UserRepositoryTest {

    @Inject
    private UserRepository userRepository;

    @Test
    public void save_whenSavingAUser_thenUserGetsPersisted() {
        User userToPersist = userBuilder()
                .withFirstName("Thomas")
                .withLastName("Vanausloos")
                .withUsername("ThomasVanausoos")
                .withPassword("password")
                .withEmail("thomasvanausloos@gmail.com")
                .build();

        userRepository.save(userToPersist);

        Assertions.assertThat(userRepository.findById(userToPersist.getId())).isPresent();
    }
}