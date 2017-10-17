package com.company;
import java.util.Scanner;



public class Main {


    
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        node_class N = new node_class();
        N = null;


        System.out.println("How many numbers do you want to give me?");
        int size_tree = input.nextInt();


        //CREATION
        for (int i = 0; i < size_tree; i++) {
            System.out.println("Give me your " + i + "° key and value");
            int key = input.nextInt();
            int value = input.nextInt();
            N = add_node(N, key, value);
        }
        if(N == null)
            System.out.println("The tree is empty");
        else print(N);


        //SEARCH
        System.out.println("Give me the key of the node that you want search");
        int key_searched = input.nextInt();
        if (search_node(N, key_searched) == null)
            System.out.println("The node searched doesn't exist");
        else
            System.out.println("The node searched exist and his value is " + search_node(N, key_searched).getValue());


        //UPDATE
        System.out.println("Give me the key of the node that you want update");
        int key_update = input.nextInt();
        System.out.println("Give me the new value of the node that you want update");
        int value_update = input.nextInt();
        if (search_node(N, key_update) == null)
            System.out.println("The node that you want update doesn't exist");
        else {
            update_node(search_node(N, key_update), value_update);
            System.out.println("The node is update with the new value " + update_node(search_node(N, key_update), value_update).getValue());
        }


        //DELETE EASY
        System.out.println("Give me the key of the node that you want delete");
        int key_delete = input.nextInt();
        if (search_node(N, key_delete) == null)
            System.out.println("The node that you want delete doesn't exist");
        else {
            delete_node_easy(search_node(N, key_delete));
            if(delete_node_easy(search_node(N, key_delete)).getValue() == null)
                System.out.println("The node is deleted");
            else System.out.println("The node that you want delete isn't cancelled");
        }


    }





    public static node_class add_node(node_class n_father, int key_new, int value_new){

        if(n_father == null) {                                              // Aggiunge in modo bilanciato, ovvero a sinistra stanno tutti
            n_father = new node_class();                                    // i minori del nodo padre e a destra stanno tutti i maggiori del nopo padre.
            n_father.setKey(key_new);                                       // Ogni volta che esco dalla funzione e faccio ripartire il ciclo, gli passo
            n_father.setValue(value_new);                                   // l'albero partendo dal primo nodo inserito, cosi da creare un albero bilanciato che
            n_father.right = null;                                          // mette tutti i minori a sinistra e tutti i maggiori a destra.
            n_father.left = null;
            return n_father;
        }

        if (n_father.getKey() > key_new) {
            n_father.left = add_node(n_father.left, key_new, value_new);
        }
        else if (n_father.getKey() < key_new){
            n_father.right = add_node(n_father.right, key_new, value_new);
        }
        else if (n_father.getKey() == key_new){
            n_father.setValue(value_new);
        }
        return n_father;

    }




    public static node_class search_node(node_class n_searched, int key_searched){

        /*System.out.println(n_searched.getKey());
        System.out.println(n_searched.getValue());
        System.out.println(n_searched.right);
        System.out.println(n_searched.left);*/

        node_class result = new node_class();

        if(n_searched == null) {
            return null;
        }
        if(n_searched.getKey() == key_searched) {
            result = n_searched;
            return result;
        }
        else if(n_searched.getKey() > key_searched) {
            result = search_node(n_searched.left, key_searched);
        }
        else if(n_searched.getKey() < key_searched) {
            result = search_node(n_searched.right, key_searched);
        }

        return result;
    }




    public static node_class update_node(node_class n_update, int value_update){

        n_update.setValue(value_update);
        return n_update;

    }



    public static node_class delete_node_easy(node_class n_delete){

        n_delete.setValue(null);
        return n_delete;

    }



    public static void print(node_class N){

        if (N == null)
            return;                                                             // Printa il nodo principale, poi il suo sinistro (se contiene qualcosa prima sx e poi
        System.out.println(N.getKey());                                         // dx) e poi il suo destro ( se contiene qualcosa prima sx e po dx) e continua cosi
        print(N.left);                                                          // in modo ricorsivo.
        print(N.right);

    }


}





                                   /*                                 KEY||VALUE
                                                                        5||4
                                                                      /      \
                                                                     /        \
                                                                    /          \
                                                                   /            \                            Prova con questo albero  mettendo ovviamente
                                                                 3||4          6||4                          i key in modo appropriato e invertendo casualmente
                                                                /    \         /   \                         i key dello stesso livello (se li inverti con livelli
                                                               /      \       /     \                        diversi cambia l'albero)
                                                            2||4    4||4            7||4
                                                            /  \    /   \          /    \
                                                           /
                                                        1||4                                                       */
