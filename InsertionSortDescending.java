public class InsertionSortDescending {
    public static void main(String[] args) {
        // Example array to be sorted
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        // Print original array
        System.out.println("Original array:");
        printArray(arr);
        
        // Perform Insertion Sort in descending order
        insertionSortDescending(arr);
        
        // Print sorted array
        System.out.println("\nSorted array (Descending Order):");
        printArray(arr);
    }
    
    // Method to perform Insertion Sort in descending order
    public static void insertionSortDescending(int[] arr) {
        int n = arr.length;
        
        // Traverse through 1 to n-1
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements of arr[0..i-1], that are smaller than key, to one position ahead of their current position
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            
            // Place the key after the last larger element
            arr[j + 1] = key;
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
