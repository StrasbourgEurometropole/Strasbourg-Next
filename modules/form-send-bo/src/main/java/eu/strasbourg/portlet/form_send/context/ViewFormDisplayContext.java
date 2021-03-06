package eu.strasbourg.portlet.form_send.context;

import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import eu.strasbourg.utils.display.context.ViewListBaseDisplayContext;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewFormDisplayContext extends ViewListBaseDisplayContext<DDMFormInstance> {

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    private List<DDMFormInstance> _forms;

    public ViewFormDisplayContext(RenderRequest request, RenderResponse response) {
        super(DDMFormInstance.class, request, response);
    }

    public List<DDMFormInstance> getForms() throws PortalException {
        if (this._forms == null) {
            Hits hits = getHits(this._themeDisplay.getScopeGroupId());
            //Création de la liste d'objet
            this._forms = populateForms(hits);
        }
        return this._forms;
    }

    private List<DDMFormInstance> populateForms(Hits hits) {
        List<DDMFormInstance> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                DDMFormInstance form = DDMFormInstanceLocalServiceUtil.fetchFormInstance(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (form != null) {
                    results.add(form);
                }
            }
        }
        return results;
    }
}
