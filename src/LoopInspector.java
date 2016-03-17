public class LoopInspector {
    /**
     * Given a node that is the beginning of a linked list
     * (Already created, Use node.getNext() to get the next node),
     * Determine the length of the loop.
     * <p>
     * This list always contains a tail and a loop.
     *
     * @param node a node in a linked list
     * @return size of the loop
     */
    public int loopSizeRunners(Node node) {
        // use two runners to detect a loop
        Node slow = node;
        Node fast = node.getNext();
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        // jump out of the while loop when two runners meet in the loop
        int size = 1;
        // keep the slow runner static
        // let the fast runner keep running (but doesn't skip anymore)
        fast = fast.getNext();
        // and add a counter to record the size of the loop
        for (; slow != fast; size++) fast = fast.getNext();
        return size;
    }

    public int loopSizeHash(Node node) {
        Node runner = node;
        HashSet<Node> nodes = new HashSet<>();
        int size = 0;
        while (true) {
            // enter if if loop detected
            if (!nodes.add(runner)) {
                Node inspector = runner;
                size = 1;
                // compare running node with static node with an increment
                for (; runner.getNext() != inspector; size++)
                    runner = runner.getNext();
                break;
            }
            runner = runner.getNext();
        }
        return size;
    }
}