// Friend Node (stores friend userId)
class FriendNode {
    int friendId;
    FriendNode next;

    public FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

// User Node
class User {
    int userId;
    String name;
    int age;
    FriendNode friends; // head of friend list
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

// User List (Singly Linked List)
class SocialNetwork {
    private User head;

    // Add new user
    public void addUser(int id, String name, int age) {
        User user = new User(id, name, age);
        user.next = head;
        head = user;
    }

    // Find user by ID
    private User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Find user by Name
    public void searchUserByName(String name) {
        User temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("User not found");
    }

    // Search user by ID
    public void searchUserById(int id) {
        User user = findUserById(id);
        if (user != null)
            displayUser(user);
        else
            System.out.println("User not found");
    }

    // Add friend connection (bidirectional)
    public void addFriendConnection(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        addFriend(u1, id2);
        addFriend(u2, id1);
        System.out.println("Friend connection added");
    }

    private void addFriend(User user, int friendId) {
        FriendNode fn = new FriendNode(friendId);
        fn.next = user.friends;
        user.friends = fn;
    }

    // Remove friend connection
    public void removeFriendConnection(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 == null || u2 == null) return;

        removeFriend(u1, id2);
        removeFriend(u2, id1);
        System.out.println("Friend connection removed");
    }

    private void removeFriend(User user, int friendId) {
        FriendNode curr = user.friends;
        FriendNode prev = null;

        while (curr != null) {
            if (curr.friendId == friendId) {
                if (prev == null)
                    user.friends = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Display friends of a user
    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friends;

        if (temp == null) {
            System.out.println("No friends");
            return;
        }

        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Count friends of each user
    public void countFriends() {
        User temp = head;

        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friends;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends");
            temp = temp.next;
        }
    }

    // Find mutual friends
    public void findMutualFriends(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Mutual Friends: ");
        FriendNode f1 = u1.friends;
        boolean found = false;

        while (f1 != null) {
            FriendNode f2 = u2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.print(f1.friendId + " ");
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if (!found)
            System.out.print("None");

        System.out.println();
    }

    private void displayUser(User u) {
        System.out.println(
            "ID: " + u.userId +
            ", Name: " + u.name +
            ", Age: " + u.age
        );
    }
}

public class SocialMediaConnections {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        network.addUser(1, "Alice", 22);
        network.addUser(2, "Bob", 24);
        network.addUser(3, "Charlie", 23);
        network.addUser(4, "David", 25);

        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 3);
        network.addFriendConnection(2, 4);

        network.displayFriends(1);
        network.findMutualFriends(1, 2);

        network.countFriends();

        network.removeFriendConnection(1, 3);
        network.displayFriends(1);

        network.searchUserByName("Bob");
    }
}
