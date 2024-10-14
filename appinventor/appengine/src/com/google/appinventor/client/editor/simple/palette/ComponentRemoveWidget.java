// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2015-2018 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.editor.simple.palette;

import com.google.appinventor.client.Ode;
import com.google.appinventor.client.editor.simple.SimpleComponentDatabase;
import com.google.appinventor.client.editor.youngandroid.YaProjectEditor;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;

import static com.google.appinventor.client.Ode.MESSAGES;

/**
 * Defines a widget that has the appearance of a red close button.
 * The Widget is clicked to delete the associated component
 */
public class ComponentRemoveWidget extends AbstractPaletteItemWidget {
  private static final ImageResource imageResource = Ode.getImageBundle().deleteComponent();

  private static final Ode ode = Ode.getInstance();
//<<<<<<< zamanova-ui-redesign
  String name;
//=======
  private final String name;
// master

  public ComponentRemoveWidget(SimpleComponentDescriptor simpleComponentDescriptor) {
    super(simpleComponentDescriptor, imageResource);
    name = simpleComponentDescriptor.getName();
//<<<<<<< zamanova-ui-redesign
  }

  public ComponentRemoveWidget(String name_p) {
    super(imageResource);
    name = name_p;
//=======
//>>>>>>> master
  }

  @Override
  protected void handleClick() {
    if (Window.confirm(MESSAGES.reallyRemoveComponent())) {
      long projectId = ode.getCurrentYoungAndroidProjectId();
      YaProjectEditor projectEditor = (YaProjectEditor) ode.getEditorManager().getOpenProjectEditor(projectId);
      SimpleComponentDatabase componentDatabase = SimpleComponentDatabase.getInstance();
      componentDatabase.addComponentDatabaseListener(projectEditor);
      componentDatabase.removeComponent(name);
    }
  }
}
