import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int maksFloors = 25;
        Deque<Integer> floors = new ArrayDeque<>();
        floors.add(1);

        while (floors != null) {

            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");

            int input = scanner.nextInt();

            if (input == 0) break;

            if (input > 0 && input <= 25) {
                floors.offer(input);
            } else {
                System.out.println("Такого этажа нет");
            }

        }
        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        int totalSeconds = 0;
        int previousFloor = -1;
        int currentFloor = floors.poll();
        System.out.println("Лифт проследовал по следующим этажам: ");
        while (floors.size() > 0) {
            System.out.print("этаж " + floors.poll() + "-> ");
            if (!(previousFloor == -1)) {
                totalSeconds += Math.abs(currentFloor - previousFloor) * waitMoveInSeconds;
                totalSeconds += waitDoorsInSeconds;
            }
            previousFloor = currentFloor;
        }
        System.out.println("Время затраченное лифтом на маршрут = : " + totalSeconds + " с.");
    }
}


