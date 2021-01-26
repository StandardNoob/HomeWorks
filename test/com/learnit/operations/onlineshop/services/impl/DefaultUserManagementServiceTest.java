package com.learnit.operations.onlineshop.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import com.learnit.operations.onlineshop.enteties.User;
import com.learnit.operations.onlineshop.enteties.impl.DefaultUser;

@DisplayName("Tests DefaultUserManagementService for online shop")
class DefaultUserManagementServiceTest {

	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static DefaultUserManagementService instance;

	@BeforeEach
	void setUp() throws Exception {
		instance = (DefaultUserManagementService) instance.getInstance();
		instance.clearServiceState();
	}

	@Test
	void shouldDontAddUserWhenRegisterUserNull() {
		assertEquals(instance.getUsers().size(), 0);
	}

	@Test
	void shouldDontAddUserWhenRegisterUserNullCheckEmptyMessege() {
		assertEquals(instance.registerUser(null), NO_ERROR_MESSAGE);
	}

	@Test
	void shouldAddUserWhenRegisterUserIsNotNullAndEmailIsOK() {
		User user = new DefaultUser("Name", "LastName", "123", "email");
		instance.registerUser(user);
		assertEquals(instance.getUsers().size(), 1);
	}

	@Test
	void shouldAddUserWhenRegisterUserIsNotNullAndEmailIsOKCheckEmptyMessege() {
		User user = new DefaultUser("Name", "LastName", "123", "email");
		assertEquals(instance.registerUser(user), NO_ERROR_MESSAGE);
	}

	@Test
	void shouldDontAddUserWhenEmailIsEmpty() {
		User user = new DefaultUser("Name", "LastName", "123", "");
		instance.registerUser(user);
		assertEquals(instance.getUsers().size(), 0);
	}

	@Test
	void shouldDontAddUserWhenEmailIsEmptyCheckMessege() {
		User user = new DefaultUser("Name", "LastName", "123", "");
		assertEquals(instance.registerUser(user), EMPTY_EMAIL_ERROR_MESSAGE);
	}

	@Test
	void shouldDontAddUserWhenEmailIsAlreadyExist() {
		User user = new DefaultUser("Name", "LastName", "123", "email");
		User user2 = new DefaultUser("Name2", "LastName2", "1234", "email");
		instance.registerUser(user);
		instance.registerUser(user2);
		assertEquals(instance.getUsers().size(), 1);
	}

	@Test
	void shouldDontAddUserWhenEmailIsAlreadyExistCheckMessege() {
		User user = new DefaultUser("Name", "LastName", "123", "email");
		User user2 = new DefaultUser("Name2", "LastName2", "1234", "email");
		instance.registerUser(user);
		assertEquals(instance.registerUser(user2), NOT_UNIQUE_EMAIL_ERROR_MESSAGE);
	}

	@Test
	void shouldClearServiceState() {
		User user = new DefaultUser("Name", "LastName", "123", "email1");
		User user2 = new DefaultUser("Name2", "LastName2", "1234", "email2");
		instance.registerUser(user);
		instance.registerUser(user2);
		instance.clearServiceState();
		assertEquals(instance.getUsers().size(), 0);
	}

	@Test
	void shouldGetUserByEmail() {
		User user = new DefaultUser("Name", "LastName", "123", "email1");
		User user2 = new DefaultUser("Name2", "LastName2", "1234", "email2");
		User user3 = new DefaultUser("Name3", "LastName3", "12345", "email3");
		instance.registerUser(user);
		instance.registerUser(user2);
		instance.registerUser(user3);
		assertEquals(instance.getUserByEmail(user2.getEmail()).getEmail(), user2.getEmail());
	}

	@Test
	void shouldGetNullWhenUserByEmailNotFound() {
		User user = new DefaultUser("Name", "LastName", "123", "email1");
		User user2 = new DefaultUser("Name2", "LastName2", "1234", "email2");
		User user3 = new DefaultUser("Name3", "LastName3", "12345", "email3");
		instance.registerUser(user);
		instance.registerUser(user2);
		instance.registerUser(user3);
		assertEquals(instance.getUserByEmail("nonExistentEmail"), null);
	}

	@Test
	void shouldGetAllUsers() {
		User user = new DefaultUser("Name", "LastName", "123", "email1");
		User user2 = new DefaultUser("Name2", "LastName2", "1234", "email2");
		User user3 = new DefaultUser("Name3", "LastName3", "12345", "email3");
		instance.registerUser(user);
		instance.registerUser(user2);
		instance.registerUser(user3);
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user2);
		list.add(user3);
		assertEquals(instance.getUsers().containsAll(list) && instance.getUsers().size() == list.size(), true);
	}
}
