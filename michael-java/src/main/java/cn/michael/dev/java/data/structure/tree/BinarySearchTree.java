package cn.michael.dev.java.data.structure.tree;

import java.util.Comparator;

/**
 * Created by hufenggang on 2021/7/19.
 * <p>
 * 二叉搜索树
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private Comparator<? super AnyType> cmp;
    // 跟节点
    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Comparator<? super AnyType> c) {
        root = null;
        cmp = c;
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

    /**
     * 思路：从跟节点开始遍历，如果比跟节点小，查找左子树，如果比跟节点大，查找右子树
     *
     * @param value
     * @return
     */
    public BinaryNode<AnyType> find(AnyType value) {
        if (root == null) {
            return null;
        }
        BinaryNode<AnyType> current = root;

        while (current.element != value) {
            int compareResult = current.element.compareTo(value);
            if (compareResult > 0) {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }

        return current;
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

    public BinaryNode<AnyType> findMin() {
        return findMin(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
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

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {

        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {
            // Nothing
        }

        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {

        if (t == null) {
            return t;
        }

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

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
}
