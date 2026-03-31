public class UserService {
    private RegisteredUsers registeredUsers;

    public UserService(RegisteredUsers registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public boolean addUser(String userId) {
        if (userId == null || userId.trim().isEmpty() || registeredUsers.getUserList().contains(userId)) {
            return false; 
        }
        registeredUsers.addUser(userId);
        return true;
    }

    public boolean removeUser(String userId) {
        if (!registeredUsers.getUserList().contains(userId)) {
            return false; 
        }
        registeredUsers.removeUser(userId);
        return true;
    }

    public boolean updateUser(String oldUserId, String newUserId) {
        if (!removeUser(oldUserId)) {
            return false;
        }
        return addUser(newUserId);
    }

    public boolean retrieveUser(String userId) {
        return registeredUsers.getUserList().contains(userId);
    }
}
