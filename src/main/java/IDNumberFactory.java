public class IDNumberFactory {

    private static int IDCount = 1;

    public static int getNextID() {
        return IDCount++;
    }
}
