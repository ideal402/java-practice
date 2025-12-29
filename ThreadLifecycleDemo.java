public class ThreadLifecycleDemo {

    public static void main(String[] args) throws InterruptedException {
        // ============================================================
        // 1단계: 객체 생성 (Creation)
        // - Java: Heap에 객체 생성됨.
        // - OS: 아직 아무것도 모름 (매핑 없음).
        // ============================================================
        Thread worker = new Thread(new WorkerTask(), "Worker-Thread");
        
        printState(1, "객체 생성 직후", worker); // 예상: NEW

        // ============================================================
        // 2단계: 연결 및 시작 (Start)
        // - Java: start0() 네이티브 메서드 호출
        // - OS: 커널 쓰레드 생성(PCB/TCB), 스택 할당, Java 객체와 1:1 매핑
        // ============================================================
        worker.start(); 
        
        // start() 직후에는 아직 스케줄러가 CPU를 안 줬을 수도 있고, 줬을 수도 있음.
        // 하지만 Java는 이를 뭉뚱그려 RUNNABLE로 표시함.
        printState(2, "start() 호출 직후", worker); // 예상: RUNNABLE


        // ============================================================
        // (메인 쓰레드 잠시 대기)
        // 워커 쓰레드가 실행되고, 스스로 sleep()에 들어갈 시간을 벌어줍니다.
        // ============================================================
        Thread.sleep(500); 

        // ============================================================
        // 4단계: 휴식 (Sleep / Waiting)
        // - Java: sleep(2000) 호출 상태
        // - OS: 해당 쓰레드를 CPU에서 내리고 대기 큐(Waiting Queue)로 보냄.
        //       문맥 교환(Context Switching) 발생.
        // ============================================================
        printState(4, "sleep() 중일 때", worker); // 예상: TIMED_WAITING


        // ============================================================
        // 5단계: 종료 대기 (Join)
        // 워커 쓰레드가 일을 다 마칠 때까지 메인 쓰레드가 기다립니다.
        // ============================================================
        worker.join(); 


        // ============================================================
        // 6단계: 종료 (Termination)
        // - Java: 객체는 남아있으나 종료 플래그 설정됨.
        // - OS: 네이티브 스택, TCB 등 물리적 리소스 즉시 회수됨.
        // ============================================================
        printState(6, "run() 종료 후", worker); // 예상: TERMINATED
    }

    // --- [일꾼 쓰레드가 할 일] ---
    static class WorkerTask implements Runnable {
        @Override
        public void run() {
            // 3단계: 실제 실행 (Execution)
            // OS 스케줄러가 CPU를 할당해야만 이 코드가 실행됨 (OS 상태: Running)
            try {
                System.out.println("   [Worker] 열심히 일하는 중... (OS: Running)");
                
                // 1초간 잠을 잠 (이때 메인 쓰레드가 상태를 체크할 것임)
                // -> OS에게 "나 CPU 반납하고 1.5초 뒤에 올게"라고 말함
                Thread.sleep(1500); 
                
                System.out.println("   [Worker] 잠에서 깨어남, 작업 완료!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // --- [상태 출력용 도우미 메서드] ---
    static void printState(int step, String timing, Thread thread) {
        System.out.printf("Step %d [%-15s] 자바 상태: %-15s \n", 
                step, timing, thread.getState());
        
        // OS의 실제 상태를 코드로 찍을 순 없으므로 주석으로 설명 대체
        if (thread.getState() == Thread.State.NEW) {
            System.out.println("       -> (OS: 쓰레드 없음)");
        } else if (thread.getState() == Thread.State.RUNNABLE) {
            System.out.println("       -> (OS: Ready Queue 혹은 Running 중 하나)");
        } else if (thread.getState() == Thread.State.TIMED_WAITING) {
            System.out.println("       -> (OS: Waiting Queue에서 대기 중, CPU 미점유)");
        } else if (thread.getState() == Thread.State.TERMINATED) {
            System.out.println("       -> (OS: 쓰레드 소멸됨, 리소스 회수 완료)");
        }
        System.out.println("---------------------------------------------------------------");
    }
}