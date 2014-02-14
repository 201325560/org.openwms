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
package org.openwms.core.service.exception;

/**
 * A ServiceException is a checked application exception thrown in service layer classes.
 * 
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version $Revision$
 * @since 0.1
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = -4416392376427389375L;

    /**
     * Create a new ServiceException with a message text.
     * 
     * @param message
     *            Detail message
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Create a new ServiceException with a cause exception.
     * 
     * @param cause
     *            Root cause
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Create a new ServiceException with a message text and the cause exception.
     * 
     * @param message
     *            Detail message
     * @param cause
     *            Root cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}