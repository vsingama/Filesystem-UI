package com.test.file.system.ui;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import com.file.system.ui.Directory;
import com.file.system.ui.FSElement;

public class DirectoryTest {

	@Test
	public void getNameTest() {

		Directory root = null;
		String owner = "Rooney";
		String d4;

		DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -3);
		d4 = dateFormat.format(cal.getTime());
		FSElement f = new Directory(root, "Root", owner, 1, d4);
		;

		String expected = "Root";
		String actual = f.getName();
		assertThat(actual, is(expected));

	}

	@Test
	public void getOwnerTest() {

		Directory root = null;
		String owner = "Rooney";
		String d4;

		DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -3);
		d4 = dateFormat.format(cal.getTime());
		FSElement f = new Directory(root, "Root", owner, 1, d4);
		;

		String expected = "Rooney";
		String actual = f.getOwner();
		assertThat(actual, is(expected));

	}

	@Test
	public void getSizeTest() {

		Directory root = null;
		String owner = "Rooney";
		String d4;

		DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -3);
		d4 = dateFormat.format(cal.getTime());
		FSElement f = new Directory(root, "Root", owner, 1, d4);
		;

		int expected = 1;
		int actual = f.getSize();
		assertThat(actual, is(expected));

	}

	@Test
	public void getCreatedTest() {

		Directory root = null;
		String owner = "Rooney";
		String d4;

		DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -3);
		d4 = dateFormat.format(cal.getTime());
		FSElement f = new Directory(root, "Root", owner, 1, d4);
		;

		String expected = d4;
		String actual = f.getCreated();
		assertThat(actual, is(expected));

	}

	@Test
	public void getAllowsChildrenTest() {

		Directory root = null;
		String owner = "Rooney";
		String d4;

		DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -3);
		d4 = dateFormat.format(cal.getTime());
		Directory d1 = new Directory(root, "Root", owner, 1, d4);
		// FSElement f = new Directory(root,"Root",owner,1,d4);

		boolean expected = false;
		boolean actual = d1.getAllowsChildren();
		assertThat(actual, is(expected));

	}

	@Test
	public void isLeafTest() {

		Directory root = null;
		String owner = "Rooney";
		String d4;

		DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -3);
		d4 = dateFormat.format(cal.getTime());
		Directory d1 = new Directory(root, "Root", owner, 1, d4);
		// FSElement f = new Directory(root,"Root",owner,1,d4);

		boolean expected = false;
		boolean actual = d1.isLeaf();
		assertThat(actual, is(expected));

	}

	@Test
	public void getChildCountTest() {

		Directory root = null;
		String owner = "Rooney";
		String d4;

		DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -3);
		d4 = dateFormat.format(cal.getTime());
		Directory d1 = new Directory(root, "Root", owner, 1, d4);
		// FSElement f = new Directory(root,"Root",owner,1,d4);

		int expected = 0;
		int actual = d1.getChildCount();
		assertThat(actual, is(expected));

	}

}
