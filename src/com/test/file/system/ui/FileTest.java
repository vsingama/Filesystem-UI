package com.test.file.system.ui;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import com.file.system.ui.Directory;
import com.file.system.ui.File;
import com.file.system.ui.FileSystem;

@SuppressWarnings("unused")
public class FileTest {

	String owner = "Rooney";
	String d1, d2, d3, d4;

	@Test
	public void displayDetailsTest() {

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
		File f1 = new File(f, "a", "vamsi", 1, d2);
		f1.displayDetails();

		System.out.println();
	}

}
