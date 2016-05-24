package com.file.system.ui;
import java.awt.*;

import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.*;
import javax.swing.event.*;

/*
 * Java class to create a UI to execute Linux commands
 */
@SuppressWarnings("serial")
public class FileSystemDesign extends JFrame {

	private JTree tree;
	private JTable jtable;
	private JButton but1, but2;
	private JPanel cp;
	private static Directory root;
	private JTextArea j, disp;
	private JTextField jtfield;
	private DefaultMutableTreeNode dmtn1 = null, dmtn2 = null, dmtn3 = null;
	private DefaultMutableTreeNode dmtn4, dmtn5;
	private DefaultTableModel dtm;

	private String string1, string2 = "";
	String rows[][];
	String columns[] = { "Parent", "Name", "size", "Creation Date", "Owner" };

	static Hashtable<String, FSElement> addFSE = new Hashtable<String, FSElement>();
	ArrayList<String> arrayStr = new ArrayList<String>();
	ArrayList<String> track = new ArrayList<String>();
	FileSystem a = new FileSystem();

	private String display1 = "", display2 = "";

	JList<?> list;
	String[] listColorNames = { "black", "blue", "green", "yellow", "white",
			"red", "orange", "magenta", "darkgray", "cyan" };
	Color[] listColorValues = { Color.BLACK, Color.BLUE, Color.GREEN,
			Color.YELLOW, Color.WHITE, Color.RED, Color.ORANGE, Color.MAGENTA,
			Color.DARK_GRAY, Color.CYAN };
	Container contentpane;

	enum unixCommands {
		pwd, ls, dir, mkdir, rmdir, childcount, cd, history, showAll, showLess
	};

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FileSystemDesign() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = new JPanel();
		setContentPane(cp);
		cp.setBackground(Color.GREEN);
		this.setTitle("File System Design");

		contentpane = getContentPane();
		contentpane.setLayout(new FlowLayout());
		list = new JList(listColorNames);
		list.setSelectedIndex(2);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentpane.add(new JScrollPane(list));
		list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				contentpane.setBackground(listColorValues[list
						.getSelectedIndex()]);
			}
		});

		String owner = "rooney";
		String d1, d2, d3, d4;

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

		root = a.getRoot();
		root.appendChild(new Directory(root, "Root", owner, 1, d4));
		dmtn4 = new DefaultMutableTreeNode(root.getName());
		addFSE.put("Root", root);
		dmtn3 = new DefaultMutableTreeNode("Windows");
		dmtn4.add(dmtn3);
		Directory windows = new Directory(root, "Windows", "vamsi", 5, d3);
		;

		addFSE.put("Windows", windows);

		File file1 = new File(windows, "a", "Honey", 1, d1);
		dmtn2 = new DefaultMutableTreeNode("a");

		dmtn3.add(dmtn2);
		addFSE.put("a", file1);

		File file2 = new File(windows, "b", "Indu", 1, d1);
		dmtn2 = new DefaultMutableTreeNode("b");
		dmtn3.add(dmtn2);
		addFSE.put("b", file2);

		File file3 = new File(windows, "c", owner, 1, d3);
		dmtn2 = new DefaultMutableTreeNode("c");
		dmtn3.add(dmtn2);
		addFSE.put("c", file3);

		dmtn3 = new DefaultMutableTreeNode("MyDocument");
		dmtn4.add(dmtn3);
		Directory myDocument = new Directory(root, "MyDocument", "vamsi", 4, d3);
		addFSE.put("MyDocument", myDocument);

		File file4 = new File(myDocument, "d", "vamsi", 1, d3);
		dmtn2 = new DefaultMutableTreeNode("d");
		dmtn3.add(dmtn2);
		addFSE.put("d", file4);

		Link link1 = new Link(myDocument, "y", "vamsi", 1, d2);
		dmtn2 = new DefaultMutableTreeNode("x Link:d File");
		dmtn3.add(dmtn2);
		addFSE.put("x Link:d File", link1);

		link1.appendLinks(link1, file1);

		dmtn1 = new DefaultMutableTreeNode("MyPictures");
		dmtn3.add(dmtn1);
		Directory myPicture = new Directory(myDocument, "MyPictures", owner, 3,
				d2);
		addFSE.put("MyPictures", myPicture);

		File file5 = new File(myPicture, "e", "Krishna", 1, d2);
		dmtn2 = new DefaultMutableTreeNode("e");
		dmtn1.add(dmtn2);
		addFSE.put("e", file5);

		File file6 = new File(myPicture, "f", "Mata", 1, d1);
		dmtn2 = new DefaultMutableTreeNode("f");
		dmtn1.add(dmtn2);
		addFSE.put("f", file6);

		Link link2 = new Link(myPicture, "x", "vamsi", 1, d2);
		dmtn2 = new DefaultMutableTreeNode("y Link:Windows");
		dmtn1.add(dmtn2);
		addFSE.put("y Link:Windows", link2);
		link2.appendLinks(link2, windows);

		ImageIcon imageIcon = new ImageIcon(
				FileSystemDesign.class.getResource("file1.jpg"));
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(imageIcon);

		JPanel jp = new JPanel();

		tree = new JTree(dmtn4);
		tree.setCellRenderer(renderer);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		Color textColor = new Color(0, 0, 255);
		MatteBorder border2 = new MatteBorder(2, 2, 2, 2, textColor);
		tree.setBorder(border2);

		tree.setDragEnabled(true);
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {

				dmtn5 = (DefaultMutableTreeNode) e.getPath()
						.getLastPathComponent();
			}
		});

		TreePath t = new TreePath(dmtn4);

		tree.expandPath(t);

		jtfield = new JTextField("command");
		JLabel label2 = new JLabel("Enter Your Command :");
		jtfield.setColumns(20);

		jtfield.setPreferredSize(new Dimension(200, 30));
		jtfield.setBorder(border2);
		JPanel jp3 = new JPanel();
		jtfield.setText("");
		jp3.add(label2);
		jp3.add(jtfield);

		disp = new JTextArea(10, 10);
		JLabel text = new JLabel("");

		disp.setBorder(border2);
		disp.setText("\nYou can change the background color \nSelect the color in the left most table \n"
				+ "\nClick on the tabs (Commands) to shift between Commands List and (File System) File System Jtree\n\n" +
				"Select any node in the File System Tab and click Details button to view the details in the Table"
				+ "\nClick on clear button to clear the contents in the Textbox \n"
				+"\nPlease select a node before you type the command");
		disp.setFont(new Font("Arial", Font.BOLD, 12));
		disp.setBackground(Color.lightGray);
		disp.setForeground(Color.RED);
		JScrollPane scrollPane = new JScrollPane(disp);

		jp.add(text);
		jp.add(scrollPane);

		but1 = new JButton();
		but1.setText("Enter");

		ButtonListener bl = new ButtonListener();

		but1.addActionListener(bl);

		jp3.add(but1);

		JButton but11 = new JButton();
		but11.setText("clear");

		ButtonListener bl1 = new ButtonListener();

		but11.addActionListener(bl1);

		jp3.add(but11);

		but11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub

				jtfield.setText("");

			}
		});
		JTextArea unixCommandslist = new JTextArea();
		unixCommandslist.setLineWrap(true);
		unixCommandslist.setWrapStyleWord(true);

		arrayStr.add("    -------- Shell Commands -------- ");
		arrayStr.add("");
		arrayStr.add("      pwd");
		arrayStr.add("      ls");
		arrayStr.add("      dir");
		arrayStr.add("      mkdir <dir name>");
		arrayStr.add("      rmdir (Select node to remove) ");
		arrayStr.add("      childcount");
		arrayStr.add("      cd");
		arrayStr.add("      history");
		arrayStr.add("      showAll");
		arrayStr.add("      showLess");
		arrayStr.add("");

		JLabel liatlabel = new JLabel("");
		JPanel jp4 = new JPanel();

		Iterator<String> it = arrayStr.iterator();

		while (it.hasNext()) {
			string1 = it.next();

			string2 += string1 + "\n";

			unixCommandslist.setText(" " + string2);
		}
		unixCommandslist.setBorder(border2);

		unixCommandslist.setPreferredSize(new Dimension(200, 260));

		jp4.add(liatlabel);
		jp4.add(unixCommandslist);

		JTabbedPane jtp1 = new JTabbedPane();
		getContentPane().add(jtp1);
		jtp1.addTab("Commands", unixCommandslist);
		jtp1.addTab("File System", tree);

		dtm = new DefaultTableModel(rows, columns);
		jtable = new JTable();

		jtable.setBackground(Color.GREEN);

		jtable.setForeground(Color.black);
		jtable.setModel(dtm);

		JScrollPane tableContainer = new JScrollPane(jtable);
		tableContainer.setPreferredSize(new Dimension(600, 260));
		jp4.add(tableContainer);
		jp.add(jp4, BorderLayout.SOUTH);

		but2 = new JButton("Details");

		but2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub

				if (ae.getSource().equals(but2)
						&& addFSE.containsKey(dmtn5.toString())
						&& dmtn5.toString() != dmtn5.getRoot().toString()) {

					DefaultTreeModel treeModel = (DefaultTreeModel) tree
							.getModel();

					String rows[][] = { {
							" "
									+ addFSE.get(dmtn5.toString()).getParent()
											.getName(),
							" " + addFSE.get(dmtn5.toString()).getName(),
							" " + addFSE.get(dmtn5.toString()).getSize(),
							" " + addFSE.get(dmtn5.toString()).getCreated(),
							" " + addFSE.get(dmtn5.toString()).getOwner() } };

					dtm.addRow(rows[0]);

					MatteBorder border = new MatteBorder(1, 1, 1, 1,
							Color.GREEN);
					jtable.setBorder(border);
					treeModel.reload();
					tree.scrollPathToVisible(new TreePath(dmtn5.getPath()));

				} else if (ae.getSource().equals(but2)
						&& addFSE.containsKey(dmtn5.toString())
						&& dmtn5.toString() == dmtn5.getRoot().toString()) {

					DefaultTreeModel treeModel = (DefaultTreeModel) tree
							.getModel();

					String rows[][] = { {
							" " + addFSE.get(dmtn5.toString()).getName(),
							" " + addFSE.get(dmtn5.toString()).getName(),
							" " + addFSE.get(dmtn5.toString()).getSize(),
							" " + addFSE.get(dmtn5.toString()).getCreated(),
							" " + addFSE.get(dmtn5.toString()).getOwner() } };

					System.out.println(dmtn5.getParent());

					dtm.addRow(rows[0]);

					// Color color = UIManager.getColor("Table.gridColor");
					MatteBorder border = new MatteBorder(1, 1, 1, 1,
							Color.GREEN);
					jtable.setBorder(border);
					treeModel.reload();

				}

			}
		});

		jp3.add(but2);
		jp.add(jp3, BorderLayout.CENTER);

		j = new JTextArea(10, 20);
		JLabel label1 = new JLabel("");

		j.setBorder(border2);
		j.setText("\n Vamsi@680Shell > ");
		j.setBackground(Color.lightGray);
		j.setForeground(Color.BLUE);
		JScrollPane scrollPane4 = new JScrollPane(j);

		jp.add(label1);
		jp.add(scrollPane4);

		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		this.add(jp);
		this.pack();
		this.setVisible(true);
	}

	public class ButtonListener implements ActionListener {

		@SuppressWarnings("rawtypes")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String d1;

			DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
			Calendar cal = Calendar.getInstance();

			cal.add(Calendar.DATE, 0);
			d1 = dateFormat.format(cal.getTime());

			unixCommands[] c = unixCommands.values();

			for (unixCommands d : c) {

				if (dmtn5 != null) {

					switch (d) {

					
					case pwd:

						if (e.getSource().equals(but1)
								&& jtfield.getText().equals(
										unixCommands.pwd.toString())) {
							String currentdir = tree
									.getLastSelectedPathComponent().toString();
							track.add(unixCommands.pwd.toString());
							display2 = "Present Working Directory  is : "
									+ currentdir + "\n";

							j.append("" + display2 + "\n");

						}
						break;

					case dir:
						String st = "";
						String st2 = "";

						if (e.getSource().equals(but1)
								&& jtfield.getText().equals(
										unixCommands.dir.toString())) {

							if (dmtn5.toString().equals(null)) {

								j.setText("You must select a node");
							}

							track.add(unixCommands.dir.toString());

							a.setCurrent(a.getRoot());

							if (!dmtn5.toString().equals("/")) {
								Enumeration names = addFSE.keys();
								while (names.hasMoreElements()) {
									String str = (String) names.nextElement();

									Object listchild = tree
											.getLastSelectedPathComponent();
									DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) listchild;

									if (dmtn5.toString().equals(
											addFSE.get(str).getName())) {
										for (Enumeration enumValue = treeNode
												.children(); enumValue
												.hasMoreElements();) {
											st = enumValue.nextElement()
													.toString();
											st2 += " Name : "
													+ addFSE.get(st).getName()
													+ "  Parent :  "
													+ addFSE.get(st)
															.getParent()
															.getName()
													+ "  Size : "
													+ addFSE.get(st).getSize()
													+ "  Owner :  "
													+ addFSE.get(st).getOwner()
													+ "\n";

											j.setText(">\n Below are the Details of the files in the selected directory : \n\n"
													+ st2 + "\n");

										}
									}
								}
							}
						}

						break;

					case cd:

						if (e.getSource().equals(but1)
								&& jtfield.getText().equals(
										unixCommands.cd.toString())) {
							track.add(unixCommands.cd.toString());

							a.setCurrent(root);

							System.out.println(a.getChildren());

							display2 = " \n You are currently in root Directory ";
							for (int i = 0; i < tree.getRowCount(); i++) {
								tree.collapseRow(i);
							}

							j.append("> " + display2 + "\n");

						}
						break;

					case mkdir:

						if (e.getSource().equals(but1)
								&& jtfield.getText().startsWith(
										unixCommands.mkdir.toString())
								&& jtfield.getText().contains(" ")
								&& dmtn5.isLeaf() != true) {

							track.add(unixCommands.mkdir.toString());

							String splitter = jtfield.getText();
							String[] parts = splitter.split(" ");
							String part2 = parts[1];

							DefaultTreeModel treeModel = (DefaultTreeModel) tree
									.getModel();
							DefaultMutableTreeNode newdir = new DefaultMutableTreeNode(
									part2);

							dmtn5.add(newdir);
							treeModel.reload();
							tree.scrollPathToVisible(new TreePath(newdir
									.getPath()));

							Directory mkdir = new Directory(
									addFSE.get(dmtn5.getChildAt(0).toString())
											.getParent(), part2, "vamsi", 1, d1);

							addFSE.put(part2, mkdir);

							display2 = "Creating the Directory ....  \nDirectory : "
									+ part2
									+ " is created successfully ...!! "
									+ "\n";

							j.append("> " + display2 + "\n");

						}

						break;

					case childcount:

						if (e.getSource().equals(but1)
								&& jtfield.getText().equals(
										unixCommands.childcount.toString())) {

							Object childcount = tree
									.getLastSelectedPathComponent();
							DefaultMutableTreeNode theFile = (DefaultMutableTreeNode) childcount;
							theFile.getChildCount();
							track.add(unixCommands.childcount.toString());
							display2 = "\n Number of files/directories in  "
									+ "'" + theFile + "'" + " is : "
									+ theFile.getChildCount() + "\n";
							j.append("" + display2 + "\n");

						}
						break;

					case ls:

						String child = "";

						if (e.getSource().equals(but1)
								&& jtfield.getText().equals(
										unixCommands.ls.toString())) {

							Object listchild = tree
									.getLastSelectedPathComponent();
							DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) listchild;
							track.add(unixCommands.ls.toString());

							for (Enumeration enumValue = treeNode.children(); enumValue
									.hasMoreElements();) {

								child += enumValue.nextElement().toString()
										+ "\n";
								j.setText(" \nBelow are the Directory contents  \n"
										+ child);

							}
						}

						break;

					case rmdir:

						if (e.getSource().equals(but1)
								&& jtfield.getText().equals(
										unixCommands.rmdir.toString())
								&& dmtn5.toString() != null) {
							track.add(unixCommands.rmdir.toString());

							DefaultTreeModel treeModel = (DefaultTreeModel) (tree
									.getModel());

							treeModel.removeNodeFromParent(dmtn5);
							display2 = "\n Removing the node .... \n Selected Node is  Removed successfully ...!!"
									+ "\n";

							j.append("> " + display2);
						}

						break;

					case history:

						String arrayStr;
						String hist = "";

						if (e.getSource().equals(but1)
								&& jtfield.getText().equals(
										unixCommands.history.toString())) {
							System.out.println(track.size());

							Iterator<String> it = track.iterator();

							while (it.hasNext()) {
								arrayStr = it.next();
								hist += arrayStr + "\n";
								j.setText("> \n" + hist);
							}
						}
						break;
						
					case showAll:

						if (e.getSource().equals(but1)
								&& jtfield.getText().equals(
										unixCommands.showAll.toString())) {
							track.add(unixCommands.showAll.toString());

							for (int i = 0; i < tree.getRowCount(); i++) {
								tree.expandRow(i);
							}
							display2 = "\n Tree Expanded Successfully \nCheck the File Structure Tab to see the Expanded Tree";

							j.append("> " + display2 + "\n");

						}

						break;

					case showLess:

						if (e.getSource().equals(but1)
								&& jtfield.getText().equals(
										unixCommands.showLess.toString())) {

							track.add(unixCommands.showLess.toString());
							for (int i = 0; i < tree.getRowCount(); i++) {
								tree.collapseRow(i);
								display2 = "\n Tree Depricated Successfully \nCheck the File Structure Tab to see the Deprecated Tree";

								j.append("> " + display2 + "\n");
							}

						}
						break;

					}
				}

				else if (dmtn5 == null) {

					j.setText("Error : You must select a node to execute "
							+ "\n");

				} else {
					break;
				}
			}
			if (dmtn5 == null) {
				display1 = "Please select any node in the File Structure Tab to execute the command";
				JOptionPane.showMessageDialog(FileSystemDesign.this, display1,
						"ALERT", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		new FileSystemDesign();
	}

}