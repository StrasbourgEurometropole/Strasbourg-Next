package eu.strasbourg.service.artwork.upgrade.v1_1_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringUtil;
import eu.strasbourg.service.artwork.model.Artwork;
import eu.strasbourg.service.artwork.model.ArtworkCollection;
import eu.strasbourg.service.artwork.service.ArtworkCollectionLocalServiceUtil;
import eu.strasbourg.service.artwork.service.ArtworkLocalServiceUtil;

import java.util.List;

public class UpgradeSchema extends UpgradeProcess {

    @Override
    protected void doUpgrade() throws Exception {
        List<Artwork> artworks = ArtworkLocalServiceUtil.getArtworks(-1,-1);
        for (Artwork artwork : artworks) {
            try{
                ArtworkLocalServiceUtil.removeArtwork(artwork.getArtworkId());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        List<ArtworkCollection> artworkCollections = ArtworkCollectionLocalServiceUtil.getArtworkCollections(-1,-1);
        for (ArtworkCollection artworkCollection : artworkCollections) {
            try{
                ArtworkCollectionLocalServiceUtil.removeArtworkCollection(artworkCollection.getCollectionId());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        String template = StringUtil.read(
                UpgradeSchema.class.getResourceAsStream("dependencies/update.sql"));
        runSQLTemplateString(template, false, false);
    }
}
