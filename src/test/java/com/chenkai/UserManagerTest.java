package com.chenkai;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserManagerTest {
    @Test
    public void testAddUser() {
        UserManager manager = new UserManager();
        int id = manager.addUser("测试", "test@qq.com");
        assertNotNull(manager.getUser(id));
        assertEquals("测试", manager.getUser(id).getName());
    }

    @Test
    public void testGetAllUsers() {
        UserManager manager = new UserManager();
        manager.addUser("A", "a@qq.com");
        manager.addUser("B", "b@qq.com");
        assertEquals(2, manager.getAllUsers().size());
    }

    @Test
    public void testUpdateUser() {
        UserManager manager = new UserManager();
        int id = manager.addUser("旧名", "old@qq.com");
        assertTrue(manager.updateUser(id, "新名", "new@qq.com"));
        assertEquals("新名", manager.getUser(id).getName());
    }

    @Test
    public void testDeleteUser() {
        UserManager manager = new UserManager();
        int id = manager.addUser("待删", "del@qq.com");
        assertTrue(manager.deleteUser(id));
        assertNull(manager.getUser(id));
    }

    @Test
    public void testGetNonExistUser() {
        UserManager manager = new UserManager();
        assertNull(manager.getUser(999));
    }
}
