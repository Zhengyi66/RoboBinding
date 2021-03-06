package org.robobinding.codegen.viewbinding;

import org.robobinding.annotation.ViewBinding;
import org.robobinding.customviewbinding.CustomViewBinding;

/**
 * @since 1.0
 * @author Cheng Wei
 *
 */
@ViewBinding(simpleOneWayProperties={"readOnlyProp"})
public class ViewBindingWithNonExistingSetter extends CustomViewBinding<ViewWithReadOnlyProperty> {
}
