package ferb.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeadlineTest {

    @Test
    public void deadline_creationWithValidInputs_deadlineCreatedSuccessfully() {
        Deadline deadline = new Deadline("submit report", "2023-12-31");
        assertEquals("submit report", deadline.taskDescription());
        assertEquals("Dec 31 2023", deadline.getBy());
        assertFalse(deadline.isDone());
    }

    @Test
    public void deadline_markAsDone_deadlineMarkedAsDone() {
        Deadline deadline = new Deadline("submit report", "2023-12-31");
        deadline.markDone();
        assertTrue(deadline.isDone());
    }

    @Test
    public void deadline_unmarkAsDone_deadlineUnmarkedAsDone() {
        Deadline deadline = new Deadline("submit report", "2023-12-31");
        deadline.markDone();
        deadline.unmarkDone();
        assertFalse(deadline.isDone());
    }

    @Test
    public void deadline_toStringWithValidInputs_correctStringRepresentation() {
        Deadline deadline = new Deadline("submit report", "2023-12-31");
        assertEquals("[D][ ] submit report (by: Dec 31 2023)", deadline.toString());
        deadline.markDone();
        assertEquals("[D][X] submit report (by: Dec 31 2023)", deadline.toString());
    }

    @Test
    public void deadline_toSaveWithValidInputs_correctSaveFormat() {
        Deadline deadline = new Deadline("submit report", "2023-12-31");
        assertEquals("D|0|submit report|2023-12-31", deadline.toSave());
        deadline.markDone();
        assertEquals("D|1|submit report|2023-12-31", deadline.toSave());
    }
}