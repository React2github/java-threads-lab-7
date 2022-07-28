import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static Callable<Integer> getCallableInteger(Scanner scanner)  {
        // your code here
return (new Callable<Integer>() {
    @Override
    public Integer call() throws Exception {
        return scanner.nextInt();
    }
});
    }

    public static void main(String[] args) throws ExecutionException,InterruptedException{

        ExecutorService executor = Executors.newFixedThreadPool(5);
        int inputValue = executor.submit(getCallableInteger(new Scanner(System.in))).get();
        System.out.println(inputValue);
        executor.shutdown();
    }
}
