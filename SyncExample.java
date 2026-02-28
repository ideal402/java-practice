import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SyncExample {
    public String preformTesk(){
        System.out.println("작업 수행 중 (동기)");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            
        };
        
        return "작업 완료";
    }

    public static void SyncTest(){
        SyncExample se = new SyncExample();

        System.out.println("메인 스레드 시작");

        String result = se.preformTesk();

        System.out.println("결과: " +result);

        System.out.println("메인 스레드 종료");
    }

    public static void AsyncTest() throws Exception{
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("메인 스레드 시작");

        // 비동기 호출: 작업을 백그라운드 스레드에 위임하고 즉시 Future를 반환받음
        Future<String> future = executor.submit(() -> {
            System.out.println("백그라운드 스레드에서 작업 수행 중...");
            Thread.sleep(2000);
            return "비동기 작업 완료";
        });

        System.out.println("메인 스레드는 다른 작업을 계속 수행합니다.");

        // 필요한 시점에 결과를 가져옴 (이 시점에서는 동기적으로 블로킹됨)
        String result = future.get();
        System.out.println("결과: " + result);
        
        executor.shutdown();
    }
    
    public static void main(String[] args){
        try {
            AsyncTest();        
        } catch (Exception e) {
        }
    }
    
}
