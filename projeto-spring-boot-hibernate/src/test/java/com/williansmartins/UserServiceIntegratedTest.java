package com.williansmartins;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.williansmartins.model.Role;
import com.williansmartins.model.User;
import com.williansmartins.repository.RoleRepository;
import com.williansmartins.repository.UserRepository;
import com.williansmartins.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserServiceIntegratedTest {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private User user;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        user = popularUser();
    }
    
    @Test
    public void inserir() {
    	userRepository.save(popularUser());
    }

    @Test
    public void inserir2() {
    	userService.saveUser(popularUser());
    }

    private User popularUser() {
    	bCryptPasswordEncoder = new BCryptPasswordEncoder();
    	
    	user = new User();
        user.setId(1);
        user.setName("Willians");
        user.setLastName("Martins");
        user.setEmail("contato@williansmartins.com");
        user.setPassword("senha");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        
        Role userRole = roleRepository.findByRole("ADMIN");
        
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
        Set<Role> roles = new HashSet<>();
		roles.add(userRole);
        user.setRoles(roles);
        
        return user;
    }
}
