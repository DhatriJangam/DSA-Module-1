public class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.insert(0, 5);
        dynamicArray.insert(1, 10);
        dynamicArray.insert(2, 15);
        dynamicArray.insert(1, 20);
        System.out.print("DynamicArray after inserts: ");
        dynamicArray.printArray();

        int deletedElement = dynamicArray.delete(2);
        System.out.println("Deleted element from DynamicArray: " + deletedElement);
        System.out.print("DynamicArray after deletion: ");
        dynamicArray.printArray();

        int index = dynamicArray.find(10);
        System.out.println("Index of element 10 in DynamicArray: " + index);

        dynamicArray.sort();
        System.out.print("DynamicArray after sorting: ");
        dynamicArray.printArray();

        dynamicArray.reverse();
        System.out.print("DynamicArray after reversing: ");
        dynamicArray.printArray();

        DynamicArray anotherArray = new DynamicArray();
        anotherArray.insert(0, 30);
        anotherArray.insert(1, 40);
        dynamicArray.merge(anotherArray);
        System.out.print("DynamicArray after merging: ");
        dynamicArray.printArray();
    }
}
