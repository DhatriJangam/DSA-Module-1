public class DoublyLinkedList {
    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            newNode.prev = tail;
            if (tail != null) {
                tail.next = newNode;
            }
            tail = newNode;
            if (head == null) {
                head = newNode;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node toRemove;
        if (index == 0) {
            toRemove = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            toRemove = tail;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            toRemove = current;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return toRemove.data;
    }

    public int find(int element) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == element) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    public void reverse() {
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    public void merge(DoublyLinkedList otherList) {
        if (otherList.head != null) {
            if (this.head == null) {
                this.head = otherList.head;
                this.tail = otherList.tail;
            } else {
                this.tail.next = otherList.head;
                otherList.head.prev = this.tail;
                this.tail = otherList.tail;
            }
            size += otherList.size;
        }
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current.next;
            while (runner != null) {
                if (current.data == runner.data) {
                    if (runner.next != null) {
                        runner.next.prev = runner.prev;
                    } else {
                        tail = runner.prev;
                    }
                    runner.prev.next = runner.next;
                    size--;
                }
                runner = runner.next;
            }
            current = current.next;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
  }


  




  
