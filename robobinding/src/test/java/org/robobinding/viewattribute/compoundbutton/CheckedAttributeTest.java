/**
 * Copyright 2011 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.viewattribute.compoundbutton;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.robobinding.property.ValueModel;
import org.robobinding.viewattribute.AbstractPropertyViewAttributeWithViewListenersAwareTest;
import org.robobinding.viewattribute.RandomValues;

import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Robert Taylor
 */
public class CheckedAttributeTest extends AbstractPropertyViewAttributeWithViewListenersAwareTest<CheckBox, CheckedAttribute, MockCompoundButtonListeners>
{
	@Test
	public void whenValueModelUpdated_thenViewShouldReflectChanges()
	{
		boolean checked = RandomValues.trueOrFalse();
		
		attribute.valueModelUpdated(checked);
		
		assertThat(view.isChecked(), equalTo(checked));
	}
	
	@Test
	public void whenViewIsChecked_thenUpdateValueModel()
	{
		ValueModel<Boolean> valueModel = twoWayBindToProperty(Boolean.class);
		
		boolean newValue = !view.isChecked();
		view.setChecked(newValue);
		
		assertThat(valueModel.getValue(), equalTo(newValue));
	}
	
	@Test
	public void whenTwoWayBinding_thenRegisterWithMulticastListener()
	{
		CompoundButtonListeners mockCompoundButtonListeners = mock(CompoundButtonListeners.class);
		attribute.setViewListeners(mockCompoundButtonListeners);
		
		twoWayBindToProperty(Boolean.class);
		
		verify(mockCompoundButtonListeners).addOnCheckedChangeListener(any(OnCheckedChangeListener.class));
	}
}