/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.council.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import eu.strasbourg.service.council.service.OfficialServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>OfficialServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>eu.strasbourg.service.council.model.OfficialSoap</code>. If the method in the
 * service utility returns a
 * <code>eu.strasbourg.service.council.model.Official</code>, that is translated to a
 * <code>eu.strasbourg.service.council.model.OfficialSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OfficialServiceHttp
 * @generated
 */
@ProviderType
public class OfficialServiceSoap {

	/**
	 * Recherche d'élu pour l'autocompletion
	 *
	 * @param fullName          Nom, prénom ou les deux de l'élu à trouver
	 * @param type              Type de l'élu recherché (peut être vide)
	 * @param removedOfficialId ID de l'élu à retirer de la liste des résultats (0 si non-utilisé)
	 * @param groupId           Site sur lequel cherchés
	 * @return Liste des élus au format JSON
	 */
	public static String getOfficialByFullNameAndType(
			String fullName, String type, long removedOfficialId, long groupId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				OfficialServiceUtil.getOfficialByFullNameAndType(
					fullName, type, removedOfficialId, groupId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Recherche des électeurs pour une session données groupés par statut de connexion et nom complet
	 *
	 * @param councilSessionId
	 * @param groupId          ID du site
	 * @return Tableaux des statuts possibles contenant la liste des électeurs assimilables auxdits statuts
	 */
	public static String getOfficialByConnexionStatus(
			long councilSessionId, long groupId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				OfficialServiceUtil.getOfficialByConnexionStatus(
					councilSessionId, groupId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(OfficialServiceSoap.class);

}