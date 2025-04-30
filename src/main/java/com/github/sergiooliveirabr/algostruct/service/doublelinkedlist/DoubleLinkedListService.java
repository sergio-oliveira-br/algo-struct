package com.github.sergiooliveirabr.algostruct.service.doublelinkedlist;

import lombok.Data;

@Data
public class DoubleLinkedListService<T> {

    NodeDLL<T> headDLL;
    NodeDLL<T> tailDLL;

    public DoubleLinkedListService() {
        this.headDLL = null;
        this.tailDLL = null;
    }

   public boolean isEmpty() {
       return headDLL == null;
    }
}
