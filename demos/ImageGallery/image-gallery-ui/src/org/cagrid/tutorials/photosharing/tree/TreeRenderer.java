/**
*============================================================================
*  Copyright The Ohio State University Research Foundation, The University of Chicago - 
*	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
*	Ekagra Software Technologies Ltd.
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-core/LICENSE.txt for details.
*============================================================================
**/

package org.cagrid.tutorials.photosharing.tree;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;



/**
 * @author <A HREF="MAILTO:langella@bmi.osu.edu">Stephen Langella</A>
 * @author <A HREF="MAILTO:oster@bmi.osu.edu">Scott Oster</A>
 * @author <A HREF="MAILTO:hastings@bmi.osu.edu">Shannon Hastings</A>
 * @author <A HREF="MAILTO:ervin@bmi.osu.edu">David W. Ervin</A>
 * @version $Id: GridGrouperBaseTreeNode.java,v 1.1 2006/08/04 03:49:26 langella
 *          Exp $
 */
public class TreeRenderer extends DefaultTreeCellRenderer {
	
	private static final long serialVersionUID = 1L;

	public TreeRenderer() {
		super();
	}


	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
		boolean leaf, int row, boolean localHasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, localHasFocus);

		if (isBaseTreeNode(value)) {
			BaseTreeNode node = (BaseTreeNode) value;
			this.setIcon(node.getIcon());
			this.setText(node.toString());
		}

		return this;
	}


	private boolean isBaseTreeNode(Object value) {
		if (value instanceof BaseTreeNode) {
			return true;
		}
		return false;
	}
}
