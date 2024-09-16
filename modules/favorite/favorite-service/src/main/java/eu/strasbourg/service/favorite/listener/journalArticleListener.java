package eu.strasbourg.service.favorite.listener;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.favorite.model.FavoriteType;
import eu.strasbourg.service.favorite.service.FavoriteLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ModelListener.class)
public class journalArticleListener extends BaseModelListener<JournalArticle> {
	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

	/**
	 * A la suppression d'un journalArticle, on supprime les favoris pouvant exister dessus
	 */
	@Override
	public void onBeforeUpdate(JournalArticle originalModel, JournalArticle model) throws ModelListenerException {
		try {
			if(model.getStatus() == WorkflowConstants.STATUS_IN_TRASH)
				_favoriteLocalService.deleteFavoriteByGroupIdEntityIdAndType(model.getGroupId(),
						Long.parseLong(originalModel.getArticleId()),
						FavoriteType.NEWS.getId());
		}catch (Exception e){
			_log.error(e.getMessage());
		}
	}

	private FavoriteLocalService _favoriteLocalService;

	@Reference(unbind = "-")
	protected void setFavoriteLocalService(
			FavoriteLocalService favoriteLocalService) {

		_favoriteLocalService = favoriteLocalService;
	}

}