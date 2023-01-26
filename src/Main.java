import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();
        boolean flag = true;

        while (flag) {
            printActions();

            int choice = 0;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
            switch (choice) {
                case 0 -> flag = false;
                case 1 -> addItems(groceryList);
                case 2 -> removeItems(groceryList);
                case 3 -> {
                }

            }
            printList(groceryList);
        }
    }
    private static void printActions() {
        System.out.println(
                """
                        Available Actions:\s
                        0 - to Shutdown
                        1 - to add items to list (comma delimited list)
                        2 - to remove any items (comma delimited list)
                        3 - to see the actual list.
                        Enter a number for which action you want to do:\s"""
        );
    }

    private static void addItems(ArrayList<String> groceryList) {
        scanner.nextLine();
        System.out.println("In a comma delimited, insert your items: ");
        String items = scanner.nextLine();
        String[] itemsArray = items.split(",");
        for (String item : itemsArray) {
            if (groceryList.contains(item)) {
                System.out.println(item + " is already on the list. not added\t");
            } else {
                groceryList.add(item.trim().toLowerCase());
            }}

    }

    private static void removeItems(ArrayList<String> groceryList) {
        System.out.println("in a comma delimited, insert the items you want to remove: ");
        scanner.nextLine(); // pitfall

        String[] removeArray = scanner.nextLine().split(",");

        for (String item : removeArray) {
            groceryList.remove(item.trim().toLowerCase());
        }
    }

    private static void printList(ArrayList<String> groceryList ) {
        groceryList.sort(Comparator.naturalOrder());
        System.out.println("Your list: " + groceryList);
    }

}
