import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureExample {
    public void executeAndBlock() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000); // 2초간 작업 시뮬레이션
            return "작업 완료";
        });

        System.out.println("결과를 기다리는 중...");
        // get() 메서드는 작업이 완료될 때까지 호출 스레드를 블로킹함
        String result = future.get(); 
        System.out.println("결과 반환: " + result);
        
        executor.shutdown();
    }

    public void executeNonBlocking() {
        System.out.println("메인 스레드 시작: " + Thread.currentThread().getName());

        // 비동기 작업 실행 (논블로킹, 즉시 Future 객체 반환)
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // 2초 소요되는 작업 시뮬레이션
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "비동기 작업 결과";
        });

        future.thenAccept(result -> {
            System.out.println("콜백 처리: " + result + " (" + Thread.currentThread().getName() + ")");
        });

        while (true) {
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println("메인 스레드는 대기하지 않고 다른 비즈니스 로직을 수행합니다.");        
        }
    }

    public static void main(String[] args){
        FutureExample fe = new FutureExample();
        try {
            fe.executeNonBlocking();        
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}