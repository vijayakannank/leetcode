package designPattern.behavioral.Iterator;

import java.util.List;

public class NameRepository  implements Container{

    List<String> list;

    NameRepository(List<String> list){
        this.list = list;
    }


    @Override
    public Iterator getIterator() {
        return new NameSpaceIterator();
    }

    private class NameSpaceIterator implements Iterator {
         int index =0;
        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public Object next() {
            return list.get(index++);
        }
    }


}
