

/**
 * Shaker sort (bidirectional bubble sort)
 * Orders in descending order
 * @param array array to be sorted
 */
public static void shakerSort(int[] array) {
    for (int i = 0; i < array.length/2; i++) {// N * [1 + 1+ 10N]
        boolean swapped = false;
        // pior caso  = 1 + n + n * [1 + [5n + 1] + [5n + 1]]
        // 1 + n + n * [10n + 3]
        // 1 + n + 10n² + 3n
        // 10n² + 4n + 1
        // melhor caso 1 + n * 1 + n * [1 + 2 + 2n]
                //n  + n * [2n + 3]
                // 2n² + 4n + 1
        for (int j = i; j < array.length - i - 1; j++) { // 1 + N *1 + N *4
          // pior caso  =  1 + N *1 + N *4 -> 5n + 1
            if (array[j] < array[j+1]) {
                int tmp = array[j]; // 1
                array[j] = array[j+1]; //1
                array[j+1] = tmp; // 1
                swapped = true; // 1
            }
        }
        for (int j = array.length - 2 - i; j > i; j--) {// 1 + N *1 + N *4
          // pior caso  =  1 + N *1 + N *4 -> 5n + 1
          // melhor  = 1 + N + 0
            if (array[j] > array[j-1]) {
                int tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
                swapped = true;
            }
        }
        if(!swapped) break;
    }
}
// melhor caso // 2n² + 4n + 1
//pior caso // 10n² + 4n + 1

fórmula 1 * [ini] + n *[incremento] + n * bloco


/**
 * Bubble sort (ascending order)
 * @param array array to be sorted
 * @param size size of the array
 */
void bubbleSort(int * array, int size){
    for(int i = 0; i < size - 1; i++){
        for(int j = 0; j < size - i - 1; j++){
            if(array[j+1] < array[j]){
                int tmp = array[j + 1];
                array[j + 1] = array[j];
                array[j] = tmp;
            }
        }
    }
}
