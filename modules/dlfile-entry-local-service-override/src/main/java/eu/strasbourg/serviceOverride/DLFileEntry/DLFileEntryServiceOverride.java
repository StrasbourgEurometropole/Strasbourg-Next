package eu.strasbourg.serviceOverride.DLFileEntry;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceWrapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
//import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.portal.image.ImageToolUtil;

import eu.strasbourg.utils.StrasbourgPropsUtil;
import org.osgi.service.component.annotations.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.IIOImage;
import javax.imageio.ImageWriteParam;
import javax.imageio.stream.MemoryCacheImageOutputStream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * @author louis.politanski
 */
@Component(
        immediate = true,
        property = {
        },
        service = ServiceWrapper.class
)
public class DLFileEntryServiceOverride extends DLFileEntryLocalServiceWrapper {

    public DLFileEntryServiceOverride() {
        super(null);
    }

    @Override
    public DLFileEntry addFileEntry(
            String externalReferenceCode, long userId, long groupId, long repositoryId,
            long folderId, String sourceFileName, String mimeType, String title, String urlTitle,
            String description, String changeLog, long fileEntryTypeId,
            Map <String, DDMFormValues> ddmFormValuesMap, File file, InputStream is, long size,
            Date expirationDate, Date reviewDate, ServiceContext serviceContext) throws PortalException {
        DLFileEntry entry = DLFileEntryLocalServiceUtil.fetchFileEntry(groupId, folderId, title);
        Map<String, Object> map = new HashMap<>(overrideDLFileEntry(entry,sourceFileName, mimeType, title, file, is, size));
        sourceFileName = (String) map.get("sourceFileName");
        mimeType = (String) map.get("mimeType");
        title = (String) map.get("title");
        file = (File) map.get("file");
        is = (InputStream) map.get("is");
        size = (long) map.get("size");
        return super.addFileEntry(externalReferenceCode, userId, groupId, repositoryId, folderId, sourceFileName,
                mimeType, title, urlTitle, description, changeLog, fileEntryTypeId, ddmFormValuesMap, file,
                is, size, expirationDate, reviewDate, serviceContext);
    }

    @Override
    public DLFileEntry updateFileEntry(
            long userId, long fileEntryId, String sourceFileName, String mimeType, String title, String urlTitle,
            String description, String changeLog, DLVersionNumberIncrease dlVersionNumberIncrease,
            long fileEntryTypeId, Map<String, DDMFormValues> ddmFormValuesMap, File file,
            InputStream is, long size, Date expirationDate, Date reviewDate, ServiceContext serviceContext)
            throws PortalException {
        DLFileEntry entry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileEntryTypeId);
        Map<String, Object> map = new HashMap<>(overrideDLFileEntry(entry, sourceFileName,
                mimeType, title,
                file, is, size));
        sourceFileName = (String) map.get("sourceFileName");
        mimeType = (String) map.get("mimeType");
        title = (String) map.get("title");
        file = (File) map.get("file");
        is = (InputStream) map.get("is");
        size = (long) map.get("size");
        return super.updateFileEntry(userId, fileEntryId, sourceFileName, mimeType, title, urlTitle,
                description, changeLog, dlVersionNumberIncrease, fileEntryTypeId, ddmFormValuesMap, file,
                is, size, expirationDate, reviewDate, serviceContext);
    }

    private RenderedImage readImage(boolean imageInFile, InputStream is, File file) throws IOException {
        RenderedImage image;
        if (!imageInFile) {
            image = ImageIO.read(is);
        } else {
            image = ImageIO.read(file);
        }
        return image;
    }

    private InputStream saveImage(boolean imageInFile, ByteArrayOutputStream baos, File file) throws IOException {
        if (imageInFile) {
            Path path = Paths.get(file.getPath());
            Files.write(path, baos.toByteArray());
            return null;
        } else {
            return new ByteArrayInputStream(baos.toByteArray());
        }
    }

    private ByteArrayOutputStream compressImage(RenderedImage image, float quality) throws IOException {
        // Configuration des parametres de compression
        ImageWriter jpgWriter = ImageIO.getImageWritersByMIMEType("image/jpeg").next();
        ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
        jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpgWriteParam.setCompressionQuality(quality);
        // Configuration de l'output de compression
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        jpgWriter.setOutput(new MemoryCacheImageOutputStream(baos));
        IIOImage outputImage = new IIOImage(image, null, null);
        // Compression
        jpgWriter.write(null, outputImage, jpgWriteParam);
        baos.flush();
        jpgWriter.dispose();
        return baos;
    }

    private Map<String, Object> overrideDLFileEntry(DLFileEntry entry , String sourceFileName,
                                                    String mimeType, String title,
                                                    File file, InputStream is, long size){

        Map<String, Object> map = new HashMap<>();

        // On verifie ou se trouve le document d'entree
        InputStream copiedIs = null;
        boolean imageInFile;
        if (file != null) {
            // sélection (depuis son ordi) d'une image dans un contenu web
            // enregistrement d'un contenu web avec une image
            imageInFile = true;
        } else if (is != null) {
            // ajout ou modification d'un fichier dans document et média
            // sélection (depuis son ordi) d'une image dans un BO
            imageInFile = false;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (true) {
                try {
                    if (!((n = is.read(buf)) >= 0)) break;
                } catch (IOException e) {
                    _log.error(e);
                }
                baos.write(buf, 0, n);
            }
            is = new ByteArrayInputStream(baos.toByteArray());
            copiedIs = new ByteArrayInputStream(baos.toByteArray());
        } else {
            map.put("sourceFileName",sourceFileName);
            map.put("mimeType",mimeType);
            map.put("title",title);
            map.put("file",file);
            map.put("is",is);
            map.put("size",size);
            return map;
        }
        // Lecture de l'image
        RenderedImage image;
        try {
            if (entry == null && (mimeType.equals("image/jpeg") || mimeType.equals("image/png"))) {
                image = readImage(imageInFile, copiedIs, file);
                int height = image.getHeight();
                int width = image.getWidth();

                if (entry == null && mimeType.equals("image/jpeg")) {
                    _log.info("Image JPEG detectee");

                    float compressionRatio = (float) width * height / size;
                    if (height > 1920 || width > 1920) {
                        _log.info("Scaling et compression");
                        // Scaling
                        image = ImageToolUtil.scale(image, 1920, 1920);
                        // Compression
                        float compressionQuality = 0.88f;
                        ByteArrayOutputStream baos = compressImage(image, compressionQuality);
                        // Remplacement de l'image
                        is = saveImage(imageInFile, baos, file);
                        size = baos.size();
                    } else if (compressionRatio < 7) {
                        _log.info("Compression");
                        // Compression
                        float compressionQuality = 0.88f;
                        ByteArrayOutputStream baos = compressImage(image, compressionQuality);
                        // Calcul du nouveau pourcentage de compression
                        float newCompressionRatio = 100 * (float) baos.size() / size;
                        // Remplacement de l'image si le pourcentage de compression est satisfaisant
                        if (newCompressionRatio < 90) {
                            is = saveImage(imageInFile, baos, file);
                            size = baos.size();
                        } else {
                            _log.info("Compression insatisfaisante, on garde le JPEG d’origine.");
                        }
                    }
                } else {
                    // on vérifie que le fichier n'est pas préfixé par bypass-compress-
                    if(!sourceFileName.startsWith("bypass-compress-")) {
                        int limitNbPixels = height * width / 4;
                        boolean isPng = entry == null && mimeType.equals("image/png");
                        boolean isSizeBiggerThan500ko = size >= 500000;
                        boolean isSizeSmallerThan500ko = size < 500000;

                        boolean isPngBiggerThan500ko = isPng && isSizeBiggerThan500ko;
                        boolean isSmallButHeavyPng = isPng && isSizeSmallerThan500ko && size > limitNbPixels;

                        if (isPngBiggerThan500ko || isSmallButHeavyPng) {
                            _log.info("PNG lourd detecte");
                            // Scaling
                            if (height > 1920 || width > 1920) {
                                _log.info("Scaling");
                                image = ImageToolUtil.scale(image, 1920, 1920);
                            }
                            // Elimination de la transparence du PNG
                            BufferedImage newImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
                            newImg.createGraphics().drawImage((Image) image, 0, 0, Color.WHITE, null);
                            image = newImg;
                            // Compression
                            float compressionQuality = 0.88f;
                            ByteArrayOutputStream baos = compressImage(image, compressionQuality);
                            // Calcul du nouveau pourcentage de compression
                            float newCompressionRatio = 100 * (float) baos.size() / size;
                            // Remplacement de l'image si le pourcentage de compression est satisfaisant
                            if (newCompressionRatio < 90) {
                                _log.info("On remplace le PNG.");
                                is = saveImage(imageInFile, baos, file);
                                size = baos.size();
                                // Modif extension fichier
                                mimeType = "image/jpeg";
                                if (sourceFileName.endsWith(".png")) {
                                    sourceFileName = sourceFileName.substring(0, sourceFileName.length() - 4) + ".jpg";
                                    _log.info("Nouveau nom de fichier:" + sourceFileName);
                                }
                                if (title.endsWith(".png")) {
                                    title = title.substring(0, title.length() - 4) + ".jpg";
                                    _log.info("Nouveau titre (doclib):" + title);
                                }
                            } else {
                                _log.info("Compression insatisfaisante, on garde le PNG.");
                            }
                        }
                    } else {
                        _log.info("Bypass de la compression pour le fichier : " + sourceFileName);
                    }
                }
            }
        } catch (Exception e) {
            _log.error(e);
        }
        map.put("sourceFileName",sourceFileName);
        map.put("mimeType",mimeType);
        map.put("title",title);
        map.put("file",file);
        map.put("is",is);
        map.put("size",size);
        return map;
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}