package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tipo_documento")
public class DocumentType {
    @Id
    @Column(name = "id_tipo_documento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocumentType;

    @Column(name = "nombre_tipo_documento")
    private String documentType;

    public DocumentType() {

    }
    public DocumentType(String documentType) {
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
