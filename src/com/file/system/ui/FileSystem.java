package com.file.system.ui;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * File System contains Directory and prints file structure.
 */
public class FileSystem {

	private Directory current;

	private static Directory root;

	String owner = "Rooney";
	String d1, d2, d3, d4;

	public void getAll() {

		System.out.println(" File System Structure :");
		System.out.println();
		System.out.format("%22s%20s%10s", "File/Directory", "Creation Date",
				"owner");
		System.out.println();
		System.out
				.println("------------------------------------------------------------------");
		System.out.println();
		current.displayDetails();

	}

	public Directory getRoot() {
		DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, 0);
		d1 = dateFormat.format(cal.getTime());

		cal.add(Calendar.DATE, -1);
		d2 = dateFormat.format(cal.getTime());

		cal.add(Calendar.DATE, -2);
		d3 = dateFormat.format(cal.getTime());

		cal.add(Calendar.DATE, -3);
		d4 = dateFormat.format(cal.getTime());

		root = new Directory(root, "Root", owner, 1, d4);

		return root;
	}

	public void setFile(Directory d, String name, int size, String owner,
			String date) {
		new File(d, name, owner, size, date);
	}

	public void setLink(Directory d, String name, int size, String owner,
			String date) {
		new Link(d, name, owner, size, date);
	}

	public String getOwner() {
		return current.getOwner();
	}

	public Directory getCurrent() {
		return current;
	}

	public String getChildren() {
		String str = "";
		for (FSElement fselement : current.fl)
			str += fselement.getName() + "\n";
		return str;
	}

	public void setCurrent(Directory current) {
		this.current = current;
	}

	public String getCurrentParent() {
		return current.getParent().getName();
	}

}
