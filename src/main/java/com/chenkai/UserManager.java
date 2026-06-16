package com.chenkai;

import java.util.*;

/**
 * 简单的用户管理类 - 演示增删改查（CRUD）
 */
public class UserManager {
    private Map<Integer, User> users = new HashMap<>();
    private int nextId = 1;

    // 增 - Create
    public int addUser(String name, String email) {
        User user = new User(nextId, name, email);
        users.put(nextId, user);
        return nextId++;
    }

    // 查 - Read（单个）
    public User getUser(int id) {
        return users.get(id);
    }

    // 查 - Read（全部）
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    // 改 - Update
    public boolean updateUser(int id, String name, String email) {
        User user = users.get(id);
        if (user == null) {
            return false;
        }
        user.setName(name);
        user.setEmail(email);
        return true;
    }

    // 删 - Delete
    public boolean deleteUser(int id) {
        return users.remove(id) != null;
    }

    // 内部实体类
    static class User {
        private int id;
        private String name;
        private String email;

        public User(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public void setName(String name) { this.name = name; }
        public void setEmail(String email) { this.email = email; }

        @Override
        public String toString() {
            return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
        }
    }

    // 测试方法
    public static void main(String[] args) {
        UserManager manager = new UserManager();

        // 增
        int id1 = manager.addUser("张三", "zhangsan@qq.com");
        int id2 = manager.addUser("李四", "lisi@qq.com");
        System.out.println("新增用户，ID: " + id1 + ", " + id2);

        // 查
        System.out.println("查询用户" + id1 + ": " + manager.getUser(id1));
        System.out.println("全部用户: " + manager.getAllUsers());

        // 改
        manager.updateUser(id1, "张三丰", "zhangsanfeng@qq.com");
        System.out.println("修改后: " + manager.getUser(id1));

        // 删
        manager.deleteUser(id2);
        System.out.println("删除后全部用户: " + manager.getAllUsers());
    }
}
