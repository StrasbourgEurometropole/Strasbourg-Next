package eu.strasbourg.webservice.csmap.utils.test;


import com.liferay.asset.category.property.model.AssetCategoryProperty;
import com.liferay.asset.category.property.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import eu.strasbourg.service.favorite.model.Favorite;
import eu.strasbourg.service.gtfs.model.Arret;
import eu.strasbourg.service.gtfs.model.Direction;
import eu.strasbourg.service.gtfs.model.Ligne;
import eu.strasbourg.service.notif.model.ServiceNotif;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.utils.AssetPublisherTemplateHelper;
import eu.strasbourg.utils.JournalArticleHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.UriHelper;
import eu.strasbourg.webservice.csmap.constants.WSConstants;
import eu.strasbourg.webservice.csmap.utils.CSMapJSonHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class CSMapJsonHelperTest {

    @Mock
    private JournalArticle journalArticleMock;

    @Mock
    private Favorite favoriteMock;

    @Mock
    private Arret arretMock;

    @Mock
    private Ligne ligneMock;

    @Mock
    private ServiceNotif serviceNotifMock;

    @Mock
    private AssetCategory categoryMock;

    @Mock
    private AssetCategoryProperty assetCategoryPropertyMock;

    @Mock
    private DLFileEntry dlFileEntryMock;

    @Mock
    private Place placeMock;

    @Mock
    private Direction directionMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBreveCSMapJSON() throws URISyntaxException {
        when(journalArticleMock.getResourcePrimKey()).thenReturn(12345L);
        when(journalArticleMock.getModifiedDate()).thenReturn(new Date());
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "image", Locale.FRANCE)).thenReturn("imageValue");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "title", Locale.FRANCE)).thenReturn("Title");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "chapo", Locale.FRANCE)).thenReturn("Chapo");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "content", Locale.FRANCE)).thenReturn("Content");
        when(AssetPublisherTemplateHelper.getDocumentUrl("imageValue")).thenReturn("imageUrl");
        when(StrasbourgPropsUtil.getBaseURL()).thenReturn("http://example.com");
        when(UriHelper.appendUriImagePreview(anyString())).thenReturn(new URI("http://example.com/imageUrl"));

        JSONObject result = CSMapJSonHelper.getBreveCSMapJSON(journalArticleMock);
        Assert.assertNotNull(result);
        Assert.assertEquals(12345L, result.getLong(WSConstants.JSON_WC_ID));
        Assert.assertEquals("http://example.com/imageUrl", result.getString(WSConstants.JSON_WC_URL));
        Assert.assertEquals("Title", result.getJSONObject(WSConstants.JSON_WC_TITLE).getString(WSConstants.JSON_LANGUAGE_FRANCE));
        Assert.assertEquals("Chapo", result.getJSONObject(WSConstants.JSON_SUBTITLE).getString(WSConstants.JSON_LANGUAGE_FRANCE));
        Assert.assertEquals("Content", result.getJSONObject(WSConstants.JSON_DESCRIPTION).getString(WSConstants.JSON_LANGUAGE_FRANCE));
    }

    @Test
    public void testEmergencyCSMapJSON() throws Exception {
        List<JournalArticle> emergencyNumbers = Collections.singletonList(journalArticleMock);
        Map<AssetCategory, List<JournalArticle>> emergencyHelpsMap = new HashMap<>();
        emergencyHelpsMap.put(categoryMock, Collections.singletonList(journalArticleMock));

        when(journalArticleMock.getResourcePrimKey()).thenReturn(12345L);
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, WSConstants.JSON_WC_TITLE, Locale.FRANCE)).thenReturn("EmergencyTitle");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "order", Locale.FRANCE)).thenReturn("1");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "number", Locale.FRANCE)).thenReturn("112");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "fontColor", Locale.FRANCE)).thenReturn("#FFFFFF");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "backgroundColor", Locale.FRANCE)).thenReturn("#000000");

        when(categoryMock.getCategoryId()).thenReturn(1L);
        when(categoryMock.getTitle(Locale.FRANCE)).thenReturn("CategoryTitle");
        when(AssetCategoryPropertyLocalServiceUtil.getCategoryProperty(1L, "order")).thenReturn(assetCategoryPropertyMock);
        when(assetCategoryPropertyMock.getValue()).thenReturn("1");

        JSONObject result = CSMapJSonHelper.emergencyCSMapJSON(emergencyNumbers, emergencyHelpsMap);
        Assert.assertNotNull(result);
        JSONArray emergencyNumbersArray = result.getJSONArray(WSConstants.JSON_WC_EMERGENCY_NUMBERS);
        Assert.assertEquals(1, emergencyNumbersArray.length());
        JSONObject emergencyNumberJson = emergencyNumbersArray.getJSONObject(0);
        Assert.assertEquals(12345L, emergencyNumberJson.getLong("id"));
        Assert.assertEquals("112", emergencyNumberJson.getString(WSConstants.JSON_WC_NUMBER));
        Assert.assertEquals("EmergencyTitle", emergencyNumberJson.getJSONObject(WSConstants.JSON_WC_TITLE).getString("fr_FR"));

        JSONArray emergencyHelpsArray = result.getJSONArray(WSConstants.JSON_WC_EMERGENCY_HELPS);
        Assert.assertEquals(1, emergencyHelpsArray.length());
        JSONObject emergencyHelpJson = emergencyHelpsArray.getJSONObject(0);
        Assert.assertEquals(1L, emergencyHelpJson.getLong(WSConstants.JSON_WC_CATEGORY_ID));
        Assert.assertEquals("CategoryTitle", emergencyHelpJson.getJSONObject(WSConstants.JSON_WC_CATEGORY_TITLE).getString("fr_FR"));
    }

    @Test
    public void testGetSocialNetworkCSMapJSON() {
        when(journalArticleMock.getResourcePrimKey()).thenReturn(12345L);
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "title", Locale.FRANCE)).thenReturn("Social Network Title");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "order", Locale.FRANCE)).thenReturn("1");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "url", Locale.FRANCE)).thenReturn("http://socialnetwork.com");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "picto", Locale.FRANCE)).thenReturn("pictoValue");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, "socialNetworkColor", Locale.FRANCE)).thenReturn("#123456");
        when(AssetPublisherTemplateHelper.getDocumentUrl("pictoValue")).thenReturn("pictoUrl");
        when(StrasbourgPropsUtil.getBaseURL()).thenReturn("http://example.com");

        JSONObject result = CSMapJSonHelper.getSocialNetworkCSMapJSON(journalArticleMock);
        Assert.assertNotNull(result);
        Assert.assertEquals(12345L, result.getLong(WSConstants.JSON_WC_ID));
        Assert.assertEquals("Social Network Title", result.getJSONObject(WSConstants.JSON_WC_TITLE).getString(WSConstants.JSON_LANGUAGE_FRANCE));
        Assert.assertEquals("1", result.getString(WSConstants.JSON_WC_ORDER));
        Assert.assertEquals("http://socialnetwork.com", result.getString(WSConstants.JSON_WC_URL));
        Assert.assertEquals("http://example.com/pictoUrl", result.getString(WSConstants.JSON_WC_PICTO));
        Assert.assertEquals("#123456", result.getString(WSConstants.JSON_WC_COLOR));
    }

    @Test
    public void testSimpleContentCSMapJSON() throws Exception {
        List<JournalArticle> generalConditions = Collections.singletonList(journalArticleMock);
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, WSConstants.JSON_WC_CONTENT, Locale.FRANCE)).thenReturn("Content");

        JSONObject result = CSMapJSonHelper.simpleContentCSMapJSON(generalConditions);
        Assert.assertNotNull(result);
        Assert.assertEquals("Content", result.getJSONObject(WSConstants.JSON_WC_TEXT).getString("fr_FR"));
    }

    @Test
    public void testSimplePOIsCSMapJSON() throws Exception {
        List<JournalArticle> SimplePOIs = Collections.singletonList(journalArticleMock);
        when(journalArticleMock.getResourcePrimKey()).thenReturn(12345L);
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, WSConstants.JSON_WC_TITLE, Locale.FRANCE)).thenReturn("SimplePOITitle");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, WSConstants.JSON_DESCRIPTION, Locale.FRANCE)).thenReturn("SimplePOIDescription");
        when(JournalArticleHelper.getJournalArticleFieldValue(journalArticleMock, WSConstants.JSON_IMAGE_URL, Locale.FRANCE)).thenReturn("imageValue");
        when(AssetPublisherTemplateHelper.getDocumentUrl("imageValue")).thenReturn("imageUrl");
        when(StrasbourgPropsUtil.getBaseURL()).thenReturn("http://example.com");
        when(UriHelper.appendUriImagePreview(anyString())).thenReturn(new URI("http://example.com/imageUrl"));

        JSONArray result = CSMapJSonHelper.SimplePOIsCSMapJSON(SimplePOIs,  new Date(), true);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFavoritesCSMapJSON() {
        when(favoriteMock.getFavoriteId()).thenReturn(1L);
        when(favoriteMock.getTitle()).thenReturn("My Favorite");
        when(favoriteMock.getTypeId()).thenReturn(1l);
        when(favoriteMock.getOrder()).thenReturn(1);

        JSONObject result = CSMapJSonHelper.favoritesCSMapJSON(favoriteMock);
        Assert.assertNotNull(result);
        Assert.assertEquals(1L, result.getLong("favoriteId"));
        Assert.assertEquals("My Favorite", result.getString("title"));
        Assert.assertEquals(1, result.getInt("type"));
    }

    @Test
    public void testArretCSMapJSON() {
        when(arretMock.getStopId()).thenReturn("STOP123");
        when(arretMock.getCode()).thenReturn("CODE123");
        when(arretMock.getTitle()).thenReturn("My Stop");
        when(arretMock.getLongitude()).thenReturn("7.75");
        when(arretMock.getLatitude()).thenReturn("48.58");

        JSONObject result = CSMapJSonHelper.arretCSMapJSON(arretMock);
        Assert.assertNotNull(result);
        Assert.assertEquals("STOP123", result.getString("stopId"));
        Assert.assertEquals("CODE123", result.getString("stopCode"));
        Assert.assertEquals("My Stop", result.getString("title"));
        Assert.assertEquals(7.75, result.getDouble("longitude"), 0.001);
        Assert.assertEquals(48.58, result.getDouble("latitude"), 0.001);
    }

    @Test
    public void testLineCSMapJSON() {
        when(ligneMock.getShortName()).thenReturn("L1");
        when(ligneMock.getType()).thenReturn(1);
        when(ligneMock.getBackgroundColor()).thenReturn("#FFFFFF");
        when(ligneMock.getTextColor()).thenReturn("#000000");

        JSONObject result = CSMapJSonHelper.lineCSMapJSON(ligneMock);
        Assert.assertNotNull(result);
        Assert.assertEquals("L1", result.getString("lineNumber"));
        Assert.assertEquals("Bus", result.getString("type"));
        Assert.assertEquals("#FFFFFF", result.getString("backgroundColor"));
        Assert.assertEquals("#000000", result.getString("textColor"));
    }

    @Test
    public void testServiceCSMapJSON() {
        when(serviceNotifMock.getCsmapTopic()).thenReturn("topic1");
        when(serviceNotifMock.getCsmapSubscriptionLabel()).thenReturn("Service Name");
        when(serviceNotifMock.getCsmapSubscriptionMandatory()).thenReturn(true);

        JSONObject result = CSMapJSonHelper.serviceCSMapJSON(serviceNotifMock);
        Assert.assertNotNull(result);
        Assert.assertEquals("topic1", result.getString("topic"));
        Assert.assertEquals("Service Name", result.getString("name"));
        Assert.assertTrue(result.getBoolean("mandatory"));
    }
}
