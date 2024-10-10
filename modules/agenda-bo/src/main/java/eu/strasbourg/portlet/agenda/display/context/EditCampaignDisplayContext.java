package eu.strasbourg.portlet.agenda.display.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.service.agenda.service.CampaignLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.constants.VocabularyNames;
import eu.strasbourg.utils.display.context.BaseDisplayContext;

public class EditCampaignDisplayContext extends BaseDisplayContext {

	private Campaign _campaign;

	public EditCampaignDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(request, response);
	}

	public Campaign getCampaign() throws PortalException {
		long campaignId = ParamUtil.getLong(_request, "campaignId");
		if (_campaign == null && campaignId > 0) {
			_campaign = CampaignLocalServiceUtil.getCampaign(campaignId);
		}

		return _campaign;
	}

	public Locale[] getAvailableLocales() {
		Set<Locale> availableLocalesSet = LanguageUtil.getSupportedLocales();
		Locale[] availableLocales = availableLocalesSet
			.toArray(new Locale[availableLocalesSet.size()]);
		return availableLocales;
	}

	/**
	 * @return True si le framework workflow est actif pour ce type d'entité
	 */
	public boolean isWorkflowEnabled() {
		return WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
			_themeDisplay.getCompanyId(), _themeDisplay.getCompanyGroupId(),
			Campaign.class.getName());
	}

	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 */
	public boolean hasPermission(String actionId) throws PortalException {
		return _themeDisplay.getPermissionChecker().hasPermission(
			this._themeDisplay.getCompanyGroupId(),
			StrasbourgPortletKeys.AGENDA_BO, StrasbourgPortletKeys.AGENDA_BO,
			actionId);
	}

	/**
	 * Retourne la liste des ids des thèmes de la campagne sous forme de string
	 */
	public String getThemesIds() throws PortalException {
		return (getCampaign() != null)
			? ListUtil.toString(getCampaign().getThemes(), "categoryId") : "";
	}

	/**
	 * Retourne la liste des themes
	 */
	public List<AssetCategory> getThemes() throws PortalException {
		AssetVocabulary vocabulary = AssetVocabularyHelper
				.getGlobalVocabulary(VocabularyNames.EVENT_THEME);
		if (vocabulary != null) {
			return vocabulary.getCategories();
		}
		return new ArrayList<AssetCategory>();
	}

	/**
	 * Retourne la liste des ids des types de la campagne sous forme de string
	 */
	public String getTypesIds() throws PortalException {
		return (getCampaign() != null)
				? ListUtil.toString(getCampaign().getTypes(), "categoryId") : "";
	}

	/**
	 * Retourne la liste des types
	 */
	public List<AssetCategory> getTypes() throws PortalException {
		AssetVocabulary vocabulary = AssetVocabularyHelper
				.getGlobalVocabulary(VocabularyNames.EVENT_TYPE);
		if (vocabulary != null) {
			return vocabulary.getCategories();
		}
		return new ArrayList<AssetCategory>();
	}

	/**
	 * Retourne la liste des noms des tags de la campagne sous forme de string
	 */
	public String getTagsNames() throws PortalException {
		return (getCampaign() != null)
				? ListUtil.toString(getCampaign().getAssetEntry().getTags(), "name") : "";
	}

	/**
	 * Retourne la liste des tags
	 */
	public long[] getGroupsIds() {
		long globalGroupId = -1;
		long strasGroupId = -1;
		try {
			Company defaultCompany = CompanyLocalServiceUtil.getCompanyByWebId("liferay.com");
			globalGroupId = defaultCompany.getGroup().getGroupId();
			strasGroupId = GroupLocalServiceUtil.getGroup(defaultCompany.getCompanyId(), "Strasbourg.eu").getGroupId();
		} catch (PortalException e) {
			throw new RuntimeException(e);
		}
		return new long[]{strasGroupId, globalGroupId};
	}

}
