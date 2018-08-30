
package ordenacao3;


public class CountingSort {
    private int[] in, out, aux;
    
    public CountingSort(int[] in){
        this.in = in;
        this.out = new int[in.length];
        defineK(in);
    }
    
    public int[] sort(){
        //adicionando as quantidades de elementos no array aux
        for (int i = 0; i < in.length; ++i){
            ++aux[in[i]];
        }
        
        //somando cada elemento de aux com seu anterior
        for (int i = 1; i < aux.length; ++i){
            aux[i] += aux[i-1];
        }
        
        //o in[i] vai ser colocado no indice de out dado pelo valor aux[in[i]]-1
        for (int i = 0; i < in.length; ++i){
            out[aux[in[i]]-1] = in[i];
            --aux[in[i]];
        }
        
        return out;
    }
    
    private void defineK(int[] i){
        int c = 0;
        for (int k = 0; k < i.length; ++k){
            if (i[k] > c) c = i[k];
        }
        this.aux = new int[c+1];
    }
}
