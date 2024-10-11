package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;

public class DocumentTypeDTO {
    private Integer idDocumentType;
    private String documentType;

    public DocumentTypeDTO() {

    }

    public DocumentTypeDTO(Integer idDocumentType, String documentType) {
        this.idDocumentType = idDocumentType;
        this.documentType = documentType;
    }

    public Integer getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(Integer idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}
