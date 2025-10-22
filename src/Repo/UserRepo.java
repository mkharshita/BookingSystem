package Repo;

import Entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepo {
    private Map<Integer, User> users;
    private static UserRepo INSTANCE;
    private UserRepo() {users = new HashMap<>();}
    public static UserRepo getInstance() {
        if(INSTANCE == null){
            synchronized (UserRepo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserRepo();
                }
            }
        }
        return INSTANCE;
    }

    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }
    public Optional<User> findById(int id) {
        return Optional.ofNullable(users.get(id));
    }
}
