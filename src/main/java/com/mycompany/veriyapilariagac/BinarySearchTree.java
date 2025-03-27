/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veriyapilariagac;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anıl
 */
public class BinarySearchTree {
    private TreeNode root;
    private List<TreeNode> path;

    public BinarySearchTree() {
        root = null;
        path = new ArrayList<>();
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public boolean search(int value) {
        path.clear();
        return searchRec(root, value) != null;
    }

    private TreeNode searchRec(TreeNode root, int value) {
        if (root == null || root.value == value) {
            return root;
        }
        path.add(root);
        if (value < root.value) {
            return searchRec(root.left, value);
        }
        return searchRec(root.right, value);
    }

    public List<TreeNode> getPath() {
        return path;
    }

    public int findMin() {
        return findMinRec(root);
    }

    private int findMinRec(TreeNode root) {
        if (root.left == null) {
            return root.value;
        }
        return findMinRec(root.left);
    }

    public int findMax() {
        return findMaxRec(root);
    }

    private int findMaxRec(TreeNode root) {
        if (root.right == null) {
            return root.value;
        }
        return findMaxRec(root.right);
    }

    public void inorder(List<Integer> result) {
        inorderRec(root, result);
    }

    private void inorderRec(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderRec(root.left, result);
            result.add(root.value);
            inorderRec(root.right, result);
        }
    }

    public void preorder(List<Integer> result) {
        preorderRec(root, result);
    }

    private void preorderRec(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.value);
            preorderRec(root.left, result);
            preorderRec(root.right, result);
        }
    }

    public void postorder(List<Integer> result) {
        postorderRec(root, result);
    }

    private void postorderRec(TreeNode root, List<Integer> result) {
        if (root != null) {
            postorderRec(root.left, result);
            postorderRec(root.right, result);
            result.add(root.value);
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}