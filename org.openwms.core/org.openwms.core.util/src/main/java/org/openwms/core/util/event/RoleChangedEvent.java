/*
 * openwms.org, the Open Warehouse Management System.
 * Copyright (C) 2014 Heiko Scherrer
 *
 * This file is part of openwms.org.
 *
 * openwms.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as 
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * openwms.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this software. If not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.openwms.core.util.event;

/**
 * A RoleChangedEvent is fired to notify listeners about changes on an <code>Role</code> instance. A listener could probably evict a cache
 * of Roles.
 * 
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version $Revision: $
 * @since 0.2
 */
public class RoleChangedEvent extends RootApplicationEvent {

    private static final long serialVersionUID = 5841462185501374901L;

    /**
     * Create a new RoleChangedEvent.
     * 
     * @param source
     *            The <code>Role</code> that has changed or <code>null</code>
     */
    public RoleChangedEvent(Object source) {
        super(source);
    }
}