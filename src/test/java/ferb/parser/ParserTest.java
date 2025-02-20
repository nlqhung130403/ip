package ferb.parser;

import ferb.exception.FerbException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import ferb.tasklist.TaskList;
import ferb.task.*;

public class ParserTest {

    @Test
    public void parse_validAddCommands_success() throws FerbException {
        TaskList test = new TaskList();
        Parser p = new Parser(test , null);
        p.parse("todo run").execute();
        p.parse("deadline study /by 2019-02-19").execute();
        p.parse("event meeting /from 2025-02-08 /to 2025-02-09").execute();

        TaskList actual = new TaskList();
        actual.add(new ToDo("run"));
        actual.add(new Deadline("study", "2019-02-19"));
        actual.add(new Event("meeting", "2025-02-08", "2025-02-09"));
        assertEquals(actual.toString(), test.toString());
    }

    @Test
    public void parse_validTrickyCommands_success()  throws FerbException {
        TaskList test = new TaskList();
        Parser p = new Parser(test, null);
        p.parse("todo mark assignments").execute();

        TaskList actual = new TaskList();
        actual.add(new ToDo("mark assignments"));

        assertEquals(actual.toString(), test.toString());
    }

    @Test
    public void parse_validMarkCommand_success() throws FerbException {
        TaskList test = new TaskList();
        test.add(new ToDo("run"));
        Parser p = new Parser(test, null);
        p.parse("mark 1").execute();

        assertEquals(true, test.get(0).isDone());
    }

    @Test
    public void parse_validUnmarkCommand_success() throws FerbException {
        TaskList test = new TaskList();
        ToDo todo = new ToDo("run");
        todo.markDone();
        test.add(todo);
        Parser p = new Parser(test, null);
        p.parse("unmark 1").execute();

        assertEquals(false, test.get(0).isDone());
    }

    @Test
    public void parse_validDeleteCommand_success() throws FerbException {
        TaskList test = new TaskList();
        test.add(new ToDo("run"));
        Parser p = new Parser(test, null);
        p.parse("delete 1").execute();

        assertEquals(0, test.size());
    }

    @Test
    public void parse_invalidCommand_throwsFerbException() {
        TaskList test = new TaskList();
        Parser p = new Parser(test, null);
        try {
            p.parse("invalid command");
            fail("Expected a FerbException to be thrown");
        } catch (FerbException e) {
            // Test passes
        }
    }
}