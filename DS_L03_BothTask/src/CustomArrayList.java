public class CustomArrayList<E> {

    Object[] array ;
    private int index;
    private int size;

    CustomArrayList(int size){
        array = new Object[size];
        index=0;
        this.size=size;
    }

    public void add(E e) {
        if (index >= array.length-1) {
            Object[] newArray = new Object[index+1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[index] = e;
        index++;
    }

    public void remove(E e){
        for(int i=0 ; i < array.length ; i++){
            if(array[i].equals(e)) {
                for (int j = i + 1; j < array.length; j++,i++)
                    array[i] = array[j];
                break;
            }
        }
        reallocate();
    }

    public void reallocate(){
        array[array.length-1] = null;

        Object[] newArray = new Object[array.length-1];
        System.arraycopy(array, 0, newArray, 0, newArray.length);
        array = newArray;
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }

    public Object[] getArray() {
        return array;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
