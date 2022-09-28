class MyCircularQueue {
    int arr[];
    int pushAt;
    int popFrom;
    int cap;
    int size;
    public MyCircularQueue(int k) {
        arr = new int[k];
        cap = k;
        size = 0;
        pushAt = 0;
        popFrom=-1;
    }
    
    public boolean enQueue(int value) {
        if(size==0){
            popFrom = 0;
            arr[0] = value;
            pushAt = 1;
        }
        else if(size<cap){
            arr[pushAt%cap] = value;
            pushAt++;
        }
        else{
            return false;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size==0){
            return false;
        }
        else{
            popFrom++;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if(size>0){
            return arr[popFrom%cap];
        }
        return -1;
    }
    
    public int Rear() {
        if(size>0){
            return arr[(pushAt-1)%cap];
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */