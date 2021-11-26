/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;




import org.apache.commons.io.FilenameUtils;

import it.csi.taif.taifweb.business.helper.dto.MetadatiIndex;
import it.csi.taif.taifweb.util.Constants;
import it.doqui.index.ecmengine.client.webservices.dto.Node;
import it.doqui.index.ecmengine.client.webservices.dto.OperationContext;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Content;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Mimetype;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Property;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.SearchParams;

/**
 * Classe factory per <code>DTO</code> utilizzati nel contesto
 * delle operazioni col servizio <code>INDEX</code>.
 *
 * @author 71740 (Simone Cornacchia)
 */
public final class IndexDtoFactory {

    /**
     * Parametro di Ricerca, Limite = 0.
     */
    public static final int SEARCH_PARAM_LIMIT_0 = 0;

    /**
     * Parametro di Ricerca, Limite = 1.
     */
    public static final int SEARCH_PARAM_LIMIT_1 = 1;


    /**
     * Crea e restituisce un'istanza {@link OperationContext}.
     *
     * @param user nome utente
     * @return un'istanza {@link OperationContext}
     */
    public static OperationContext createOperationContext(String user) {
        final OperationContext ctx = new OperationContext();
        ctx.setUsername(user);
        ctx.setPassword(Constants.INDEX_PSW);
        ctx.setNomeFisico(Constants.INDEX_UTENTE);
        ctx.setFruitore(Constants.INDEX_FRUITORE);
        ctx.setRepository(Constants.INDEX_REPOSITORY);

        return ctx;
    }

    /**
     * Crea e restituisce un'istanza {@link SearchParams}.
     *
     * @param limit limite
     * @return un'istanza {@link SearchParams}.
     */
    public static SearchParams createSearchParams(int limit) {
        final SearchParams params = new SearchParams();
        params.setLimit(limit);

        return params;
    }

    /**
     * Crea e restituisce un'istanza {@link SearchParams}.
     *
     * @return un'istanza {@link SearchParams}
     */
    public static SearchParams createSearchParamsForRootFolder() {
        final SearchParams params      = createSearchParams(SEARCH_PARAM_LIMIT_1);
        final String       luceneQuery = createLuceneQueryForRootFolder();

        params.setXPathQuery(luceneQuery);

        return params;
    }

    /**
     * Crea e restituisce un'istanza {@link SearchParams}.
     *
     * @param metadati istanza di tipo {@link MetadatiIndex}
     * @return un'istanza {@link SearchParams}
     */
    
    
    /**
     * Crea e restituisce un'istanza {@link SearchParams}.
     *
     * @param metadati istanza di tipo {@link MetadatiIndex}
     * @return un'istanza {@link SearchParams}
     */
    public static SearchParams createSearchParamsForIndexFolder(String luceneQuery) {
        final SearchParams params      = createSearchParams(SEARCH_PARAM_LIMIT_1);
        
        params.setXPathQuery(luceneQuery);

        return params;
    }

    /**
     * Crea e restituisce un'istanza {@link SearchParams}.
     *
     * @param idAllegato identificativo dell'Allegato da scaricare
     * @return un'istanza {@link SearchParams}.
     */
    public static SearchParams createSearchParamsForIndexUid(String idAllegato) {
        final SearchParams params      = createSearchParams(SEARCH_PARAM_LIMIT_0);
        final String       luceneQuery = createLuceneQueryForIndexDownload(idAllegato);

        params.setLuceneQuery(luceneQuery);

        return params;
    }

    /**
     * Crea e restituisce un'istanza {@link SearchParams}.
     *
     * @param metadati istanza di tipo {@link MetadatiIndex}
     * @param fileName nome del file del quale recuperare l'<code>UID</code>
     * @return un'istanza {@link SearchParams}.
     */
   

    /**
     * Crea e restituisce un'istanza {@link Content} per la <em>folder</em> della quale &egrave; stato specificato il nome.
     *
     * @param folderName nome della <em>folder</em>
     * @return un'istanza {@link Content}
     */
    public static Content createContentFolder(String folderName) {
        final Content contentFolder = new Content();
        contentFolder.setPrefixedName(Constants.INDEX_DEFAULT_PREFIX + folderName);
        contentFolder.setParentAssocTypePrefixedName(Constants.INDEX_PREFIX_CONTAINS);
        contentFolder.setModelPrefixedName(Constants.INDEX_PREFIX_MODEL);
        contentFolder.setTypePrefixedName(Constants.INDEX_PREFIX_FOLDER);
        contentFolder.setProperties(createContentFolderProperties(folderName));

        return contentFolder;
    }

    /**
     *
     * @param folderName
     * @return
     */
    public static Property[] createContentFolderProperties(String folderName) {
        final Property p = new Property();
        p.setPrefixedName(Constants.INDEX_PREFIX_NAME_SHORT);
        p.setDataType("text");
        p.setValues(new String [] { folderName });

        return new Property[] { p };
    }

    /**
     * Crea e restituisce un'istanza {@link Node} per l'<code>UID</code> dato.
     *
     * @param uid l'<code>UID</code>
     * @return un'istanza {@link Node}
     */
    public static Node createNode(String uid) {
        return new Node(uid);
    }

    /**
     * Crea e restituisce un'istanza {@link Mimetype} per un file del quale &egrave; stato indicato il nome.
     *
     * @param fileName nome del file
     * @return un'istanza {@link Mimetype}
     */
    public static Mimetype createMimetypeFromFileName(String fileName) {
        final Mimetype mimeType = new Mimetype();
        mimeType.setFileExtension(FilenameUtils.getExtension(fileName));

        return mimeType;
    }

    /**
     * Crea e restituisce un'istanza {@link Content} per il <em>file</em> del quale &egrave; stato specificato il nome, il contenuto ed il mimeType.
     *
     * @param metadati metadati
     * @param fileName nome del file
     * @param file contenuto del file del quale &egrave; stato indicato il nome
     * @param mimeType mimeType
     * @return un'istanza {@link Content}
     */
    public static Content createContent(MetadatiIndex metadati, String fileName, byte[] file, String mimeType) {
        final Content content = createContent(fileName, mimeType);
        content.setModelPrefixedName(Constants.INDEX_TAIF_PREFIX_MODEL);
        content.setProperties(createContentProperties(metadati));
        content.setContent(file);

        return content;
    }
    
    public static Content createContent() {
    	final Content content = new Content();
    	content.setContentPropertyPrefixedName(Constants.INDEX_PREFIX_NAME);
    	return content;
    }

    /**
     * Crea e restituisce un'istanza {@link Content} per il <em>file</em> del quale &egrave; stato specificato il nome ed il mimeType.
     *
     * @param fileName nome del file
     * @param mimeType mimeType
     * @return un'istanza {@link Content}
     */
    public static Content createContent(String fileName, String mimeType) {
        final Content content = createContent();
        content.setPrefixedName(Constants.INDEX_PREFIX + fileName);
        content.setParentAssocTypePrefixedName(Constants.INDEX_PREFIX_CONTAINS);
        content.setTypePrefixedName(Constants.INDEX_ALLEGATO_NAME);
        content.setMimeType(mimeType);
        content.setEncoding(Constants.INDEX_ENCODING);

        return content;
    }

    /**
     *
     * @param metadati
     * @return
     */
    public static Property[] createContentProperties(MetadatiIndex metadati) {
        final Property[] result = new Property[6];

        result[0] = new Property();
		result[0].setDataType(Constants.INDEX_TYPE_TEXT);
		result[0].setPrefixedName(MetadatiIndex.META_ID_AZIENDA);
		result[0].setValues(new String[] { metadati.getIdAzienda() });

		result[0] = new Property();
		result[0].setDataType(Constants.INDEX_TYPE_TEXT);
		result[0].setPrefixedName(MetadatiIndex.META_ID_ALLEGATO);
		result[1].setValues(new String[] { metadati.getIdAllegato() });

		result[2] = new Property();
		result[2].setDataType(Constants.INDEX_TYPE_TEXT);
		result[2].setPrefixedName(MetadatiIndex.META_ID_TIPOLOGIA);
		result[2].setValues(new String[] { metadati.getIdTipologia() });

		result[3] = new Property();
		result[3].setDataType(Constants.INDEX_TYPE_TEXT);
		result[3].setPrefixedName(MetadatiIndex.META_ID_CORSO);
		result[3].setValues(new String[] { metadati.getIdCorso() });

        return result;
    }

    /**
     *
     * @return
     */
    public static String createLuceneQueryForRootFolder() {
        final StringBuilder luceneQuery = new StringBuilder(Constants.INDEX_ROOT);

        return luceneQuery.toString();
    }

   
   


   /**
    *
    * @param idIstanza
    * @param idTipologia
    * @return
    */
   public static String createLuceneQueryForElencoUid(String idIstanza, int idTipologia) {
       final StringBuilder luceneQuery = new StringBuilder();

       luceneQuery.append("PATH:")
                  .append(Constants.INDEX_ROOT)
                  .append(Constants.INDEX_FOLDER_SUFFIX)
                  .append(idIstanza)
                  .append(Constants.INDEX_FOLDER_SUFFIX)
                  .append(idTipologia);

       return luceneQuery.toString();
   }

    

    /**
     *
     * @param idAllegato
     * @return
     */
    private static String createLuceneQueryForIndexDownload(String idAllegato) {
        final StringBuilder luceneQuery = new StringBuilder();

        luceneQuery.append("@taif\\:idAllegato:\"")
                   .append(idAllegato)
                   .append("\"");

        return luceneQuery.toString();
    }

    /**
     *
     * @param metadati
     * @param fileName
     * @return
     */
    

    /**
     * Constructor.
     */
    private IndexDtoFactory() {
        /* NOP */
    }

}
