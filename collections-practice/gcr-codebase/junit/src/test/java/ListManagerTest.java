import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    private ListManager listManager;
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    //  Test adding elements
    @Test
    void testAddElement() {
        listManager.addElement(list, 10);
        listManager.addElement(list, 20);

        assertEquals(2, listManager.getSize(list));
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    // Test removing elements
    @Test
    void testRemoveElement() {
        list.add(10);
        list.add(20);

        listManager.removeElement(list, 10);

        assertEquals(1, listManager.getSize(list));
        assertFalse(list.contains(10));
    }

    // Test list size
    @Test
    void testGetSize() {
        assertEquals(0, listManager.getSize(list));

        listManager.addElement(list, 5);
        listManager.addElement(list, 15);

        assertEquals(2, listManager.getSize(list));
    }
}
