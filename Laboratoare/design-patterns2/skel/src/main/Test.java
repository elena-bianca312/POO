package main;

public class Test {
    public static void main(String[] args) {
        Client client = new Client();

        // Execute various tests

        testDraw(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        System.out.println("Text and Color");
        testTextAndColor(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        System.out.println("Resize");
        testResize(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        System.out.println("Connect");
        testConnect(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        System.out.println("All commands");
        testAllCommands(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        System.out.println("Undo");
        testSimpleUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        System.out.println("Redo");
        testComplexUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }

    private static void testDraw(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");

        client.showDiagram();
    }

    private static void testTextAndColor(Client client) {
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");
        client.showDiagram();
    }

    private static void testConnect(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "0", "2");
        client.executeAction("connect", "2", "3");
        client.executeAction("connect", "3", "4");
        client.executeAction("connect", "4", "2");
        client.showDiagram();
    }

    private static void testResize(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("resize", "0", "50");
        client.showDiagram();
    }

    private static void testAllCommands(Client client) {
        // TODO
        testDraw(client);
        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "PURPLE");
        client.executeAction("change text", "0", "text changed");
        client.executeAction("resize", "0", "20");
        client.executeAction("connect", "0", "1");
        client.showDiagram();
    }

    private static void testSimpleUndoRedo(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }

    private static void testComplexUndoRedo(Client client) {
        // TODO
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "text changed");
        client.executeAction("change color", "0", "PURPLE");
        client.executeAction("resize", "0", "20");
        client.executeAction("connect", "0", "1");
        client.showDiagram();

        client.undo();
        System.out.println("undo");
        client.showDiagram();

        client.undo();
        System.out.println("undo");
        client.showDiagram();

        client.undo();
        System.out.println("undo");
        client.showDiagram();

        client.redo();
        System.out.println("redo");
        client.showDiagram();

        client.undo();
        System.out.println("undo");
        client.showDiagram();

        client.undo();
        System.out.println("undo");
        client.showDiagram();

        // It works :D
    }
}
