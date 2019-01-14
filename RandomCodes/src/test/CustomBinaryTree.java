package test;

class TreeNode {
	TreeNode next;
	TreeNode prev;
	int data;
}

public class CustomBinaryTree {

	TreeNode root = null;

	public void add(TreeNode node) {
		boolean added = false;
		TreeNode temp = root;
		if (root == null)
			root = node;
		else {
			System.out.println("outer loop.");
			while (!added) {
				if (node.data > temp.data && temp.next != null)
					temp = temp.next;
				else if (node.data <= temp.data && temp.prev != null)
					temp = temp.prev;
				else {
					if (node.data <= temp.data) {
						temp.prev = node;
						added = true;
					} else {
						temp.next = node;
						added = true;
					}
				}
			}
		}
	}

	public void showTree() {
		TreeNode temp1 = root;
		TreeNode temp2 = root;
		System.out.println(temp1.data);
		System.out.println(temp2.data);

		while (temp1.next != null && temp1.prev != null) {
			System.out.println(temp1.data);
			System.out.println(temp2.data);
			temp1 = temp1.next;
			temp2 = temp2.prev;
		}
	}

	public static void main(String[] args) {
		CustomBinaryTree t = new CustomBinaryTree();

		TreeNode tn1 = new TreeNode();
		tn1.data = 12;
		t.add(tn1);

		TreeNode tn2 = new TreeNode();
		tn2.data = 594;
		t.add(tn2);

		TreeNode tn3 = new TreeNode();
		tn3.data = 124;
		t.add(tn3);

		TreeNode tn4 = new TreeNode();
		tn4.data = 7984;
		t.add(tn4);

		t.showTree();
	}
}
