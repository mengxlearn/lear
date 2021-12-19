package leetcode.middle;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;
import java.util.Objects;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 以尾插式插入链表
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        int remain;
        int div;
        if (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            remain = (l1.val + l2.val) % 10;
            div = (l1.val + l2.val) / 10;
            result = new ListNode(remain);
        } else if (Objects.nonNull(l1)) {
            return l1;
        } else {
            return l2;
        }
        ListNode tmp1 = l1.next;
        ListNode tmp2 = l2.next;
        ListNode index = result;
        ListNode tmpNode;
        while (Objects.nonNull(tmp1) && Objects.nonNull(tmp2)) {
            remain = (tmp1.val + tmp2.val + div) % 10;
            div = (tmp1.val + tmp2.val + div) / 10;
            tmpNode = new ListNode(remain);
            index.next = tmpNode;
            index = index.next;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        while (Objects.nonNull(tmp1)) {
            remain = (tmp1.val + div) % 10;
            div = (tmp1.val + div) / 10;
            tmpNode = new ListNode(remain);
            index.next = tmpNode;
            index = index.next;
            tmp1 = tmp1.next;
        }
        while (Objects.nonNull(tmp2)) {
            remain = (tmp2.val + div) % 10;
            div = (tmp2.val + div) / 10;
            tmpNode = new ListNode(remain);
            index.next = tmpNode;
            index = index.next;
            tmp2 = tmp2.next;
        }
        if (div != 0) {
            tmpNode = new ListNode(div);
            index.next = tmpNode;
        }
        return result;
    }

    /**
     * 优秀题解  将头节点初始化放到了while中，
     * 链表为空，则用零值代替，整个逻辑得以统一
     * 变量初始化值得借鉴
     */
    public ListNode addTwoNum(ListNode l1, ListNode l2){
        ListNode head = null, tail = null;
        int carry = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)){
            int n1 = Objects.nonNull(l1) ? l1.val : 0;
            int n2 = Objects.nonNull(l2) ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (Objects.nonNull(l1)) {
                l1 = l1.next;
            }
            if(Objects.nonNull(l2)) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
