package cn.michael.dev.java.data.structure.tree;

import java.util.Comparator;

/**
 * Created by hufenggang on 2021/7/19.
 *
 * 二叉搜索树
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    /**
     * 树节点
     *
     * @param <AnyType>
     */
    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        public BinaryNode(AnyType element) {
            this(element, null, null);
        }

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    // 跟节点
    private BinaryNode<AnyType> root;
    private Comparator<? super AnyType> cmp;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Comparator<? super AnyType> c) {
        root = null;
        cmp = c;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 判断是否包含某元素
     *
     * @param x
     * @return
     */
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {

        // 首先判断是否为空
        if (t == null) {
            return false;
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }

    }

    public BinaryNode<AnyType> findMin() {
        return findMin(root);
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        // 首先判断是否为空
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        } else {
            return findMin(t.left);
        }
    }

    public BinaryNode<AnyType> findMax() {
        return findMax(root);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        // 首先判断是否为空
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }

        return t;
    }
}
