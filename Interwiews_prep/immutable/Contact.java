package Interwiews_prep.immutable;

public final class Contact {
    private final String personal_contact;
    private final String residential_contact;
    private final String emergency_contact ;

    public Contact(String personalContact, String residentialContact, String emergencyContact) {
        this.personal_contact = personalContact;
        this.residential_contact = residentialContact;
        this.emergency_contact = emergencyContact;
    }
    public Contact(Contact contact) {
        this.personal_contact = (contact != null) ? contact.personal_contact : null;
        this.residential_contact = (contact != null) ? contact.residential_contact : null;
        this.emergency_contact = (contact != null) ? contact.emergency_contact : null;
    }

    public String getPersonal_contact() {
        return personal_contact;
    }

    public String getResidential_contact() {
        return residential_contact;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }
}
