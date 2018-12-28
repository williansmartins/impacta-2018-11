package com.jwtme;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.williansmartins.model.Role;
import com.williansmartins.model.User;
import com.williansmartins.repository.RoleRepository;
import com.williansmartins.repository.UserRepository;
import com.williansmartins.service.UserService;

public class UserServiceMockTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private User user;

    @Before
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserService(mockUserRepository,
                                               mockRoleRepository,
                                               mockBCryptPasswordEncoder);
        user = popularUser();

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString()))
                .thenReturn(user);
    }
    
    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "contato@williansmartins.com";

        // Run the test
        final User result = userServiceUnderTest.findUserByEmail(email);

        // Verify the results
        assertEquals(email, result.getEmail());
    }

    @Test
    public void testSaveUser() {
        // Setup
        final String email = "contato@williansmartins.com";

        // Run the test
        User result = userServiceUnderTest.saveUser(popularUser());

        // Verify the results
        assertEquals(email, result.getEmail());
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
        
        Role userRole = mockRoleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
        Set<Role> roles = new HashSet<>();
		roles.add(userRole);
        user.setRoles(roles);
        
        return user;
    }
}
