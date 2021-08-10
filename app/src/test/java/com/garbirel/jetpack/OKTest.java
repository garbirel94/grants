package com.garbirel.jetpack;

import org.junit.Test;

class OKTest {
    @Test
    public void addition_isCorrect() {
    }

    public ListNodes removeElements(ListNodes head, int val) {
        if(head == null) return head;
        while(head.next != null) {
            if(head.next.val == val) {
                head.next = head.next.next;
            }
        }
        return head;
    }
}


class ListNodes {
     int val;
    ListNodes next;

    ListNodes() {}

    ListNodes(int val) {
         this.val = val;
     }

    ListNodes(int val, ListNodes next) {
         this.val = val;
         this.next = next;
     }
}