
package eu.strasbourg.asset.category.selector.taglib;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;
import eu.strasbourg.asset.category.selector.internal.ServletContextUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

public class AssetCategorySelectorTag extends IncludeTag {

    private static final String PAGE = "/html/asset-category-selector-taglib.jsp";

    private String id;
    private String label;
    private String groupIds;
    private String classname;
    private String classtype;
    private String required;
    private String values;
    private String multiple;

    @Override
    public void setPageContext(PageContext pageContext) {
        super.setPageContext(pageContext);
        setServletContext(ServletContextUtil.getServletContext());
    }

    @Override
    protected void cleanUp() {
        groupIds = null;
        classname = null;
    }

    @Override
    protected String getPage() {
        return PAGE;
    }

    @Override
    protected void setAttributes(HttpServletRequest request) {
        request.setAttribute("id", id);
        request.setAttribute("groupIds", groupIds);
        request.setAttribute("classname", classname);
        request.setAttribute("classtype", classtype);
        request.setAttribute("label", label);
        request.setAttribute("required", "true".equals(required));
        request.setAttribute("values", Validator.isNull(values) ? "" : values);
        request.setAttribute("multiple", multiple);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void setClasstype(String classtype) {
        this.classtype = classtype;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

}