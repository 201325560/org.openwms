/*
 * openwms.org, the Open Warehouse Management System.
 * Copyright (C) 2014 Heiko Scherrer
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
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this software. If not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.openwms.core.service.spring.event;

import org.openwms.core.service.event.EventPublisher;
import org.openwms.core.util.event.RootApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * A NonBlockingEventPublisherImpl is publishing events asynchronously.
 * 
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version $Revision: $
 * @since 0.2
 */
@Component(value = NonBlockingEventPublisherImpl.COMPONENT_NAME)
public class NonBlockingEventPublisherImpl<T extends RootApplicationEvent> implements EventPublisher<T> {

    /** Springs service name. */
    public static final String COMPONENT_NAME = "nonBlockingEventPublisherImpl";

    @Autowired
    private EventDispatcher dispatcher;

    /**
     * {@inheritDoc}
     */
    @Async
    @Override
    public void publish(T event) {
        dispatcher.dispatch(event);
    }
}