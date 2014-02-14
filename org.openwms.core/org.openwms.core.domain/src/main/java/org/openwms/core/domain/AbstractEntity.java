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
package org.openwms.core.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.xml.bind.annotation.XmlTransient;

/**
 * An AbstractEntity, used as a base class for all domain classes.
 * <p>
 * Adds an unique identified to a subclassed domain class that is created when the class is instantiated on the client tier. At least this
 * uid is created before the instance is persisted the first time. The uid may not be mistaken with the id property that is usually used for
 * database identity (primary key) or with a business key column.
 * </p>
 * <p>
 * This class has an inner static declared class that is registered as a JPA EntityListener and forces the creation of an uid if not already
 * created before. This assures that each persisted entity has an uid.
 * </p>
 * <p>
 * The uid property is used by the ActionScript client application to synchronize client-side entity instances with server-side ones.
 * </p>
 * <strong>NOTE:</strong><br />
 * This class uses the uid for comparison with {@link #equals(Object)} and calculation of {@link #hashCode()}.
 * 
 * @author <a href="mailto:russelltina@users.sourceforge.net">Tina Russell</a>
 * @version $Revision$
 * @since 0.1
 */
@XmlTransient
@MappedSuperclass
@EntityListeners({ AbstractEntity.AbstractEntityListener.class })
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 827478159133738540L;
    private static final int UID_LENGTH = 36;
    /**
     * Suffix for the FIND_ALL named query. Default {@value}
     */
    public static final String FIND_ALL = ".findAll";
    /**
     * Suffix for the FIND_BY_ID named query. Default {@value}
     */
    public static final String FIND_BY_ID = ".findById";

    /**
     * Unique identifier column, used for ActionScript clients.
     */
    /* "UUID" and "UID" are Oracle reserved keywords -> "ENTITY_UID" */
    @XmlTransient
    @Column(name = "C_ENTITY_UID", unique = true, nullable = false, updatable = false, length = UID_LENGTH)
    private String uid;

    /**
     * {@inheritDoc}
     * 
     * Compare the uid property field.
     * 
     * @see java.lang.Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        return (o == this || (o instanceof AbstractEntity && uid().equals(((AbstractEntity) o).uid())));
    }

    /**
     * {@inheritDoc}
     * 
     * Use the uid to calculate the hashCode.
     * 
     * @see java.lang.String#hashCode()
     */
    @Override
    public int hashCode() {
        return uid().hashCode();
    }

    /**
     * An AbstractEntityListener forces the creation of an uid before the entity is persisted.
     * 
     * @author <a href="mailto:russelltina@users.sourceforge.net">Tina Russell</a>
     * @version $Revision$
     * @since 0.1
     */
    @XmlTransient
    public static class AbstractEntityListener {

        /**
         * Before a new entity is persisted we generate an UUID for it.
         * 
         * @param abstractEntity
         *            The entity to persist
         */
        @PrePersist
        public void onPreInsert(AbstractEntity abstractEntity) {
            abstractEntity.uid();
        }
    }

    private String uid() {
        if (uid == null) {
            uid = UUID.randomUUID().toString();
        }
        return uid;
    }
}
