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

package eu.strasbourg.service.place.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import eu.strasbourg.service.place.model.GoogleMyBusinessHistoric;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.MailHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The extended model implementation for the GoogleMyBusinessHistoric service. Represents a row in the &quot;place_GoogleMyBusinessHistoric&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.place.model.GoogleMyBusinessHistoric} interface.
 * </p>
 *
 * @author Angelique Zunino Champougny
 */
@ProviderType
public class GoogleMyBusinessHistoricImpl
	extends GoogleMyBusinessHistoricBaseImpl {

	public final static Log log = LogFactoryUtil.getLog(GoogleMyBusinessHistoricImpl.class);

	private static final long serialVersionUID = 5893961641581179554L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a google my business historic model instance should use the {@link eu.strasbourg.service.place.model.GoogleMyBusinessHistoric} interface instead.
	 */
	public GoogleMyBusinessHistoricImpl() {
	}


	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(GoogleMyBusinessHistoric.class.getName(),
				this.getGoogleMyBusinessHistoricId());
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public List<AssetCategory> getCategories() {
		return AssetVocabularyHelper.getAssetEntryCategories(this.getAssetEntry());
	}

	/**
	 * Renvoie le label affichable du resultat de google mybusiness
	 * @return
	 */
	@Override
	public String getResultLabel() {
		if(getResult() == 0) {
			return "Echec";
		} else if (getResult() == 2) {
			return "Succ&egrave;s avec erreur";
		} else {
			return "Succ&egrave;s";
		}
	}

	/**
	 * Ajout d'une ligne dans le resultat de google mybusiness
	 * @return
	 */
	@Override
	public void addNewOperation(String operation) {
		this.setOperations(
				this.getOperations() +
						"<p>" + operation + "</p>"
		);
		log.info(operation);
	}

	/**
	 * Envoi du mail d'envoi
	 */
	@Override
	public void sendMail() {
		// Properties de l'environnement courrant
		String environment = StrasbourgPropsUtil.getEnvironment();
		// Properties de l'adresse de reception
		String mailAddresses = StrasbourgPropsUtil.getGMBEmail();

		Map<String, Object> context = new HashMap<>();
		context.put("googleMyBusinessHistoric", this);
		context.put("environment", environment);

		TemplateResource templateResourceSubject;
		TemplateResource templateResourceBody;
		Template subjectTemplate;
		Template bodyTemplate;
		String mailSubject;
		String mailBody;
		StringWriter out;


		try {
			// Chargement du template contenant le sujet du mail
			templateResourceSubject = new URLTemplateResource("0",
					Objects.requireNonNull(this.getClass().getClassLoader()
							.getResource("/templates/google-mybusiness-mail-subject.ftl")));
			subjectTemplate = TemplateManagerUtil.getTemplate(
					TemplateConstants.LANG_TYPE_FTL, templateResourceSubject, false);

			// Traitement du template sujet
			out = new StringWriter();
			subjectTemplate.putAll(context);
			subjectTemplate.processTemplate(out);
			mailSubject = out.toString();

			//Chargement du template contenant le corps du mail
			templateResourceBody = new URLTemplateResource("0",
					Objects.requireNonNull(this.getClass().getClassLoader()
							.getResource("/templates/google-mybusiness-mail-body.ftl")));
			bodyTemplate = TemplateManagerUtil.getTemplate(
					TemplateConstants.LANG_TYPE_FTL, templateResourceBody, false);

			// Traitement du template corps
			out = new StringWriter();
			bodyTemplate.putAll(context);
			bodyTemplate.processTemplate(out);
			mailBody = out.toString();
			// Recuperation des patrons

			// Properties de l'adresse d'envoie
			String adminEmailFromAddress = PrefsPropsUtil.getString(
					PortalUtil.getDefaultCompanyId(),
					PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

			// Envoie
			MailHelper.sendMailWithHTML(
					adminEmailFromAddress,
					mailAddresses,
					mailSubject, mailBody);
		} catch (Exception e) {
			log.error(e);
		}
	}
}