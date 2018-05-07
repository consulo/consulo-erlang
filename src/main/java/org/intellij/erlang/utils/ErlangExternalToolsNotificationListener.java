/*
 * Copyright 2012-2013 Sergey Ignatov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.erlang.utils;

import javax.swing.event.HyperlinkEvent;

import javax.annotation.Nonnull;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationListener;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.Project;

public class ErlangExternalToolsNotificationListener implements NotificationListener
{
	public static final String ERLANG_RELATED_TOOLS = "Erlang External Tools";

	@Nonnull
	private final Project myProject;

	public ErlangExternalToolsNotificationListener(@Nonnull Project project)
	{
		myProject = project;
	}

	@Override
	public void hyperlinkUpdate(@Nonnull Notification notification, @Nonnull HyperlinkEvent event)
	{
		if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
		{
			if(event.getDescription().equals("configure") && !myProject.isDisposed())
			{
				ShowSettingsUtil.getInstance().showSettingsDialog(myProject, ERLANG_RELATED_TOOLS);
			}
		}
	}
}
