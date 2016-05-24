package com.file.system.ui;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/*
 * Directory extends FSElement 
 * Creates list of FSElements and appends child
 */
public class Directory extends FSElement implements MutableTreeNode {

	public Directory(Directory parent, String name, String owner, int size,
			String date) {
		super(parent, name, owner, size, date);
		
		if (parent != null)
			parent.appendChild(this);
	}

	ArrayList<FSElement> fl = new ArrayList<FSElement>();

	public void appendChild(FSElement element) {
		fl.add(element);
	}

	public ArrayList<FSElement> getChildren() {
		return fl;
	}

	public String getName() {
		return super.getName();
	}

	public String getOwner() {

		return super.getOwner();
	}

	public String getCreated() {
		return super.getCreated();
	}

	public int getSize() {

		return super.getSize();
	}

	public void displayDetails() {

		System.out.println(super.getPath());

		for (FSElement ele : fl)
			ele.displayDetails();
		getChildren();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(MutableTreeNode arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(MutableTreeNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFromParent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParent(MutableTreeNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUserObject(Object arg0) {
		// TODO Auto-generated method stub

	}

}