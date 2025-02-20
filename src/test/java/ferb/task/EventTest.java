package ferb.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    @Test
    public void event_creationWithValidInputs_eventCreatedSuccessfully() {
        Event event = new Event("meeting", "2025-02-08", "2025-02-09");
        assertEquals("meeting", event.taskDescription());
        assertEquals("Feb 08 2025", event.getFrom());
        assertEquals("Feb 09 2025", event.getTo());
        assertFalse(event.isDone());
    }

    @Test
    public void event_markAsDone_eventMarkedAsDone() {
        Event event = new Event("meeting", "2025-02-08", "2025-02-09");
        event.markDone();
        assertTrue(event.isDone());
    }

    @Test
    public void event_unmarkAsDone_eventUnmarkedAsDone() {
        Event event = new Event("meeting", "2025-02-08", "2025-02-09");
        event.markDone();
        event.unmarkDone();
        assertFalse(event.isDone());
    }

    @Test
    public void event_toStringWithValidInputs_correctStringRepresentation() {
        Event event = new Event("meeting", "2025-02-08", "2025-02-09");
        assertEquals("[E][ ] meeting (from: Feb 08 2025 to: Feb 09 2025)", event.toString());
        event.markDone();
        assertEquals("[E][X] meeting (from: Feb 08 2025 to: Feb 09 2025)", event.toString());
    }

    @Test
    public void event_toSaveWithValidInputs_correctSaveFormat() {
        Event event = new Event("meeting", "2025-02-08", "2025-02-09");
        assertEquals("E|0|meeting|2025-02-08|2025-02-09", event.toSave());
        event.markDone();
        assertEquals("E|1|meeting|2025-02-08|2025-02-09", event.toSave());
    }
}