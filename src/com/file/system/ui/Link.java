package com.file.system.ui;

/*
 * Class to create a Link by extending FSElement.
 * Appends link to the file / Directory specified
 */
public class Link extends FSElement {

	public Link link1;
	public FSElement felement;

	public Link(Directory parent, String name, String owner, int size,
			String date) {
		super(parent, name, owner, size, date);
		if (!parent.equals(null))
			parent.appendChild(this);
	}

	public void appendLinks(Link link, FSElement fselement) {
		this.link1 = link;
		this.felement = fselement;
	}

	public void setTarget() {

		System.out.println(link1.getPath() + "   linked to ");
		System.out.println(felement.getPath());

	}

	@Override
	public void displayDetails() {

	}

}
