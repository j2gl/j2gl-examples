

public class MemoryTest {
    public static void main(String[] args) {
        
        long max = Runtime.getRuntime().maxMemory() / 1024;
        long total = Runtime.getRuntime().totalMemory() / 1024;
        long free = Runtime.getRuntime().freeMemory() / 1024;
        long used = (total - free) / 1024;

        System.out.println("Maximum memory in kb: " + max);
        System.out.println("Total memory in kb: " + total);
        System.out.println("Free memory in kb : " + free);
        System.out.println("Used memory in kb : " + used);
        System.out.println(); 
    }
}