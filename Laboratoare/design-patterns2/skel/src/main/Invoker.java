package main;

import commands.*;

import java.util.LinkedList;
import java.util.List;

/**
 * The layer between the client and the commands that need to be executed on the receivers (DiagramCanvas and DiagramComponent).
 * <br>
 * It is independent of the subtypes of commands, it just receives a command, runs it and implements a redo/undo mechanism.
 */
public class Invoker {

    LinkedList<DrawCommand> commands = new LinkedList<>();
    LinkedList<DrawCommand> commandsRedo = new LinkedList<>();

    /**
     * Clear up all the used resources, start fresh :D
     */
    public void restart() {
        // TODO
        commands.clear();
        commandsRedo.clear();
    }

    /**
     * Executes a given command
     * @param command
     */
    public void execute(DrawCommand command) {
        // TODO
        command.execute();
        commands.add(command);
        commandsRedo.add(command);
    }

    /**
     * Undo the latest command
     */
    public void undo() {
        // TODO
        // Hint: use data structures to keep track of commands
        // Do not use the java.util.Stack, its implementation is based on vector which is inefficient and deprecated.
        // Use a class that implements the Deque interface, e.g. LinkedList https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Deque.html
        DrawCommand undo = commands.getLast();
        undo.undo();
        commands.removeLast();
    }

    /**
     * Redo command previously undone. Cannot perform a redo after an execute, only after at least one undo.
     */
    public void redo() {
        // TODO
        DrawCommand redo = commandsRedo.get(commands.size());
        redo.execute();
        commands.add(redo);
    }
}
