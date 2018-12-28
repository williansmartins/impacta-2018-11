package com.jwtme;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jwtme.model.Role;
import com.jwtme.model.User;
import com.jwtme.repository.RoleRepository;
import com.jwtme.repository.UserRepository;
import com.jwtme.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserServiceIntegratedTest {

    private User user;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void setUp() {
        
    }
    
    @Test
    public void inserir() {
    	user = new User();
		user.setName("Comum");
		user.setLastName("Martins");
		user.setEmail("comum@williansmartins.com");
		user.setPassword("senha");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		
		Role userRole = roleRepository.findByRole("COMUM");
		
		Set<Role> roles = new HashSet<>();
		roles.add(userRole);
		user.setRoles(roles);
		
		userRepository.save(user);
    }

    @Test
    public void updateUser() {
		user = new User();
		user.setId(2);
		user.setName("Comum");
		user.setLastName("Martins");
		user.setEmail("comum@williansmartins.com");
		user.setPassword("senha");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		
		Role userRole = roleRepository.findByRole("COMUM");
		Set<Role> roles = new HashSet<>();
		roles.add(userRole);
		user.setRoles(roles);
		  
		userService.saveUser(user);
    }
    
}
