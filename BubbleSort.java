public class BubbleSort {
    public static void main(String[] args) {
        // Example array to be sorted
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        // Print original array
        System.out.println("Original array:");
        printArray(arr);
        
        // Perform Bubble Sort
        bubbleSort(arr);
        
        // Print sorted array
        System.out.println("\nSorted array:");
        printArray(arr);
    }
    
    // Method to perform Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Last i elements are already in place
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no two elements were swapped in the inner loop, then the array is sorted
            if (!swapped) {
                break;
            }
        }
    }
    
    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
