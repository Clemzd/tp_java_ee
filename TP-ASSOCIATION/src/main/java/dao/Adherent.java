/*
 * Created on 7 oct. 2013 ( Time 10:16:39 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
// This Bean has a basic Primary Key (not composite) 

package dao;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Persistent class for entity stored in table "ADHERENT"
 *
 * @author Telosys Tools Generator
 *
 */
@XmlRootElement  // JAXB annotation for REST Web Services
@XmlAccessorType(XmlAccessType.PROPERTY) // JAXB accessor = getter/setter pair
@Entity
@Table(name="ADHERENT", schema="ROOT" )
// Define named queries here
// @NamedQueries ( {
//  @NamedQuery ( name="Adherent.query1", query="SELECT x FROM Adherent x WHERE  " ),
//  @NamedQuery ( name="Adherent.query2", query="SELECT x FROM Adherent x WHERE  " )
// } )
public class Adherent implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="IDENTIFIANT", nullable=false, length=255)
    private String     identifiant  ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="MOTDEPASSE", nullable=false, length=255)
    private String     motdepasse   ;

    @Column(name="NOMDEFAMILLE", nullable=false, length=255)
    private String     nomdefamille ;

    @Column(name="PRENOM", nullable=false, length=255)
    private String     prenom       ;

    @Column(name="RUE", length=255)
    private String     rue          ;

    @Column(name="CODEPOSTAL", length=255)
    private String     codepostal   ;

    @Column(name="VILLE", length=255)
    private String     ville        ;

    @Column(name="PAYS", length=255)
    private String     pays         ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Adherent()
    {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdentifiant( String identifiant )
    {
        this.identifiant = identifiant ;
    }
    public String getIdentifiant()
    {
        return this.identifiant;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : MOTDEPASSE ( VARCHAR ) 
    public void setMotdepasse( String motdepasse )
    {
        this.motdepasse = motdepasse;
    }
    public String getMotdepasse()
    {
        return this.motdepasse;
    }

    //--- DATABASE MAPPING : NOMDEFAMILLE ( VARCHAR ) 
    public void setNomdefamille( String nomdefamille )
    {
        this.nomdefamille = nomdefamille;
    }
    public String getNomdefamille()
    {
        return this.nomdefamille;
    }

    //--- DATABASE MAPPING : PRENOM ( VARCHAR ) 
    public void setPrenom( String prenom )
    {
        this.prenom = prenom;
    }
    public String getPrenom()
    {
        return this.prenom;
    }

    //--- DATABASE MAPPING : RUE ( VARCHAR ) 
    public void setRue( String rue )
    {
        this.rue = rue;
    }
    public String getRue()
    {
        return this.rue;
    }

    //--- DATABASE MAPPING : CODEPOSTAL ( VARCHAR ) 
    public void setCodepostal( String codepostal )
    {
        this.codepostal = codepostal;
    }
    public String getCodepostal()
    {
        return this.codepostal;
    }

    //--- DATABASE MAPPING : VILLE ( VARCHAR ) 
    public void setVille( String ville )
    {
        this.ville = ville;
    }
    public String getVille()
    {
        return this.ville;
    }

    //--- DATABASE MAPPING : PAYS ( VARCHAR ) 
    public void setPays( String pays )
    {
        this.pays = pays;
    }
    public String getPays()
    {
        return this.pays;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString()
    {
        StringBuffer sb = new StringBuffer(); 
        sb.append(identifiant); 
        sb.append("|"); 
        sb.append(motdepasse); 
        sb.append( "|" ); 
        sb.append(nomdefamille); 
        sb.append( "|" ); 
        sb.append(prenom); 
        sb.append( "|" ); 
        sb.append(rue); 
        sb.append( "|" ); 
        sb.append(codepostal); 
        sb.append( "|" ); 
        sb.append(ville); 
        sb.append( "|" ); 
        sb.append(pays); 
        return sb.toString(); 
    }

}