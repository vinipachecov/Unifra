/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopermutacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author vinipachecov
 */
public class TrabalhoPermutacoes {
    
public static Set<String> permutacoes(String str) {
        //Etapa 1 - separação dos possíveis conjuntos em tamanhos
        //Uso de um Set pois dessa forma
        // valores repitidos não serão permitidos
        Set<String> perm = new HashSet<>();
        //Para lidar com cenários de erros 
        //durante a etapa de divisão de palavras
        
        //quando a subpalavra enviada não possui nenhum caracter
        // ou está vazia é iniciada com um caracter vazio
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        //Etapa 2 - permutações e formulações dos anagramas
        //Primeiro é pego a primeira letra da var str
        //depois é pego o restante da palavra sem a primeira letra
        
        char inicio = str.charAt(0); 
        String rem = str.substring(1);
        
        // Um set auxiliar é criado chamando recursivamente a função 
        // com a substring com restante da palavra sem a primeira letra        
        Set<String> palavras = permutacoes(rem);
        
        
                
        //É feito dois loops
        // O primeiro é feito sob um exemplar do Set resultante
        // das chamadas recursivas         
        for (String novoStr : palavras) {
            // O segundo loop itera pelo tamanho de cada palavra 
            //do set resultante, e insere a letra do início da palavra (inicio)
            //na posição do iterador "i" e dessa forma vamos formandos os anagramas
            //de acordo com cada tamanho das palavras, 1, 2 , 3 ,4 5 ( sorte)            
            for (int i = 0;i<=novoStr.length();i++){
                //A cada intereção vai formando os anagramas possíveis de acordo
                //com o tamanho de novoStr (vem do nível anterior)  + 1  por ser
                // maior ou igual a zero **<=)daquele nível.
                perm.add(insereChar(novoStr, inicio, i));
            }
        }
        return perm;
    }

    
    public static String insereChar(String str, char c, int j) {
        String comeco = str.substring(0, j);
        String fim = str.substring(j);
        return comeco + c + fim;
    }

    public static void main(String[] args) {
        
        String s = "SORTE";        
        Set<String> f = permutacoes(s);
        ArrayList<String> lista = new ArrayList<String>(f);
        System.out.println(f);
        Collections.sort(lista);
        System.out.println(lista.get(85));
        System.out.println(lista.size());
    }
}
    

