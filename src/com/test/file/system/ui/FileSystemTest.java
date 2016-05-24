package com.test.file.system.ui;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import com.file.system.ui.Directory;
import com.file.system.ui.File;
import com.file.system.ui.FileSystem;
import com.file.system.ui.Link;

public class FileSystemTest {

	private static Directory root;

	String owner = "Rooney";
	String d1, d2, d3, d4;

	@Test
	public void getRootTest() {

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

		FileSystem fs = new FileSystem();
		Directory root = null;
		root = new Directory(root, "Root", owner, 1, d4);

		String expected = root.getName();
		String actual = fs.getRoot().getName();
		assertThat(actual, is(expected));
	}

	@Test
	public void getOwnerTest() {

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

		FileSystem fs = new FileSystem();
		Directory root = null;
		root = new Directory(root, "Root", owner, 1, d4);
		fs.setCurrent(root);

		String actual = owner;
		String expected = fs.getOwner();
		assertThat(actual, is(expected));
	}

	@Test
	public void getCurrentTest() {

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

		FileSystem fs = new FileSystem();
		Directory root = null;
		root = new Directory(root, "Root", owner, 1, d4);
		fs.setCurrent(root);

		Directory actual = root;
		Directory expected = fs.getCurrent();
		assertThat(actual, is(expected));
	}

	@Test
	public void getCurrentParentTest() {

		FileSystem fs = new FileSystem();
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
		Directory root = null;
		root = new Directory(root, "home", "Vamsi", 0, d1);
		root.appendChild(new Directory(root, "home", "Vamsi", 0, d1));
		Directory f = new Directory(root, "home", "Vamsi", 0, d1);
		fs.setCurrent(f);
		new File(f, "a", "vamsi", 1, d2);
		new File(f, "b", "rooney", 0, d3);
		String expected = "home";

		String actual = fs.getCurrentParent();
		assertThat(actual, is(expected));
	}

	@Test
	public void getAllTest() {

		FileSystem fs = new FileSystem();
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
		Directory root = null;
		root = new Directory(root, "home", "Vamsi", 0, d1);
		root.appendChild(new Directory(root, "home", "Vamsi", 0, d1));
		Directory f = new Directory(root, "home", "Vamsi", 0, d1);
		fs.setCurrent(f);
		new File(f, "a", "vamsi", 1, d2);
		new File(f, "b", "rooney", 0, d3);

		System.out.println("         		File System Structure :");
		System.out.println();
		System.out.format("%30s%30s%20s", "" + "File/Directory",
				"Creation/Modification Date", "owner");
		System.out.println();
		System.out
				.println("    -----------------------------------------------------------------------------------------");
		System.out.println();

		fs.getAll();
		String expected = "home";

		String actual = fs.getCurrentParent();
		assertThat(actual, is(expected));
	}

	@Test
	public void setFileTest() {

		FileSystem fs = new FileSystem();
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
		Directory root = null;
		root = new Directory(root, "home", "Vamsi", 0, d1);
		root.appendChild(new Directory(root, "home", "Vamsi", 0, d1));
		Directory f = new Directory(root, "home", "Vamsi", 0, d1);
		fs.setCurrent(f);
		new File(f, "a", "vamsi", 1, d2);
		new File(f, "b", "rooney", 0, d3);

		String expected = "home";

		String actual = fs.getCurrentParent();
		assertThat(actual, is(expected));
	}

	@Test
	public void setLinkTest() {

		FileSystem fs = new FileSystem();
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
		Directory root = null;
		root = new Directory(root, "home", "Vamsi", 0, d1);
		root.appendChild(new Directory(root, "home", "Vamsi", 0, d1));
		Directory f = new Directory(root, "home", "Vamsi", 0, d1);
		fs.setCurrent(f);
		new File(f, "a", "vamsi", 1, d2);
		new File(f, "b", "rooney", 0, d3);

		new Link(f, "y", "vamsi", 1, d2);

		String expected = "home";

		String actual = fs.getCurrentParent();
		assertThat(actual, is(expected));
	}
}
