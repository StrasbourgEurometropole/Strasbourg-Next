package eu.strasbourg.portlet.dynamic_search_asset.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
	category = "Strasbourg",
	scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
	id = "eu.strasbourg.portlet.dynamic_search_asset.configuration.DynamicSearchAssetConfiguration", 
	localization = "content/Language", 
	name = "portlet.dynamic_search_asset.configuration.name"
)
public interface DynamicSearchAssetConfiguration {

	@Meta.AD(name = "assetClassNamesIds", required = false)
	public String assetClassNamesIds();
	
	@Meta.AD(name = "assetClassNames", required = false)
	public String assetClassNames();
	
	@Meta.AD(name = "searchNews", required = false)
	public boolean searchNews();
	
	@Meta.AD(name = "searchDocument", required = false)
	public boolean searchDocument();
	
	@Meta.AD(name = "globalScope", required = false)
	public boolean globalScope();
	
	@Meta.AD(name = "searchForm", required = false)
	public String searchForm();
	
	@Meta.AD(name = "prefilterCategoriesIds", required = false)
	public String prefilterCategoriesIds();

	@Meta.AD(name = "prefilterTagsNames", required = false)
	public String prefilterTagsNames();
	
	@Meta.AD(name = "boostTagsNames", required = false)
	public String boostTagsNames();
	
	@Meta.AD(name = "dateField", required = false)
	public boolean dateField();
	
	@Meta.AD(name = "delta", required = false)
	public long delta();
	
	@Meta.AD(name = "dateRangeFrom", required = false, deflt = "0")
	public long dateRangeFrom();
	
	@Meta.AD(name = "dateRangeTo", required = false, deflt = "60")
	public long dateRangeTo();
	
	@Meta.AD(name = "dynamicSearch", required = false)
	public boolean dynamicSearch();
	
}
