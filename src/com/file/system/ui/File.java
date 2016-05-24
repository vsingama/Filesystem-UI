package com.file.system.ui;

/*
 * Custom File definition. File extends FSElement.
 * Displays the file details
 */
public class File extends FSElement {

	public File(Directory parent, String name, String owner, int size,
			String date) {
		super(parent, name, owner, size, date);

		if (!parent.equals(null))
			parent.appendChild(this);
	}

	public void displayDetails() {
		System.out.println(super.getPath());
	}

}
