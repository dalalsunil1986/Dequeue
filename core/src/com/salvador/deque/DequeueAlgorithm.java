package com.salvador.deque;

import java.util.ArrayList;

public class DequeueAlgorithm {

    private NodeD front;
    private NodeD back;

    ArrayList<Integer> ss;

    public DequeueAlgorithm(){

    }

    public void pushBack(NodeD node){
        if(back == null)
            back = node;
        else{
            node.prev = back;
            back.next = node;
            back = node;
        }

        if(front == null)
            front = node;
    }

    public void pushFront(NodeD node){

        if(front == null) //Si no hay ningun elemento al frente entonces el frente sera el nuevo nodo.
            front = node;
        else{
            node.next = front; //El siguiente elemento del nuevo nodo sera el viejo nodo
            front.prev = node;  //Declaramos que el elemento previo del frente acutal sera el nuevo nodo
            front = node; //Ahora el frente sera el elemento que insertamos
        }

        if(back == null) //Si no existe un nodo al final, el nodo nuevo tambien sera el que estara al final
            back = node;
    }


    public NodeD popFront(){
        NodeD tmp = front;
        if(front != null)
            if(front.next != null){
                front = front.next;
                front.prev = null;
            }
            else{
                front = null;
                back = null;
            }

        return tmp;
    }

    public NodeD popBack(){
        NodeD tmp = back;
        if(back != null){
            if(back.prev != null){
                back = back.prev;
                back.next = null;
            }else{
                back = null;
                front = null;
            }
        }
        return tmp;
    }

    public NodeD getBack(){
        return back;
    }

    public NodeD getFront(){
        return front;
    }

}
