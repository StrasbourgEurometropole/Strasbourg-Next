package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.model.Layout;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.service.edition.model.EditionGallery;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.project.model.*;
import eu.strasbourg.service.video.model.Video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetHandlerFactory {
    private static final Map<String, AssetHandler> handlers = new HashMap<>();

    static {
        handlers.put(Event.class.getName(), new EventHandler());
        handlers.put(Project.class.getName(), new ProjectHandler());
        handlers.put(Participation.class.getName(), new ParticipationHandler());
        handlers.put(Petition.class.getName(), new PetitionHandler());
        handlers.put(Layout.class.getName(), new LayoutHandler());
        handlers.put(ActivityCourse.class.getName(), new ActivityCourseHandler());
        handlers.put(Activity.class.getName(), new ActivityHandler());
        handlers.put(BudgetParticipatif.class.getName(), new BudgetParticipatifHandler());
        handlers.put(EditionGallery.class.getName(), new EditionGalleryHandler());
        handlers.put(Edition.class.getName(), new EditionHandler());
        handlers.put(Initiative.class.getName(), new InitiativeHandler());
        handlers.put(Place.class.getName(), new PlaceHandler());
        handlers.put(Video.class.getName(), new VideoHandler());
        handlers.put(Official.class.getName(), new OfficialHandler());
        handlers.put(JournalArticle.class.getName(), new JournalArticleHandler());
        handlers.put(Manifestation.class.getName(), new ManifestationHandler());
    }

    public static List<String> getSupportedAssetTypes() {
        return new ArrayList<>(handlers.keySet());
    }

    public static AssetHandler getHandler(String className) {
        return handlers.get(className);
    }
}
