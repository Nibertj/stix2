
package eu.csaware.stix2.marking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import eu.csaware.stix2.common.ExternalReference;
import eu.csaware.stix2.common.IdentifiedStixObject;
import eu.csaware.stix2.common.LocalDateTimeTypeAdapter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * marking-definition
 * <p>
 * The marking-definition object represents a specific marking.
 */
public class MarkingDefinition extends IdentifiedStixObject {

    /**
     * identifier
     * <p>
     * Represents identifiers across the CTI specifications. The format consists of the name of the top-level object being identified, followed by two dashes (--), followed by a UUIDv4.
     */
    @SerializedName("created_by_ref")
    @Expose
    @Pattern(regexp = "^[a-z][a-z-]+[a-z]--[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")
    private String createdByRef;
    /**
     * timestamp
     * <p>
     * Represents timestamps across the CTI specifications. The format is an RFC3339 timestamp, with a required timezone specification of 'Z'.
     */
    @SerializedName("created")
    @Expose
    @NotNull
    @JsonAdapter(LocalDateTimeTypeAdapter.class)
    private LocalDateTime created;
    /**
     * A list of external references which refers to non-STIX information.
     */
    @SerializedName("external_references")
    @Expose
    @Size(min = 1)
    @Valid
    private List<ExternalReference> externalReferences = new ArrayList<ExternalReference>();
    /**
     * The object_marking_refs property specifies a list of IDs of marking-definition objects that apply to this Marking Definition.
     */
    @SerializedName("object_marking_refs")
    @Expose
    @Size(min = 1)
    @Valid
    private List<Object> objectMarkingRefs = new ArrayList<Object>();
    /**
     * The granular_markings property specifies a list of granular markings applied to this object.
     */
    @SerializedName("granular_markings")
    @Expose
    @Size(min = 1)
    @Valid
    private List<GranularMarking> granularMarkings = new ArrayList<GranularMarking>();

    @SerializedName("definition_type")
    @Expose
    private String definition_type;

    @SerializedName("definition")
    @Expose
    private MarkingObject definition;

    /**
     * No args constructor for use in serialization
     */
    public MarkingDefinition() {
    }

    public MarkingDefinition(UUID uuid, String createdByRef, LocalDateTime created, MarkingObject definition) {
        super(uuid);
        this.createdByRef = createdByRef;
        this.created = created;
        this.definition_type = definition.getDefinitionType();
        this.definition = definition;
    }

    /**
     * identifier
     * <p>
     * Represents identifiers across the CTI specifications. The format consists of the name of the top-level object being identified, followed by two dashes (--), followed by a UUIDv4.
     */
    public String getCreatedByRef() {
        return createdByRef;
    }

    /**
     * identifier
     * <p>
     * Represents identifiers across the CTI specifications. The format consists of the name of the top-level object being identified, followed by two dashes (--), followed by a UUIDv4.
     */
    public void setCreatedByRef(String createdByRef) {
        this.createdByRef = createdByRef;
    }

    /**
     * timestamp
     * <p>
     * Represents timestamps across the CTI specifications. The format is an RFC3339 timestamp, with a required timezone specification of 'Z'.
     */
    public LocalDateTime getCreated() {
        return created;
    }

    /**
     * timestamp
     * <p>
     * Represents timestamps across the CTI specifications. The format is an RFC3339 timestamp, with a required timezone specification of 'Z'.
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    /**
     * A list of external references which refers to non-STIX information.
     */
    public List<ExternalReference> getExternalReferences() {
        return externalReferences;
    }

    /**
     * A list of external references which refers to non-STIX information.
     */
    public void setExternalReferences(List<ExternalReference> externalReferences) {
        this.externalReferences = externalReferences;
    }

    /**
     * The object_marking_refs property specifies a list of IDs of marking-definition objects that apply to this Marking Definition.
     */
    public List<Object> getObjectMarkingRefs() {
        return objectMarkingRefs;
    }

    /**
     * The object_marking_refs property specifies a list of IDs of marking-definition objects that apply to this Marking Definition.
     */
    public void setObjectMarkingRefs(List<Object> objectMarkingRefs) {
        this.objectMarkingRefs = objectMarkingRefs;
    }

    /**
     * The granular_markings property specifies a list of granular markings applied to this object.
     */
    public List<GranularMarking> getGranularMarkings() {
        return granularMarkings;
    }

    /**
     * The granular_markings property specifies a list of granular markings applied to this object.
     */
    public void setGranularMarkings(List<GranularMarking> granularMarkings) {
        this.granularMarkings = granularMarkings;
    }

    public String getDefinition_type() {
        return definition_type;
    }

    public void setDefinition_type(String definition_type) {
        this.definition_type = definition_type;
    }

    public MarkingObject getDefinition() {
        return definition;
    }

    public void setDefinition(MarkingObject definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MarkingDefinition.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("createdByRef");
        sb.append('=');
        sb.append(((this.createdByRef == null) ? "<null>" : this.createdByRef));
        sb.append(',');
        sb.append("created");
        sb.append('=');
        sb.append(((this.created == null) ? "<null>" : this.created));
        sb.append(',');
        sb.append("externalReferences");
        sb.append('=');
        sb.append(((this.externalReferences == null) ? "<null>" : this.externalReferences));
        sb.append(',');
        sb.append("objectMarkingRefs");
        sb.append('=');
        sb.append(((this.objectMarkingRefs == null) ? "<null>" : this.objectMarkingRefs));
        sb.append(',');
        sb.append("granularMarkings");
        sb.append('=');
        sb.append(((this.granularMarkings == null) ? "<null>" : this.granularMarkings));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.externalReferences == null) ? 0 : this.externalReferences.hashCode()));
        result = ((result * 31) + ((this.created == null) ? 0 : this.created.hashCode()));
        result = ((result * 31) + ((this.granularMarkings == null) ? 0 : this.granularMarkings.hashCode()));
        result = ((result * 31) + ((this.createdByRef == null) ? 0 : this.createdByRef.hashCode()));
        result = ((result * 31) + ((this.objectMarkingRefs == null) ? 0 : this.objectMarkingRefs.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MarkingDefinition) == false) {
            return false;
        }
        MarkingDefinition rhs = ((MarkingDefinition) other);
        return (((((((this.externalReferences == rhs.externalReferences) || ((this.externalReferences != null) && this.externalReferences.equals(rhs.externalReferences))) && ((this.created == rhs.created) || ((this.created != null) && this.created.equals(rhs.created)))) && ((this.granularMarkings == rhs.granularMarkings) || ((this.granularMarkings != null) && this.granularMarkings.equals(rhs.granularMarkings)))) && ((this.createdByRef == rhs.createdByRef) || ((this.createdByRef != null) && this.createdByRef.equals(rhs.createdByRef)))) && ((this.objectMarkingRefs == rhs.objectMarkingRefs) || ((this.objectMarkingRefs != null) && this.objectMarkingRefs.equals(rhs.objectMarkingRefs)))));
    }
}
