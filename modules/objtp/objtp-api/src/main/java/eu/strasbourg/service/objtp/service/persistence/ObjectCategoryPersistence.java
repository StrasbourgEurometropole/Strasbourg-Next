/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.objtp.exception.NoSuchObjectCategoryException;
import eu.strasbourg.service.objtp.model.ObjectCategory;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the object category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author JeremyZwickert
 * @see ObjectCategoryUtil
 * @generated
 */
@ProviderType
public interface ObjectCategoryPersistence
	extends BasePersistence<ObjectCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ObjectCategoryUtil} to access the object category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the object category in the entity cache if it is enabled.
	 *
	 * @param objectCategory the object category
	 */
	public void cacheResult(ObjectCategory objectCategory);

	/**
	 * Caches the object categories in the entity cache if it is enabled.
	 *
	 * @param objectCategories the object categories
	 */
	public void cacheResult(java.util.List<ObjectCategory> objectCategories);

	/**
	 * Creates a new object category with the primary key. Does not add the object category to the database.
	 *
	 * @param code the primary key for the new object category
	 * @return the new object category
	 */
	public ObjectCategory create(String code);

	/**
	 * Removes the object category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param code the primary key of the object category
	 * @return the object category that was removed
	 * @throws NoSuchObjectCategoryException if a object category with the primary key could not be found
	 */
	public ObjectCategory remove(String code)
		throws NoSuchObjectCategoryException;

	public ObjectCategory updateImpl(ObjectCategory objectCategory);

	/**
	 * Returns the object category with the primary key or throws a <code>NoSuchObjectCategoryException</code> if it could not be found.
	 *
	 * @param code the primary key of the object category
	 * @return the object category
	 * @throws NoSuchObjectCategoryException if a object category with the primary key could not be found
	 */
	public ObjectCategory findByPrimaryKey(String code)
		throws NoSuchObjectCategoryException;

	/**
	 * Returns the object category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param code the primary key of the object category
	 * @return the object category, or <code>null</code> if a object category with the primary key could not be found
	 */
	public ObjectCategory fetchByPrimaryKey(String code);

	/**
	 * Returns all the object categories.
	 *
	 * @return the object categories
	 */
	public java.util.List<ObjectCategory> findAll();

	/**
	 * Returns a range of all the object categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of object categories
	 * @param end the upper bound of the range of object categories (not inclusive)
	 * @return the range of object categories
	 */
	public java.util.List<ObjectCategory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the object categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of object categories
	 * @param end the upper bound of the range of object categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of object categories
	 */
	public java.util.List<ObjectCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ObjectCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the object categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of object categories
	 * @param end the upper bound of the range of object categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of object categories
	 */
	public java.util.List<ObjectCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ObjectCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the object categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of object categories.
	 *
	 * @return the number of object categories
	 */
	public int countAll();

}