/*
 * openwms.org, the Open Warehouse Management System.
 *
 * This file is part of openwms.org.
 *
 * openwms.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * openwms.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software. If not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
import mx.collections.ArrayCollection;
import mx.collections.XMLListCollection;
import org.openwms.web.flex.client.event.SwitchScreenEvent;
import org.openwms.web.flex.client.model.ModelLocator;
import org.openwms.web.flex.client.MenuItemMap;
import org.openwms.web.flex.client.HashMap;
import org.openwms.web.flex.client.IApplicationModule;

[Bindable]
public var menuCollection:ArrayCollection;
[Bindable]
public var menuBarItemsCollection:XMLListCollection;
[Bindable]
private var modelLocator:ModelLocator = ModelLocator.getInstance();

protected override function initApp():void
{
    trace("InitApp called");
}

/**
 * This method returns a list of menu items which shall be expaned to the main
 * application menu bar.
 */
public function getMainMenuItems():HashMap
{


    var map:MenuItemMap = new MenuItemMap(tmsMenuBar.dataProvider as XMLListCollection);

    /*
       for each (var item:XML in menu)
       {
       if (item.@targetPos != "")
       {
       trace("Put " + item.@label + " to target position " + item.@targetPos);
       map.put(item.@targetPos, new XMLListCollection(XMLList(item)));
       }
       else
       {
       appendOthers = true;
       }
       }
       if (appendOthers)
       {
       for each (item in menu)
       {
       if (item.@targetPos == "")
       {
       trace("Put " + item.@label + " to position " + map.size());
       map.put(map.size(), new XMLListCollection(XMLList(item)));
       }
       }
       }
     */

    //map.put(1, new XMLListCollection(menuList));
    //map.put(3, new XMLListCollection(menuList2));
    return map;
}

/**
 * This method returns the name of the module as unique String identifier.
 */
public function getModuleName():String
{
    return "TMS";
}

/**
 * This method returns a list of items which shall be expaned to the context popup
 * menu. The list contains objects with key,value pairs. The key is the name of the
 * gui component where the popup shall appear, the value is the list of popup items.
 */
public function getPopupItems():ArrayCollection
{
    return new ArrayCollection();
}

public function getViews():ArrayCollection
{
    return new ArrayCollection();
}

