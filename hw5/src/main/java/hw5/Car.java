package hw5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static boolean IS_WIN;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier barrier;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier barrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
            barrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            if(!IS_WIN){
                System.out.println(name + " - WIN");
                IS_WIN = true;
            }

            barrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
