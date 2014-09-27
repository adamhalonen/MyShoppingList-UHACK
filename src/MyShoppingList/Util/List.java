package MyShoppingList.Util;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class List
{
		JList list;
		ArrayList<String> listItems = new ArrayList<String>();
		Container contentpane;
		public JListDemo() {
			list = new JList((ListModel) listItems);
			list.setSelectedIndex(0);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			contentpane.add(new JScrollPane(list));
			list.addListSelectionListener(new ListSelectionListener() {

				public void valueChanged(ListSelectionEvent e) {
					contentpane.setBackground(listColorValues[list
							.getSelectedIndex()]);
				}
			});
		}
}
