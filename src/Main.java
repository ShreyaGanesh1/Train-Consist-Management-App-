<<<<<<< HEAD
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String bogieId;
    private String shape;
    private String currentCargo;

    public GoodsBogie(String bogieId, String shape) {
        this.bogieId = bogieId;
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        System.out.println("Validating cargo assignment for " + bogieId + "...");

        try {
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargoType.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe cargo assignment! Petroleum cannot be in a Rectangular bogie."
                );
            }

            this.currentCargo = cargoType;
            System.out.println("Cargo assigned successfully -> " + cargoType);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo validation completed for "
                    + shape + " bogie (" + bogieId + ").");
        }
    }

    public String getCurrentCargo() {
        return currentCargo;
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("=======================================");

        GoodsBogie bogie1 = new GoodsBogie("B001", "Cylindrical");
        bogie1.assignCargo("Petroleum");

        System.out.println();

        GoodsBogie bogie2 = new GoodsBogie("B002", "Rectangular");
        bogie2.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
=======
public class Main {

    public static void main(String[] args) {

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("=========================================");
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("=========================================\n");

        System.out.println("Original Capacities:");
        printArray(capacities);

        bubbleSort(capacities);

        System.out.println("\nSorted Capacities (Ascending):");
        printArray(capacities);

        System.out.println("\nUC16 sorting completed...");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
>>>>>>> 37472a4 (UC16: Sort Passenger Bogies by Capacity)
    }
}