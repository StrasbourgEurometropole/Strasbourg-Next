package eu.strasbourg.portlet.interest_viewer;

import com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.portlet.interest_viewer.configuration.InterestViewerConfiguration;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.EventPeriod;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.interest.model.Interest;
import eu.strasbourg.service.interest.service.InterestLocalServiceUtil;
import eu.strasbourg.utils.AssetPublisherTemplateHelper;
import eu.strasbourg.utils.JournalArticleHelper;
import eu.strasbourg.utils.PortalHelper;
import eu.strasbourg.utils.PortletHelper;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class InterestViewerDisplayContext {

	private ThemeDisplay themeDisplay;
	private RenderRequest request;
	private List<Interest> interests;
	private List<List<AssetEntry>> listEntries;
	private List<AssetEntry> entries;
	private InterestViewerConfiguration configuration;

	public InterestViewerDisplayContext(ThemeDisplay themeDisplay, RenderRequest request) {
		this.themeDisplay = themeDisplay;
		this.request = request;
		try {
			this.configuration = themeDisplay.getPortletDisplay()
					.getPortletInstanceConfiguration(InterestViewerConfiguration.class);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public InterestViewerConfiguration getConfiguration() {
		return configuration;
	}

	public String getNoInterestText() {
		String noInterest = "";
		Map<Locale, String> mapText = LocalizationUtil.getLocalizationMap(configuration.noInterestXML());
		for (Map.Entry<Locale, String> map : mapText.entrySet()) {
			if (themeDisplay.getLocale().toString().equals(map.getKey().toString())) {
				noInterest = HtmlUtil.unescape(map.getValue());
				break;
			}
		}
		if (Validator.isNull(noInterest)) {
			noInterest = "No configuration";
		}
		return noInterest;
	}

	public List<AssetEntry> getEntries() {

		if (entries == null) {
			if (listEntries == null) {
				listEntries = this.getListEntries();
			}

			List<AssetEntry> events = listEntries.get(0);
			List<AssetEntry> actus = listEntries.get(1);
			List<AssetEntry> webMag = listEntries.get(2);

			entries = new ArrayList<AssetEntry>();
			entries.addAll(actus);
			entries.addAll(webMag);
			entries.sort(Comparator.comparingInt(this::getDaysBetweenTodayAndPublicationDate));

			for (AssetEntry eventEntry : events) {
				Event event = EventLocalServiceUtil.fetchEvent(eventEntry.getClassPK());
				if (event != null) {
					int i = 0;
					int daysBeforeNextOpenDate = this.getDaysBetweenTodayAndNextOpenDate(event);
					while (i < entries.size()) {
						int daysAfterPublication;
						if (entries.get(i).getClassName().equals(Event.class.getName())) {
							Event event2 = EventLocalServiceUtil.fetchEvent(entries.get(i).getClassPK());
							daysAfterPublication = this.getDaysBetweenTodayAndNextOpenDate(event2);
						} else
							daysAfterPublication = this.getDaysBetweenTodayAndPublicationDate(entries.get(i));
						if (daysBeforeNextOpenDate < daysAfterPublication) {
							entries.add(i, eventEntry);
							break;
						}
						i++;
					}
					if (i == entries.size()) {
						entries.add(eventEntry);
					}
				}
			}

		}
		return entries;

	}

	public List<AssetEntry> getEvents() {
		if (listEntries == null) {
			listEntries = this.getListEntries();
		}
		return listEntries.get(0);
	}

	public List<AssetEntry> getActus() {
		if (listEntries == null) {
			listEntries = this.getListEntries();
		}
		return listEntries.get(1);
	}

	public List<AssetEntry> getActusAndWebmags() {
		if (listEntries == null) {
			listEntries = this.getListEntries();
		}
		List<AssetEntry> actus = getActus();
		List<AssetEntry> webmags = listEntries.get(2);
		List<AssetEntry> actusAndWebmags = new ArrayList<AssetEntry>();
		actusAndWebmags.addAll(actus);
		actusAndWebmags.addAll(webmags);
		actusAndWebmags = actusAndWebmags.stream()
				.sorted((a1, a2) -> a2.getPublishDate().compareTo(a1.getPublishDate())).collect(Collectors.toList());
		int count = configuration.template().equals("liste") ? configuration.newsNumberOnListPage() : 9;
		if(actusAndWebmags.size() <= count){
			return actusAndWebmags;
		}
		return actusAndWebmags.subList(0, count);
	}

	private List<List<AssetEntry>> getListEntries() {
		// récupère les centres d'intérêts de l'utilisateur
		if (interests == null) {
			interests = this.getInterests();
		}

		// récupère les catégories des centres d'intérêts de l'utilisateur
		List<AssetCategory> categoriesCI = new ArrayList<AssetCategory>();
		for (Interest interest : interests) {
			categoriesCI.addAll(interest.getCategories());
		}

		// récupère les vocabulaires liés aux événements et aux actus
		List<AssetCategory> eventSearchCategories = new ArrayList<AssetCategory>();
		List<AssetCategory> actuSearchCategories = new ArrayList<AssetCategory>();
		try {
			List<AssetVocabulary> eventVocabularies = EventLocalServiceUtil
					.getAttachedVocabularies(themeDisplay.getCompany().getGroupId());
			List<AssetVocabulary> actuVocabularies = this.getJournalArticleVocabularies();

			// on stocks les catégories des centres d'intérêts de
			// l'utilisateur qui ont comme vocabulaire un vocabulaire des
			// événements ou des actus
			for (AssetCategory category : categoriesCI) {
				boolean hasEventVocabulary = eventVocabularies.stream()
						.anyMatch(v -> v.getVocabularyId() == category.getVocabularyId());
				boolean hasActuVocabulary = actuVocabularies.stream()
						.anyMatch(v -> v.getVocabularyId() == category.getVocabularyId());
				if (hasEventVocabulary) {
					eventSearchCategories.add(category);
				}
				if (hasActuVocabulary) {
					actuSearchCategories.add(category);
				}
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// récupère les catégoriesId des évènements des centres d'intérêt
		List<Long[]> categorieEventIds = new ArrayList<Long[]>();
		Long[] tabCategories = new Long[eventSearchCategories.size()];
		for (int i = 0; i < eventSearchCategories.size(); i++) {
			tabCategories[i] = eventSearchCategories.get(i).getCategoryId();
		}
		if (tabCategories.length > 0) {
			categorieEventIds.add(tabCategories);
		}

		// récupère les catégoriesId des actualités des centres d'intérêt
		List<Long[]> categorieActuIds = new ArrayList<Long[]>();
		tabCategories = new Long[actuSearchCategories.size()];
		for (int i = 0; i < actuSearchCategories.size(); i++) {
			tabCategories[i] = actuSearchCategories.get(i).getCategoryId();
		}
		if (tabCategories.length > 0) {
			categorieActuIds.add(tabCategories);
		}

		List<List<AssetEntry>> listEntrie = new ArrayList<List<AssetEntry>>();
		listEntrie.add(this.getEvents(categorieEventIds));
		listEntrie.add(this.getActus(categorieActuIds, "actu"));
		listEntrie.add(this.getActus(categorieActuIds, "webmag"));
		return listEntrie;

	}

	private List<Interest> getInterests() {
		LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(request);
		HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();
		String publikUserId = SessionParamUtil.getString(originalRequest, "publik_internal_id");
		return InterestLocalServiceUtil.getByPublikUserId(publikUserId);
	}

	private int getDaysBetweenTodayAndPublicationDate(AssetEntry entry) {
		LocalDate today = LocalDate.now();
		LocalDate publicationDate = entry.getPublishDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return (int) Math.abs(ChronoUnit.DAYS.between(today, publicationDate));
	}

	private int getDaysBetweenTodayAndNextOpenDate(Event event) {
		return (int) Math.abs(ChronoUnit.DAYS.between(LocalDate.now(), event.getNextOpenDate()));
	}

	private List<AssetEntry> getEvents(List<Long[]> prefilterCategoriesIds) {
		List<AssetEntry> entries = new ArrayList<AssetEntry>();
		int count = configuration.template().equals("liste") ? configuration.eventNumberOnListPage() : 9;
		if (prefilterCategoriesIds.size() > 0) {
			List<AssetEntryAssetCategoryRel> entriesRel = new ArrayList<AssetEntryAssetCategoryRel>();
			for (Long[] categoriesIdsGroupByVocabulary : prefilterCategoriesIds) {
				for (long categoryId : categoriesIdsGroupByVocabulary) {
					entriesRel.addAll(AssetEntryAssetCategoryRelLocalServiceUtil.getAssetEntryAssetCategoryRelsByAssetCategoryId(categoryId));
				}
			}

			//transforme les AssetEntriesAssetCategories en AssetEntries
			for (AssetEntryAssetCategoryRel entryRel : entriesRel) {
				if (Validator.isNotNull(entryRel)) {
					try {
						entries.add(AssetEntryLocalServiceUtil.getAssetEntry(entryRel.getAssetEntryId()));
					} catch (PortalException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			List<AssetTag> allTags = AssetTagLocalServiceUtil.getTags();
			for (AssetTag tag : allTags) {
				if (tag.getName().equals("coupdecoeur")) {
					entries.addAll(AssetEntryLocalServiceUtil.getAssetTagAssetEntries(tag.getTagId()));
				}
			}
		}

		List<AssetEntry> result = new ArrayList<AssetEntry>();
		if(!entries.isEmpty()){
			List<Long> classPks = entries.stream().map(AssetEntry::getClassPK).collect(Collectors.toList());
			List<Event> listEvent = EventLocalServiceUtil.findByNextHappening();
			listEvent = listEvent.stream().filter(e -> classPks.contains(e.getEventId())).collect(Collectors.toList());

			for (Event event: listEvent) {
				if(result.size() < count) {
					AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(Event.class.getName(), event.getPrimaryKey());
					if (assetEntry != null) {
						result.add(assetEntry);
					}
				}else
					break;
			}
		}

		return result;
	}

	private List<AssetEntry> getActus(List<Long[]> prefilterCategoriesIds, String tag) {

		List<AssetEntry> entries = new ArrayList<AssetEntry>();

		// Tags
		String tagsNamesString = tag;

		// ClassNames
		String[] classNames = new String[1];
		classNames[0] = JournalArticle.class.getName();

		Group group = GroupLocalServiceUtil.fetchFriendlyURLGroup(this.themeDisplay.getCompanyId(), "/strasbourg.eu");
		int count = configuration.template().equals("liste") ? configuration.newsNumberOnListPage() : 9;
		Hits hits = this.getHits(classNames, tagsNamesString, prefilterCategoriesIds, group.getGroupId(), count,
				"modified_sortable", true);

		// On renvoie la liste des actualités classés par date de publication
		for (Document document : hits.getDocs()) {
			AssetEntry actu = null;
			actu = AssetEntryLocalServiceUtil.fetchEntry(JournalArticle.class.getName(),
					GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
			if (actu != null) {
				entries.add(actu);
			}
		}

		return entries;
	}

	private Hits getHits(String[] classNames, String tagsNamesString, List<Long[]> prefilterCategoriesIds, long idGroup,
			int count, String sortField, boolean sortDesc) {

		// Search context
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(request);
		SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

		// Tags
		String[] prefilterTagsNames = null;
		prefilterTagsNames = StringUtil.split(tagsNamesString);

		// GroupId
		long groupId = idGroup;

		// GlobalGroupId
		long globalGroupId = this.themeDisplay.getCompanyGroupId();

		// GlobalScope
		boolean globalScope = true;

		// Keywords
		String keywords = "";

		// Champ date
		boolean dateField = false;
		String dateFieldName = "";
		LocalDate fromDate = null;
		LocalDate toDate = null;

		// Catégories de la recherche utilisateur (non existantes pour ce
		// portlet)
		List<Long[]> categoriesRechercheIds = new ArrayList<Long[]>();

		// Locale
		Locale locale = this.themeDisplay.getLocale();

		// Pagination et ordre
		int start = 0;
		int end = count;

		// Recherche
		Hits hits = SearchHelper.getGlobalSearchHits(searchContext, classNames, groupId, globalGroupId, globalScope,
				keywords, dateField, dateFieldName, fromDate, toDate, categoriesRechercheIds, prefilterCategoriesIds,
				prefilterTagsNames, true, locale, start, end, sortField, sortDesc);

		return hits;
	}

	public String getJSONEncodedString(String source) {
		return HtmlUtil.escapeJS(source);
	}

	public String getJournalArticleTitle(JournalArticle article, Locale locale) {
		return JournalArticleHelper.getJournalArticleFieldValue(article, "title", locale);
	}

	public String getJournalArticleCatcher(JournalArticle article, Locale locale) {
		return JournalArticleHelper.getJournalArticleFieldValue(article, "chapo", locale);
	}

	public String getJournalArticleImage(JournalArticle article, Locale locale) {
		String documentStructure = JournalArticleHelper.getJournalArticleFieldValue(article, "thumbnail", locale);
		return AssetPublisherTemplateHelper.getDocumentUrl(documentStructure);
	}

	public boolean isMag(String[] tagNames) {
		if (Arrays.toString(tagNames).contains("euromag") || Arrays.toString(tagNames).contains("villemag")
				|| Arrays.toString(tagNames).contains("webmag"))
			return true;
		else
			return false;
	}

	public boolean isFocus(String[] tagNames) {
		if (Arrays.toString(tagNames).contains("focus"))
			return true;
		else
			return false;
	}

	public boolean hasInterest() {
		if (interests == null) {
			interests = this.getInterests();
		}
		return !interests.isEmpty();
	}

	public String getVirtualHostName() {
		Group group = GroupLocalServiceUtil.fetchFriendlyURLGroup(this.themeDisplay.getCompanyId(), "/strasbourg.eu");

		return PortalHelper.getVirtualHostname(group,this.themeDisplay.getLanguageId());
	}

	private List<AssetVocabulary> getJournalArticleVocabularies() {
		List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabularies(-1, -1);
		List<AssetVocabulary> attachedVocabularies = new ArrayList<AssetVocabulary>();
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class);
		for (AssetVocabulary vocabulary : vocabularies) {
			if (LongStream.of(vocabulary.getSelectedClassNameIds()).anyMatch(c -> c == classNameId)) {
				attachedVocabularies.add(vocabulary);
			}
		}
		return attachedVocabularies;
	}

	private boolean eventIsHappeningToday(Event event) {
		LocalDate today = LocalDate.now(ZoneId.of("Europe/Berlin"));
		for (EventPeriod period : event.getEventPeriods()) {
			LocalDate startDate = period.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate endDate = period.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			endDate = endDate.plusDays(1);
			if (today.isAfter(startDate) && today.isBefore(endDate) || today.isEqual(startDate)) {
				return true;
			}
		}
		return false;
	}

	public String DeleteTag(String html) {

		Pattern p = Pattern.compile("<[^>]*>");
		Matcher m = p.matcher(html); 
		return m.replaceAll("");
	}

	public boolean showDeleteButton() {
		return PortletHelper.showDeleteButtonOnDashboard(themeDisplay, themeDisplay.getPortletDisplay().getId());
	}

	public boolean showRetractableButton() {
		return PortletHelper.showRetractableButtonOnDashboard(themeDisplay, themeDisplay.getPortletDisplay().getId());
	}

	public boolean isFolded() {
		return PortletHelper.isPortletFoldedOnDashboard(themeDisplay, themeDisplay.getPortletDisplay().getId());
	}
}
