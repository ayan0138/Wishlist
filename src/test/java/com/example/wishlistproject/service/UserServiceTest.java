package com.example.wishlistproject.service;

import com.example.wishlistproject.model.User;
import com.example.wishlistproject.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    void testRegisterUser_shouldReturnTrue_whenEmailDoesNotExist() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.empty());

        boolean result = userService.registerUser(user);

        assertTrue(result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testRegisterUser_shouldReturnFalse_whenEmailExists() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        boolean result = userService.registerUser(user);

        assertFalse(result);
        verify(userRepository, never()).save(any());
    }

    @Test
    void testFindByEmail_shouldReturnUser_whenEmailExists() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        Optional<User> result = userService.findByEmail("test@example.com");

        assertTrue(result.isPresent());
        assertEquals("test@example.com", result.get().getEmail());
    }

    @Test
    void testFindById_shouldReturnUser_whenIdExists() {
        User user = new User();
        user.setUserId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getUserId());
    }

    @Test
    void testFindUserById_shouldReturnUser_whenIdExists() {
        User user = new User();
        user.setUserId(2L);

        when(userRepository.findById(2L)).thenReturn(Optional.of(user));

        User result = userService.findUserById(2L);

        assertNotNull(result);
        assertEquals(2L, result.getUserId());
    }

    @Test
    void testGetAllUsers_shouldReturnUserList() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
    }

    @Test
    void testLoginUser_shouldReturnUser_whenCredentialsAreCorrect() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("1234");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        User result = userService.loginUser("test@example.com", "1234");

        assertNotNull(result);
        assertEquals("1234", result.getPassword());
    }

    @Test
    void testLoginUser_shouldReturnNull_whenPasswordIsWrong() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("correct");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        User result = userService.loginUser("test@example.com", "wrong");

        assertNull(result);
    }

    @Test
    void testCreateUser_shouldReturnUser_whenEmailIsUnique() {
        User user = new User();
        user.setEmail("unique@example.com");

        when(userRepository.findByEmail("unique@example.com")).thenReturn(Optional.empty());
        when(userRepository.save(user)).thenReturn(Optional.of(user));

        Optional<User> result = userService.createUser(user);

        assertTrue(result.isPresent());
        assertEquals("unique@example.com", result.get().getEmail());
    }

    @Test
    void testCreateUser_shouldReturnEmpty_whenEmailAlreadyExists() {
        User user = new User();
        user.setEmail("duplicate@example.com");

        when(userRepository.findByEmail("duplicate@example.com")).thenReturn(Optional.of(user));

        Optional<User> result = userService.createUser(user);

        assertTrue(result.isEmpty());
    }

    @Test
    void testUpdateUser_shouldCallRepository() {
        User user = new User();
        user.setUserId(99L);

        userService.updateUser(user);

        verify(userRepository, times(1)).updatedUser(user);
    }
}
