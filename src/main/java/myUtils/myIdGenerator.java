package myUtils;

public class myIdGenerator {
    private static int nextId = 0;

    public static int getNextId(){
        return nextId++;
    }
}
