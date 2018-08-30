
package ordenacao3;


public class HeapSort {
    private int heapSize;
    private int[] A;
    
    public HeapSort(int[] A){
        this.A = A;
    }
    
    public int[] sort(){
        //transforma o heap em um max heap
        buildMaxHeap(this.A);
        //vai varrendo o heap de tras pra frente e trocando o primeiro elemento
        //pelo ultimo e aplica de novo o maxheapify nesse primeiro elemento trocado
        for (int i = this.A.length - 1; i >= 0; --i){
            swap(this.A, 0, i);
            --heapSize;
            maxHeapify(this.A, 0);
        }
        return this.A;
    }
    
    //vai fazer o heap ficar maximo
    private void buildMaxHeap(int[] A){
        heapSize = A.length;
        for (int i = (A.length/2)-1; i >= 0; --i){
            maxHeapify(A, i);
        }
    }
    
    //vai maximizar um no com relacao aos seus filhos e os proximos abaixo
    private void maxHeapify(int[] A, int index){
        int L = getLeftChild(index);
        int R = getRightChild(index);
        int bigger = index;
        
        if ((L <= heapSize-1) && (A[L] > A[bigger])){
            bigger = L;
        }
        
        if ((R <= heapSize-1) && (A[R] > A[bigger])){
            bigger = R;
        }
        
        if (bigger != index){
            swap(A, bigger, index);
            
            //se o bigger nao tiver filhos, entao nao precisa
            //fazer o maxheapify
            if (bigger < (heapSize/2)-1) maxHeapify(A, bigger);  
        }
        
    }
    
    //metodos de retorno de elementos específicos no heap
    private int getParent(int index){
        return (index - 1)/2;
    }
    
    private int getLeftChild(int index){
        return 2 * index + 1;
    }
    
    private int getRightChild(int index){
        return 2 * index + 2;
    }
    
    //troca dois elementos no heap
    private void swap(int[] A, int i, int j){
        int aux = A[i];
        A[i] = A[j];
        A[j] = aux;
    }
    
}
