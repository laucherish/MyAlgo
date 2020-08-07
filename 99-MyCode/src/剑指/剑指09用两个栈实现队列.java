package 剑指;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 剑指09用两个栈实现队列 {

    Deque<Integer> stackIn;
    Deque<Integer> stackOut;

    public 剑指09用两个栈实现队列() {
        stackIn = new LinkedList<>();
        stackOut = new LinkedList<>();
    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (stackOut.isEmpty()) {
            if (stackIn.isEmpty()) {
                return -1;
            } else {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
            }
        }
        return stackOut.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
