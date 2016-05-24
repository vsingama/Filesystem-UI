package com.file.system.ui;

/*
 * Abstract class accepts Directory and File.
 * Checks if the file present is leaf or not.
 */
public abstract class FSElement {

	private Directory parent;
	private String name;
	private String owner;
	private int size;
	private String created;

	public FSElement(Directory parent, String name, String owner, int size,
			String date) {
		super();
		this.parent = parent;
		this.name = name;
		this.owner = owner;
		this.size = size;
		this.created = date;
	}

	public Directory getParent() {
		return parent;
	}

	public String getName() {
		return name;
	}

	public int getSize() {

		return size;
	}

	public String getOwner() {
		return owner;
	}

	public String getCreated() {
		return created;
	}

	public String getPath() {
		if (!parent.equals(null))
			System.out.format("%22s%20s%10s", "" + parent.getName() + ">"
					+ getName(), getCreated(), getOwner());
		return "";
	}

	public abstract void displayDetails();

	public boolean isLeaf() {
		if (this.getClass().equals(Directory.class))
			return false;
		else
			return true;
	}

}
