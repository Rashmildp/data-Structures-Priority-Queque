/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueque;

/**
 *
 * @author RASHMI
 */
public class PriorityQueQue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queque x = new Queque(5);
        x.enQueQue(7);
        x.enQueQue(5);
        x.enQueQue(3);
        x.display();

    }

}

class Queque {

    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nElements;

    public Queque(int s) {
        this.queArray = new int[s];
        this.maxSize = s;
        this.front = 0;
        this.rear = -1;
        this.nElements = 0;

    }

    public boolean isEmpty() {
        return this.nElements == 0;
    }

    public boolean isFull() {
        return this.nElements == this.maxSize;
    }

    public int Size() {
        return this.nElements;
    }

    public void enQueQue(int value) {
        if (isFull()) {
            System.out.println("Array is full cannot insert");
            return;
        }

        for (int i = 0; i < this.nElements; i++) {

            if (this.queArray[i] < value) {

                for (int j = this.nElements - 1; j >= i; j--) {

                    this.queArray[j + 1] = this.queArray[j];

                }

                this.queArray[i] = value;
                this.rear = (this.rear + 1) % this.maxSize;

                this.nElements++;

                return;

            }
        }

        this.queArray[this.nElements] = value;
        this.rear = (this.rear + 1) % this.maxSize;

        this.nElements++;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty, nothing to display");
            return;
        }
        int i = this.front;
        while (i != this.rear) {  //since last element is not printing, we have to manually print rear.
            System.out.print(this.queArray[i] + " ");
            i = (i + 1) % maxSize;
        }
        System.out.print(this.queArray[rear]);
        System.out.println();
    }

}
