/*
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.influxdata.platform;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.influxdata.platform.domain.Organization;
import org.influxdata.platform.domain.User;
import org.influxdata.platform.domain.UserResourceMapping;

/**
 * The client of the InfluxData Platform that implement Organization HTTP API endpoint.
 *
 * @author Jakub Bednar (bednar@github) (11/09/2018 14:58)
 */
public interface OrganizationClient {

    /**
     * Creates a new organization and sets {@link Organization#id} with the new identifier.
     *
     * @param organization the organization to create
     * @return Organization created
     */
    @Nonnull
    Organization createOrganization(@Nonnull final Organization organization);

    /**
     * Creates a new organization and sets {@link Organization#id} with the new identifier.
     *
     * @param name name of the organization
     * @return Organization created
     */
    @Nonnull
    Organization createOrganization(@Nonnull final String name);

    /**
     * Update a organization.
     *
     * @param organization organization update to apply
     * @return organization updated
     */
    @Nonnull
    Organization updateOrganization(@Nonnull final Organization organization);

    /**
     * Delete a organization.
     *
     * @param organization organization to delete
     */
    void deleteOrganization(@Nonnull final Organization organization);

    /**
     * Delete a organization.
     *
     * @param organizationID ID of organization to delete
     */
    void deleteOrganization(@Nonnull final String organizationID);

    /**
     * Retrieve a organization.
     *
     * @param organizationID ID of organization to get
     * @return organization details
     */
    @Nullable
    Organization findOrganizationByID(@Nonnull final String organizationID);

    /**
     * List all organizations.
     *
     * @return List all organizations
     */
    @Nonnull
    List<Organization> findOrganizations();

    /**
     * List all members of an organization.
     *
     * @param organizationID ID of organization to get members
     * @return return the List all members of an organization
     */
    @Nonnull
    List<UserResourceMapping> getMembers(@Nonnull final String organizationID);

    /**
     * List all members of an organization.
     *
     * @param organization of the members
     * @return return the List all members of an organization
     */
    @Nonnull
    List<UserResourceMapping> getMembers(@Nonnull final Organization organization);

    /**
     * Add organization member.
     *
     * @param member       the member of an organization
     * @param organization the organization for the member
     * @return created mapping
     */
    @Nonnull
    UserResourceMapping addMember(@Nonnull final User member, @Nonnull final Organization organization);

    /**
     * Add organization member.
     *
     * @param memberID       the ID of a member
     * @param organizationID the ID of an organization
     * @return created mapping
     */
    @Nonnull
    UserResourceMapping addMember(@Nonnull final String memberID, @Nonnull final String organizationID);

    /**
     * Removes a member from an organization.
     *
     * @param member       the member of an organization
     * @param organization the organization of a member
     */
    void deleteMember(@Nonnull final User member, @Nonnull final Organization organization);

    /**
     * Removes a member from an organization.
     *
     * @param organizationID the ID of an organization
     * @param memberID       the ID of a member
     */
    void deleteMember(@Nonnull final String memberID, @Nonnull final String organizationID);

    /**
     * List all owners of an organization.
     *
     * @param organizationID ID of organization to get owners
     * @return return the List all owners of an organization
     */
    @Nonnull
    List<UserResourceMapping> getOwners(@Nonnull final String organizationID);

    /**
     * List all owners of an organization.
     *
     * @param organization of the owners
     * @return return the List all owners of an organization
     */
    @Nonnull
    List<UserResourceMapping> getOwners(@Nonnull final Organization organization);

    /**
     * Add organization owner.
     *
     * @param owner        the owner of an organization
     * @param organization the organization of a owner
     * @return created mapping
     */
    @Nonnull
    UserResourceMapping addOwner(@Nonnull final User owner, @Nonnull final Organization organization);

    /**
     * Add organization owner.
     *
     * @param organizationID the ID of an organization
     * @param ownerID        the ID of a owner
     * @return created mapping
     */
    @Nonnull
    UserResourceMapping addOwner(@Nonnull final String ownerID, @Nonnull final String organizationID);

    /**
     * Removes a owner from an organization.
     *
     * @param owner        the owner of an organization
     * @param organization the organization of a owner
     */
    void deleteOwner(@Nonnull final User owner, @Nonnull final Organization organization);

    /**
     * Removes a owner from an organization.
     *
     * @param organizationID the ID of an organization
     * @param ownerID        the ID of a owner
     */
    void deleteOwner(@Nonnull final String ownerID, @Nonnull final String organizationID);

    //TODO secrets
    // https://github.com/influxdata/platform/commit/
    // 56de056085c01eb5b3956c9c28c7ea52e4ce63d7#diff-ffefdbced7252e9b741e6138672603da
}